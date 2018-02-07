package com.pointwest.java.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.java.bean.Employee;
import com.pointwest.java.manager.DisplayManager;
import com.pointwest.java.manager.ExceptionManager;

public class SearchBySpecificFilterUI {
	Logger logger = Logger.getLogger(SearchBySpecificFilterUI.class);

	public void searchByFilter(int selectedSearch) {
		Scanner scanner = new Scanner(System.in);
		Employee.setHome_flg(true);
		do {
			try {
				// Instantiate
				DisplayManager displayManager = new DisplayManager();
				switch (selectedSearch) {
				case 1:
					System.out.println("***********************************************");
					System.out.println("*            SEARCH - By Employee ID          *");
					System.out.println("***********************************************");
					System.out.print("Enter Employee ID: ");
					String employeeID = scanner.next();
					displayManager.displaySearchResult(employeeID, 1);
					break;
				case 2:
					System.out.println("***********************************************");
					System.out.println("*               SEARCH - By Name              *");
					System.out.println("***********************************************");
					System.out.print("Enter Name: ");
					String employeeName = scanner.next();
					displayManager.displaySearchResult(employeeName, 2);
					break;
				case 3:
					System.out.println("***********************************************");
					System.out.println("*               SEARCH - By Project           *");
					System.out.println("***********************************************");
					System.out.print("Enter Project: ");
					String employeeProject = scanner.next();
					displayManager.displaySearchResult(employeeProject, 3);
					break;
				}

				System.out.println("***********************************************");
				System.out.println("*                END OF RESULT                *");
				System.out.println("***********************************************");
				System.out.println("*      ACTIONS: [1] Search Again [2] Home     *");
				System.out.println("***********************************************");
				System.out.print("[Action]: ");
				int selectedAction = scanner.nextInt();
				if (selectedAction == 1) {
					continue;
				} else {
					Employee.setHome_flg(false);
				}
			} catch (ExceptionManager e) {
				logger.error("Search Menu - User input mismatched.");
				System.out.println(e.getMessage());

			} catch (RuntimeException e) {
				logger.error("Search Menu - User input mismatched.");
				System.out.println("Invalid input. Pls select only from the options.");
			}

		} while (Employee.home_flg);
	}
}
