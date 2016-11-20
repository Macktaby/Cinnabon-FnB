package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.models.*;

public class ReviewDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ReviewDAO() {
		conn = DBConnection.getActiveConnection();
	}

	public int addReview(Review review) {
		try {
			String sql = "INSERT INTO `review` (`body`, `rating`, `review_date`, `eater_id`) "
					+ "VALUES ( ? , ? , ? , ? );";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, review.getReviewBody());
			stmt.setInt(2, review.getRating());
			stmt.setTimestamp(3, review.getReviewDate());
			stmt.setInt(4, review.getEaterID());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	public String updateReview(Review review) {
		try {
			String sql = "UPDATE `review` SET `body` = ?, `rating` = ?, `review_date` = ?, "
					+ "`eater_id` = ? WHERE `review_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, review.getReviewBody());
			stmt.setInt(2, review.getRating());
			stmt.setTimestamp(3, review.getReviewDate());
			stmt.setInt(4, review.getEaterID());
			stmt.setInt(5, review.getReviewID());

			int rows = stmt.executeUpdate();

			if (rows == 1)
				return "true";

		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}

		return "false";
	}

	public String deleteReview(int id) {
		try {
			String sql = "DELETE FROM `review` WHERE `review_id` = ?;";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

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
