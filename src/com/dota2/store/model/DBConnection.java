package com.dota2.store.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection	connection;


	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dotastore", "root", "mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DBConnection Method to connect to  Database
	public static Connection connect() throws SQLException {
		if (connection != null) {
			return connection;
		} else {

			DBConnection db = new DBConnection();
			return db.connection;
		}

	}

}
