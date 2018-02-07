package com.pointwest.java.ui;

import java.util.List;
import java.util.Scanner;

import com.pointwest.java.bean.EmployeeUser;
import com.pointwest.java.manager.ExceptionManager;
import com.pointwest.java.manager.LoginManager;

public class LoginUI {
	public List<EmployeeUser> runProgram() {
		Scanner scanner = new Scanner(System.in);
		List<EmployeeUser> employeeList = null;
		try {
			// Instantiate
			LoginManager loginManager = new LoginManager();

			System.out.println("***********************************************");
			System.out.println("*                     LOG-IN                  *");
			System.out.println("***********************************************");
			System.out.print("Username: ");
			String userName = scanner.next();
			System.out.print("Password: ");
			String userPassword = scanner.next();

			employeeList = loginManager.loginToDB(userName, userPassword);
		} catch (ExceptionManager e) {
			System.out.println(e.getDbMessage());
		}
		return employeeList;
	}

	public void disconnectDB() {
		System.out.println("***********************************************");
		System.out.println("*                   THANK YOU!                *");
		System.out.println("***********************************************");
		System.exit(0);
	}
}