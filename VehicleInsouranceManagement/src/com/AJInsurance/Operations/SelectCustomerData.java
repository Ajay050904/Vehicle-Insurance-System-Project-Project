package com.AJInsurance.Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectCustomerData {
	public static String login = null;
	public static Scanner scanner = null;
	static int ID = 0;
	static String number = null;
	static String name = null;
	public static String LOGIN_CUSTOMER_QUERY = null;
	public static PreparedStatement ps = null;
	public static Connection con = null;
	public static ResultSet data = null;

	public static void loginDetails() {
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter Your Vehicle Number: ");
			number = scanner.next();
			number = "'" + number + "'";
			System.out.println("Enter Your [ Vehicle Owner ] Name: ");
			name = scanner.next();
			name = "'" + name + "'";
			System.out.println("Enter Your Insurance-ID: ");
			ID = scanner.nextInt();

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// create the connection object
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();

			}
			// prepare s q l query
			LOGIN_CUSTOMER_QUERY = "select * from InsuranceData where VEHICLENUMBER = " + number + " and OWNERNAME = "
					+ name + "and  INSURANCEID = " + ID;
			// System.out.println(LOGIN_CUSTOMER_QUERY );
			// create the PreparedStatement object
			if (con != null) {
				ps = con.prepareStatement(LOGIN_CUSTOMER_QUERY);
			}
			// Execute The query
			if (ps != null) {
				data = ps.executeQuery();
			}
			if (data.next()) {
				System.out.println("Login Successfully : ");
				System.out.println("*********************\n");
				System.out.println("Vehicle Number = " + data.getString(1) + "\nOwner Name = " + data.getString(2)
						+ "\nVehicle Type = " + data.getString(3) + "\nInsurance ID = " + data.getInt(4)
						+ "\nStarting Date = " + data.getDate(5) + "\nEnd Date = " + data.getDate(6));
			} else {
				System.out.println("Please Enter Correct Details : ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				data.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				scanner.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally close
	} // function close
} // class close
