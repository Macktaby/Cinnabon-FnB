package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.models.*;

public class AdminDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public AdminDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public int addAdmin(Admin admin) {
		try {
			String sql = "INSERT INTO `admin` (`admin_name`, `email`, `password`, `branch_id`) "
					+ "VALUES (?, ?, ?, ?);";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, admin.getAdminName());
			stmt.setString(2, admin.getEmail());
			stmt.setString(3, admin.getPassword());
			stmt.setInt(4, admin.getBranchID());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public String updateAdmin(Admin admin) {
		try {
			String sql = "UPDATE `admin` SET `admin_name` = ?, `email` = ?, `password` = ?, "
					+ "`branch_id` = ? WHERE `admin_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, admin.getAdminName());
			stmt.setString(2, admin.getEmail());
			stmt.setString(3, admin.getPassword());
			stmt.setInt(4, admin.getBranchID());
			stmt.setInt(5, admin.getAdminID());

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";

		} catch (SQLException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}

		return "false";
	}

	public String deleteAdmin(int id) {
		try {
			String sql = "DELETE FROM `admin` WHERE `admin_id` = ?;";

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
