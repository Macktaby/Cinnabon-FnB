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

	private OrderItem parseOrderItem() throws SQLException {
		OrderItem orderItem = new OrderItem();

		orderItem.setOrderItemID(rs.getInt("order_items.order_item_id"));
		orderItem.setQuantity(rs.getInt("order_items.quantity"));
		orderItem.setSize(parseSize());
		orderItem.setItem(parseItem());
		orderItem.setIngredients(getOrderItemIngredients(orderItem.getOrderItemID()));

		return orderItem;
	}

	public Item parseItem() throws SQLException {
		Item item = new Item();

		item.setItemID(rs.getInt("item.item_id"));
		item.setItemName(rs.getString("item.item_name"));
		item.setDescription(rs.getString("item.item_desc"));
		item.setLikes(rs.getInt("item.likes"));
		item.setDislikes(rs.getInt("item.dislikes"));
		item.setCalories(rs.getInt("item.calories"));
		item.setnPersons(rs.getInt("item.nPersons"));

		return item;
	}

	public Size parseSize() throws SQLException {
		Size size = new Size();

		size.setSizeID(rs.getInt("size.size_id"));
		size.setSizeName(rs.getString("size.size_name"));
		size.setSizePrice(rs.getDouble("size.price"));

		return size;
	}

	private Ingredient parseOrderItemIngredient() throws SQLException {
		Ingredient ingredient = new Ingredient();

		ingredient.setIngredientID(rs.getInt("ingredient.ingredient_id"));
		ingredient.setIngredientName(rs.getString("ingredients.ingredient_name"));

		return ingredient;
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
				} else
					return "false";

			} catch (SQLException ex) {
				ex.printStackTrace();
				return ex.getMessage();
			}
		}

		return "Done";
	}

	public void addOrderItemIngredients(int id, ArrayList<Ingredient> ingredients) throws SQLException {

		for (Ingredient ingredient : ingredients) {
			String sql = "INSERT INTO `order_item_ingredients` "
					+ "( `order_item_id` , `ingredient_id`) VALUES ( ? , ? );";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setInt(2, ingredient.getIngredientID());

			stmt.executeUpdate();
		}

	}

	public List<OrderItem> getOrderItems(int orderID) {
		try {
			String sql = "SELECT * FROM order_items, item, size WHERE order_items.order_id = ? "
					+ "AND order_items.item_id = item.item_id AND order_items.size_id = size.size_id";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderID);

			rs = stmt.executeQuery();

			ArrayList<OrderItem> orderItems = new ArrayList<>();

			while (rs.next())
				orderItems.add(parseOrderItem());

			return orderItems;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Ingredient> getOrderItemIngredients(int orderItemID) {
		try {
			String sql = "SELECT * FROM order_item_ingredients, ingredients WHERE order_item_id = ? "
					+ "AND order_item_ingredients.ingredient_id = ingredients.ingredient_id;";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderItemID);

			rs = stmt.executeQuery();

			ArrayList<Ingredient> ingredients = new ArrayList<>();

			while (rs.next())
				ingredients.add(parseOrderItemIngredient());

			return ingredients;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
