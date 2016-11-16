package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.models.*;

public class BranchDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public BranchDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public int addBranch(Branch branch) {
		try {
			String sql = "INSERT INTO `branch` (`phone`, `location`, `address`, `lng`, `lat`) "
					+ "VALUES ( ? , ? , ? , ?, ? );";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, branch.getPhone());
			stmt.setString(2, branch.getLocation());
			stmt.setString(3, branch.getAddress());
			stmt.setString(4, branch.getLng());
			stmt.setString(5, branch.getLat());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public String updateBranch(Branch branch) {
		try {
			String sql = "UPDATE `branch` SET `phone` = ?, `location` = ?, `address` = ?, "
					+ "`lng` = ?, `lat` = ? WHERE `branch_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, branch.getPhone());
			stmt.setString(2, branch.getLocation());
			stmt.setString(3, branch.getAddress());
			stmt.setString(4, branch.getLng());
			stmt.setString(5, branch.getLat());
			stmt.setInt(6, branch.getBranchID());

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";

		} catch (SQLException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}

		return "false";
	}

	public String deleteBranch(int id) {
		try {
			String sql = "DELETE FROM `branch` WHERE `branch_id` = ?";

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
