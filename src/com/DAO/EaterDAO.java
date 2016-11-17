package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.models.*;

public class EaterDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public EaterDAO() {
		conn = DBConnection.getActiveConnection();
	}

	private Eater parseEater() throws SQLException {
		Eater eater = new Eater();

		eater.setEaterID(rs.getInt("eater_id"));
		eater.setEmail(rs.getString("email"));
		eater.setUserName(rs.getString("user_name"));
		eater.setPassword(rs.getString("password"));
		eater.setPhone(rs.getString("phone"));
		eater.setDateRegistered(rs.getTimestamp("date_registered"));

		return eater;
	}

	public int addEater(Eater eater) {

		try {
			String sql = "INSERT INTO `cinnabon_fnb`.`eater` "
					+ "(`user_name`, `email`, `password`, `phone`, `date_registered`) "
					+ "VALUES ( ? , ? , ? ,? , ? );";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, eater.getUserName());
			stmt.setString(2, eater.getEmail());
			stmt.setString(3, eater.getPassword());
			stmt.setString(4, eater.getPhone());
			stmt.setTimestamp(5, eater.getDateRegistered());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public Eater getEater(String email, String password) {

		try {
			String sql = "SELECT * FROM `eater` WHERE `email` = ? AND `password` = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);

			rs = stmt.executeQuery();

			if (rs.next())
				return parseEater();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public String updateEater(Eater eater) {
		try {
			String sql = "UPDATE `eater` SET `user_name` = ?, `password` = ?, `phone` = ? WHERE `eater_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, eater.getUserName());
			stmt.setString(2, eater.getPassword());
			stmt.setString(3, eater.getPhone());
			stmt.setInt(4, eater.getEaterID());

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "false";
	}

	public String updatePassword(String password, int id) {
		try {
			String sql = "UPDATE `eater` SET `password` = ? WHERE `eater_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setInt(2, id);

			int rows = stmt.executeUpdate();
			if (rows == 1)
				return "true";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "false";
	}

	public Eater getEaterByID(int id) {
		try {
			String sql = "SELECT * FROM eater WHERE eater_id = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next())
				return parseEater();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
