package com.AJInsurance.Operations;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.AJInsurance.OurConnection;
import static com.AJInsurance.OurConnection.con;

public class DeleteCustomerData {
	public static PreparedStatement psd = null;
	public static Scanner scanner = null;
	public static int result = 0;
	public static String vno  = null;
	public static void deleteData() {
		try {
			// getting input values from user
			scanner = new Scanner(System.in);

			System.out.println("Enter Your vehicle Number : ");
			vno = scanner.next();
			// load the driver and create the connection
			OurConnection.getConnection();
			// prepare query
			String DELETE_CUSTOMER_DATA = "delete from INSURANCEDATA where VEHICLENUMBER = ?"; // + vno;
			// create the PreparedStatement object
			if (con != null) {
				psd = con.prepareStatement(DELETE_CUSTOMER_DATA);
			}
			// set values to the pre compiled sql query (ps object)
			if (psd != null) {
				psd.setString(1, vno);
			}
			// Execute sql query
			if (psd != null) {
				result = psd.executeUpdate();
			}
			if(result == 0) {
				System.out.println("Record not deleted.");
			}
			else {
				System.out.println("Record deleted successfully.");
			}
		}
		// handling known exceptions
		catch (SQLException e) {
			e.printStackTrace();
		}
		// handling unknown exception
		catch (Exception e) {
			e.printStackTrace();
		}
		// close the connection in reverse order
		finally {
			try {
				psd.close();
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
		}
	}
}
