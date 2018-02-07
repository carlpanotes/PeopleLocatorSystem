package com.pointwest.java.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.java.bean.EmployeeUser;
import com.pointwest.java.manager.DisplayManager;

public class HomeUI {
	Logger logger = Logger.getLogger(HomeUI.class);

	public int homeMenu(List<EmployeeUser> employeeUserList) {
		DisplayManager displayManager = new DisplayManager();
		String userDisplay = displayManager.displayUser(employeeUserList);
		Scanner scanner = new Scanner(System.in);
		int selectedHomeMenu = 0;
		do {
			try {
				System.out.println("***********************************************");
				System.out.println("*                      HOME                   *");
				System.out.println("***********************************************");

				System.out.println("***********************************************");
				System.out.println("*                    Welcome!                 *");
				System.out.println("***********************************************");
				System.out.println(userDisplay);
				System.out.println("***********************************************");

				System.out.println("*                      MENU:                  *");
				System.out.println("***********************************************");
				System.out.println("[1] Search");
				System.out.println("[2] View Seatplan");
				System.out.println("[3] Logout");
				System.out.print("[Action]: ");
				selectedHomeMenu = scanner.nextInt();

			} catch (RuntimeException e) {
				System.out.println("Invalid input. Pls select only from the options.");
				logger.error("Home Menu - User input mismatched.");
			} finally {

			}
			return selectedHomeMenu;
		} while (true);
	}
}