package com.pointwest.java.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class SearchUI {
	Logger logger = Logger.getLogger(SearchUI.class);

	public int searchMenu() {
		int selectedSearchBy = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				System.out.println("***********************************************");
				System.out.println("*                     SEARCH                  *");
				System.out.println("***********************************************");
				System.out.println("*                      MENU:                  *");
				System.out.println("***********************************************");
				System.out.println("[1] By Employee ID");
				System.out.println("[2] By Name");
				System.out.println("[3] By Project");
				System.out.print("[Action]: ");
				selectedSearchBy = scanner.nextInt();
			} catch (RuntimeException e) {
				System.out.println("Invalid input. Pls select only from the options.");
				logger.error("Main Menu - User input mismatched.");
			}
			return selectedSearchBy;
		} while (true);

	}
}