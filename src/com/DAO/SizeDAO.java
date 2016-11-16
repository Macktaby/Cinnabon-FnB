package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.models.*;

public class SizeDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public SizeDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public int addItemSize(Size size, int itemID) {
		try {
			String sql = "INSERT INTO `size` (`size_name`, `price`, `item_id`) VALUES (?,?,?);";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, size.getSizeName());
			stmt.setDouble(2, size.getSizePrice());
			stmt.setInt(3, itemID);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public String updateItemSize(Size size, int itemID) {
		try {
			String sql = "UPDATE `size` SET `size_name`=?, `price`=?, `item_id`=? WHERE `size_id`=?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, size.getSizeName());
			stmt.setDouble(2, size.getSizePrice());
			stmt.setInt(3, itemID);
			stmt.setInt(4, size.getSizeID());

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";

		} catch (SQLException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}

		return "false";
	}

	public String deleteItemSize(int id) {
		try {
			String sql = "DELETE FROM `size` WHERE `size_id` = ?;";

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

}
