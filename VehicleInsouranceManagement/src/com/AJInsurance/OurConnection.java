package com.AJInsurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class OurConnection {
	public static Connection con = null;

	public static void getConnection() {
		// load the driver class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// create the connection object
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
	}
}
