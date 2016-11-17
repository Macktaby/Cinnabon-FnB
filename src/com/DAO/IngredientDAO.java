package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.models.*;

public class IngredientDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public IngredientDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public Ingredient parseIngredient() throws SQLException {
		Ingredient ingredient = new Ingredient();

		ingredient.setIngredientID(rs.getInt("ingredient_id"));
		ingredient.setIngredientName(rs.getString("ingredient_name"));

		return ingredient;
	}

	public int addItemIngredient(Ingredient ingredient, int itemID) {
		try {
			String sql = "INSERT INTO `ingredients` (`ingredient_name`,`item_id`) VALUES (?,?);";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, ingredient.getIngredientName());
			stmt.setInt(2, itemID);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public String updateItemIngredient(Ingredient ingredient, int itemID) {
		try {
			String sql = "UPDATE `ingredients` SET `ingredient_name`=?, `item_id`=? WHERE `ingredient_id`=?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ingredient.getIngredientName());
			stmt.setInt(2, itemID);
			stmt.setInt(3, ingredient.getIngredientID());

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";

		} catch (SQLException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}

		return "false";
	}

	public String deleteItemIngredient(int id) {
		try {
			String sql = "DELETE FROM `ingredients` WHERE `ingredient_id` = ?;";

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

	public List<Ingredient> getItemIngredients(int itemID) {
		try {
			String sql = "SELECT * FROM ingredients WHERE item_id = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, itemID);

			rs = stmt.executeQuery();

			ArrayList<Ingredient> ingredients = new ArrayList<>();

			while (rs.next())
				ingredients.add(parseIngredient());

			return ingredients;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
