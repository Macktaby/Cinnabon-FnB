package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.models.*;

public class ReservationDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ReservationDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public int addReservation(Reservation res, int branchID) {
		try {
			String sql = "INSERT INTO `reservation` "
					+ "( `nPersons`, `start_time`, `end_time`, `eater_id`, `branch_id`) "
					+ "VALUES ( ? , ? , ? , ? , ? );";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, res.getnPersons());
			stmt.setTimestamp(2, res.getStartTime());
			stmt.setTimestamp(3, res.getEndTime());
			stmt.setInt(4, res.getEaterID());
			stmt.setInt(5, branchID);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public String updateReservation(Reservation res, int branchID) {
		try {
			String sql = "UPDATE `reservation` "
					+ "SET `nPersons` = ?, `start_time` = ?, `end_time` = ?, `eater_id` = ?, `branch_id` = ? "
					+ "WHERE `reservation_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, res.getnPersons());
			stmt.setTimestamp(2, res.getStartTime());
			stmt.setTimestamp(3, res.getEndTime());
			stmt.setInt(4, res.getEaterID());
			stmt.setInt(5, branchID);
			stmt.setInt(6, res.getReservationID());

			int rows = stmt.executeUpdate();

			if (rows == 1)
				return "true";

		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}

		return "false";
	}

	public String deleteReservation(int reservationID) {
		try {
			String sql = "DELETE FROM `reservation` WHERE `reservation_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reservationID);

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
