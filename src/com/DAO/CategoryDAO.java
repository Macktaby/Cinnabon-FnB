package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.models.*;

public class CategoryDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public CategoryDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public Category parseCategory() throws SQLException {
		Category cat = new Category();

		cat.setCategoryID(rs.getInt("category_id"));
		cat.setCategoryName(rs.getString("category_name"));
		cat.setItems(new ItemDAO().getItems(cat.getCategoryID()));

		return cat;
	}

	public int addCategory(Category cat) {
		try {
			String sql = "INSERT INTO `category` (`category_name`, `branch_id`) VALUES (? , ?);";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cat.getCategoryName());
			stmt.setInt(2, cat.getBranchID());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public String updateCategory(Category cat) {
		try {
			String sql = "UPDATE `category` SET `category_name` = ?, `branch_id` = ? WHERE `category_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cat.getCategoryName());
			stmt.setInt(2, cat.getBranchID());
			stmt.setInt(3, cat.getCategoryID());

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";

		} catch (SQLException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}

		return "false";
	}

	public String deleteCategory(int id) {
		try {
			String sql = "DELETE FROM `category` WHERE `category_id` = ?;";

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

	public ArrayList<Category> getMenu() {
		try {
			String sql = "SELECT * FROM category";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			ArrayList<Category> categories = new ArrayList<>();

			while (rs.next())
				categories.add(parseCategory());

			return categories;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
