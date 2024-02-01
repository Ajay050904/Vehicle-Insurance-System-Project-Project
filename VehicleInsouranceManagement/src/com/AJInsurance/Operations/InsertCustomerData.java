package com.AJInsurance.Operations;

import static com.AJInsurance.Operations.SelectCustomerData.name;
import static com.AJInsurance.Operations.SelectCustomerData.number;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import static com.AJInsurance.OurConnection.con;
import com.AJInsurance.OurConnection;

public class InsertCustomerData {

	public static PreparedStatement ps = null;
	public static String type = null;
	public static String query = null;
	public static int id = 0;
	public static int data = 0;
	public static String startDate = null;
	public static String endDate = null;

	public static void registerDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your vehicle details correctly: \n");
		System.out.println("Enter Your Vehicle Number: ");
		number = sc.next();
		System.out.println("Enter Your [ Vehicle Owner ] Name: ");
		name = sc.next();
		System.out.println("Enter Your Vehicle Type: ");
		type = sc.next();
		System.out.println("Enter Insurance ID: ");
		id = sc.nextInt();
		System.out.println("Enter Start Date: \n [Format - 05-AUG-25 (dd-mm-yy)]");
		startDate = sc.next();
		System.out.println("Enter end Date: ");
		endDate = sc.next();
		sc.close();
		try {
			OurConnection.getConnection();
			query = "insert into INSURANCEDATA values(?,?,?,?,?,?)";
			if (con != null) {
				ps = con.prepareStatement(query);
			}
			if (ps != null) {
				ps.setString(1, number);
				ps.setString(2, name);
				ps.setString(3, type);
				ps.setInt(4, id);
				ps.setString(5, startDate);
				ps.setString(6, endDate);
			}
			// Execute The query
			if (ps != null) {
				data = ps.executeUpdate();
			}
			if (data == 0) {
				System.out.println("Record not Inserted ");
			} else {
				System.out.println("Record  Inserted Successfully ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		// handling unknown exception
		catch (Exception e) {
			e.printStackTrace();
		}
		// close the connection in reverse order
		finally {
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
		} // finally
	} // main
} // class
