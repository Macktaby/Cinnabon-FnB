package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.models.*;

public class BranchImageDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public BranchImageDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public int addImage(int id, String url) {
		try {
			String sql = "INSERT INTO `branch_images` (`url`, `branch_id`) VALUES (? , ?);";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, url);
			stmt.setInt(2, id);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public String updateImage(int id, String url, int branchID) {
		try {
			String sql = "UPDATE `branch_images` SET `url` = ?, `branch_id` = ? WHERE `image_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, url);
			stmt.setInt(2, branchID);
			stmt.setInt(3, id);

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";

		} catch (SQLException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}

		return "false";
	}

	public String deleteImage(int id) {
		try {
			String sql = "DELETE FROM `branch_images` WHERE `image_id` = ?";

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
