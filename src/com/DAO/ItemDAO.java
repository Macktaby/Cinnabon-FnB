package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.models.*;

public class ItemDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ItemDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public Item parseItem() throws SQLException {
		Item item = new Item();

		item.setItemID(rs.getInt("item_id"));
		item.setItemName(rs.getString("item_name"));
		item.setDescription(rs.getString("item_desc"));
		item.setLikes(rs.getInt("likes"));
		item.setDislikes(rs.getInt("dislikes"));
		item.setCalories(rs.getInt("calories"));
		item.setnPersons(rs.getInt("nPersons"));
		item.setIngredients(new IngredientDAO().getItemIngredients(item.getItemID()));
		item.setSizes(new SizeDAO().getItemSizes(item.getItemID()));

		return item;
	}

	public int addItem(Item item, int categoryID) {
		try {
			String sql = "INSERT INTO `item` "
					+ "(`item_name`, `item_desc`, `likes`, `dislikes`, `calories`, `nPersons`, `category_id`) "
					+ "VALUES (?,?,?,?,?,?,?)";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, item.getItemName());
			stmt.setString(2, item.getDescription());
			stmt.setInt(3, 0);
			stmt.setInt(4, 0);
			stmt.setInt(5, item.getCalories());
			stmt.setInt(6, item.getnPersons());
			stmt.setInt(7, categoryID);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public String updateItem(Item item, int categoryID) {
		try {
			String sql = "UPDATE `item` SET `item_name` = ?, `item_desc` = ?, `calories` = ?, "
					+ "`nPersons` = ?, `category_id` = ? WHERE `item_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, item.getItemName());
			stmt.setString(2, item.getDescription());
			stmt.setInt(3, item.getCalories());
			stmt.setInt(4, item.getnPersons());
			stmt.setInt(5, categoryID);
			stmt.setInt(6, item.getItemID());

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";

		} catch (SQLException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}

		return "false";
	}

	public String deleteItem(int id) {
		try {
			String sql = "DELETE FROM `item` WHERE `item_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";

		} catch (SQLException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}

		return "false";
	}

	public List<Item> getItems(int categoryID) {
		try {
			String sql = "SELECT * FROM item WHERE category_id = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, categoryID);

			rs = stmt.executeQuery();

			ArrayList<Item> items = new ArrayList<>();

			while (rs.next())
				items.add(parseItem());

			return items;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
