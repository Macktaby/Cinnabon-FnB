package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.models.*;

public class OrderDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public OrderDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public int addOrder(Order order, int branchID) {
		try {
			String sql = "INSERT INTO `order` "
					+ "(`time_created`, `order_time`, `eater_id`, `branch_id`) VALUES (?,?,?,?);";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setTimestamp(1, order.getTimeCreated());
			stmt.setTimestamp(2, order.getOrderTime());
			stmt.setInt(3, order.getEaterID());
			stmt.setInt(4, branchID);

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

}
