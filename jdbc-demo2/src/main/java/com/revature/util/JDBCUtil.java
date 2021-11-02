package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class JDBCUtil {
	// Recap: delcaring an exception is when you use throws <exception name> in the
	// method signature
	// It allows you to pass the responsibilty of handling the checked exception to
	// a method
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres"; // This is where you provide the "Connection String",
		// which is the location of your database server and the database name
		String username = "postgres";
		String password = "password";

		// 1. Register the driver
		Driver postgresDriver = new Driver();

		DriverManager.registerDriver(postgresDriver);

		Connection con = DriverManager.getConnection(url, username, password);

		return con;

	}
}
