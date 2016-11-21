package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.models.*;

public class OrderDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public OrderDAO() {
		conn = DBConnection.getActiveConnection();
	}

	private Order parseOrder() throws SQLException {
		Order order = new Order();

		order.setOrderID(rs.getInt("orders.order_id"));
		order.setEaterID(rs.getInt("orders.eater_id"));
		order.setTimeCreated(rs.getTimestamp("orders.time_created"));
		order.setOrderTime(rs.getTimestamp("orders.order_time"));
		order.setBranch(parseBranch());
		order.setItems(new OrderItemDAO().getOrderItems(order.getOrderID()));

		return order;
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

	public int addOrder(Order order, int branchID) {
		try {
			String sql = "INSERT INTO `orders` "
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

	public ArrayList<Order> getUserOrders(int eaterID) {
		try {
			String sql = "SELECT * FROM orders, branch "
					+ "WHERE orders.eater_id = ? AND orders.branch_id = branch.branch_id";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, eaterID);

			rs = stmt.executeQuery();

			ArrayList<Order> orders = new ArrayList<>();

			while (rs.next())
				orders.add(parseOrder());

			return orders;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
