package com.revature.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.Driver;

public class Application {

	public static void main(String[] args) {

		// JDBC
		// Stands for Java Database Connectivity
		// It is a part of the standard Java runtime library that is included with the
		// JRE
		// It is an API that allows for you to write code that interacts with a SQL
		// database

		// How do we actually connect to the database from our java application
		// We need to obtain what is known as a Connection object

		// There is a JDBC class called DriverManager that we can use to register our
		// Postgres driver that we obtained from mvnrepository
		// And then provide the credentials to the Postgres database

		String url = "jdbc:postgresql://localhost:5432/postgres"; // This is where you provide the "Connection String",
		// which is the location of your database server and the database name
		String username = "postgres";
		String password = "password";

		// 1. Register the driver
		Driver postgresDriver = new Driver();
		try {
			DriverManager.registerDriver(postgresDriver);

			Connection con = DriverManager.getConnection(url, username, password);

			System.out.println(con);

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM students");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int studentId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String classification = rs.getString(4);
				int age = rs.getInt(5);

				System.out.println("id = " + studentId + ", firstName = " + firstName + " , " + "lastName= " + lastName
						+ " classfication = " + classification + ", age " + age);

			}
		} catch (SQLException e) {
			e.printStackTrace(); // SQLException is a checked exception that is part of JDBC. Because it is
									// checked, are required
			// to handle or declare this exception.
		}

	}

}