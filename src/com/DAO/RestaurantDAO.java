package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.models.*;

public class RestaurantDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public RestaurantDAO() {
		conn = DBConnection.getActiveConnection();
	}

	private Restaurant parseRestaurant() throws SQLException {
		Restaurant rest = new Restaurant();

		rest.setRestaurantID(rs.getInt("restaurant_id"));
		rest.setRestaurantName(rs.getString("restaurant_name"));
		rest.setDescription(rs.getString("description"));
		rest.setType(rs.getString("type"));
		rest.setLogo(rs.getString("logo"));
		rest.setHotline(rs.getString("hotline"));
		rest.setRating(rs.getDouble("rating"));

		return rest;
	}

	public Restaurant getRestaurantInfo() {
		try {
			String sql = "SELECT * FROM restaurant";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.next())
				return parseRestaurant();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String updateRestaurantInfo(Restaurant rest) {
		try {
			String sql = "UPDATE `restaurant` "
					+ "SET `restaurant_name` = ?, `description` = ?, `type` = ?, `logo` = ?, "
					+ "`hotline` = ? WHERE `restaurant_id` = 1;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, rest.getRestaurantName());
			stmt.setString(2, rest.getDescription());
			stmt.setString(3, rest.getType());
			stmt.setString(4, rest.getLogo());
			stmt.setString(5, rest.getHotline());

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}

		return "false";
	}
}
