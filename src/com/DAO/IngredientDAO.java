package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.models.*;

public class IngredientDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public IngredientDAO() {
		conn = DBConnection.getActiveConnection();
	}


}
