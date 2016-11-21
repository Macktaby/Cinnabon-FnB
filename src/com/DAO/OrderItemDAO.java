package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.models.*;

public class OrderItemDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public OrderItemDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public String addOrderItems(List<OrderItem> orderItems, int orderID, int branchID) {

		for (OrderItem orderItem : orderItems) {
			try {
				String sql = "INSERT INTO `order_items` "
						+ "(`order_id`, `item_id`, `size_id`, `quantity`) VALUES (?, ?, ?, ?);";

				stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, orderID);
				stmt.setInt(2, orderItem.getItem().getItemID());
				stmt.setInt(3, orderItem.getSize().getSizeID());
				stmt.setInt(4, orderItem.getQuantity());

				stmt.executeUpdate();

				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					addOrderItemIngredients(id, orderItem.getIngredients());
				}else 
					return "false";

			} catch (SQLException ex) {
				ex.printStackTrace();
				return ex.getMessage();
			}
		}

		return "Done";
	}

	private void addOrderItemIngredients(int id, ArrayList<Ingredient> ingredients) throws SQLException {

		for (Ingredient ingredient : ingredients) {
			String sql = "INSERT INTO `order_item_ingredients` "
					+ "( `order_item_id` , `ingredient_id`) VALUES ( ? , ? );";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setInt(2, ingredient.getIngredientID());

			stmt.executeUpdate();
		}

	}

}
