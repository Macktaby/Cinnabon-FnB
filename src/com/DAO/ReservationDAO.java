package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.models.*;

public class ReservationDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ReservationDAO() {
		conn = DBConnection.getActiveConnection();
	}

	private Reservation parseReservation() throws SQLException {

		Reservation res = new Reservation();

		res.setReservationID(rs.getInt("reservation.reservation_id"));
		res.setEaterID(rs.getInt("reservation.eater_id"));
		res.setnPersons(rs.getInt("reservation.nPersons"));
		res.setStartTime(rs.getTimestamp("reservation.start_time"));
		res.setEndTime(rs.getTimestamp("reservation.end_time"));
		res.setBranch(parseBranch());

		return res;
	}

	public Branch parseBranch() throws SQLException {
		Branch branch = new Branch();

		branch.setBranchID(rs.getInt("branch.branch_id"));
		branch.setPhone(rs.getString("branch.phone"));
		branch.setLocation(rs.getString("branch.location"));
		branch.setAddress(rs.getString("branch.address"));
		branch.setLng(rs.getString("branch.lng"));
		branch.setLat(rs.getString("branch.lat"));

		return branch;
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

	public ArrayList<Reservation> getReservations(int eaterID) {
		try {
			String sql = "SELECT * FROM reservation, branch "
					+ "WHERE reservation.eater_id=? AND reservation.branch_id=branch.branch_id";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eaterID);

			rs = stmt.executeQuery();

			ArrayList<Reservation> reservations = new ArrayList<>();

			while (rs.next())
				reservations.add(parseReservation());

			return reservations;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
