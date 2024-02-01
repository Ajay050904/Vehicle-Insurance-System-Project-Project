package com.AJIsurance.utility;

import static com.AJInsurance.Operations.InsertCustomerData.registerDetails;
import static com.AJInsurance.Operations.SelectCustomerData.loginDetails;
import java.util.Scanner;

import com.AJInsurance.exception.InvalidOptionException;
// import static com.AJInsurance.Operations.DeleteCustomerData.deleteData;
public class MainPageMethods {
	static int a;

	@SuppressWarnings("resource")
	public static void choice() {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		if (a == 1) {
			loginDetails();
			// deleteData();
		} else if (a == 2) {
			registerDetails();
		} else {
			a = 0;
			if (a == 0) {
				throw new InvalidOptionException("please enter valid option");
			}
		}
		sc.close();
	}
}
