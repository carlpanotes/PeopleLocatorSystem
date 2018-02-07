package com.pointwest.java.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class ViewSeatPlanUI {
	Logger logger = Logger.getLogger(ViewSeatPlanUI.class);

	public int viewSeatPlanMenu() {
		int selectedViewBy = 0;

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("***********************************************");
			System.out.println("*                 VIEW SEATPLAN               *");
			System.out.println("***********************************************");
			System.out.println("*                     MENU:                   *");
			System.out.println("***********************************************");
			System.out.println("[1] By Location - Floor Level");
			System.out.println("[2] By Quadrant");
			System.out.print("[Action]: ");
			selectedViewBy = scanner.nextInt();
		} catch (RuntimeException e) {
			System.out.println("Invalid input. Pls select only from the options.");
			logger.error("Main Menu - User input mismatched.");
		}

		return selectedViewBy;
	}
}