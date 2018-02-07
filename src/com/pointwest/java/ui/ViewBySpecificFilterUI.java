package com.pointwest.java.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.java.bean.Employee;
import com.pointwest.java.manager.DisplayManager;
import com.pointwest.java.manager.ExceptionManager;

public class ViewBySpecificFilterUI {
	Logger logger = Logger.getLogger(ViewBySpecificFilterUI.class);

	public void viewByFilter(int selectedView) {
		Scanner scanner = new Scanner(System.in);
		// Instantiate
		DisplayManager displayManager = new DisplayManager();

		String location = null;
		String floorLevel = null;
		String quadrant = null;
		try {
			Employee.setHome_flg(true);
			do {
				Employee employee = new Employee();

				switch (selectedView) {
				case 1:
					System.out.println("***********************************************");
					System.out.println("*  VIEW SEATPLAN - By Location - Floor Level  *");
					System.out.println("***********************************************");
					System.out.print("Enter Location: ");
					location = scanner.next();
					System.out.print("Enter Floor Level: ");
					floorLevel = scanner.next();
					System.out.println("***********************************************");
					System.out.println("                 VIEW SEATPLAN                *");
					System.out.println("***********************************************");
					System.out.println("*                 QUADRANT A:                 *");
					System.out.println("***********************************************");
					displayManager.viewEmpSeatPlan(location, floorLevel, "a");
					System.out.println("***********************************************");
					System.out.println("*                 QUADRANT B:                 *");
					System.out.println("***********************************************");
					displayManager.viewEmpSeatPlan(location, floorLevel, "b");
					System.out.println("***********************************************");
					System.out.println("*                 QUADRANT C:                 *");
					System.out.println("***********************************************");
					displayManager.viewEmpSeatPlan(location, floorLevel, "c");
					System.out.println("***********************************************");
					System.out.println("*                 QUADRANT D:                 *");
					System.out.println("***********************************************");
					displayManager.viewEmpSeatPlan(location, floorLevel, "d");
					break;
				case 2:
					System.out.println("***********************************************");
					System.out.println("*         VIEW SEATPLAN - By Quadrant         *");
					System.out.println("***********************************************");
					System.out.print("Enter Location: ");
					location = scanner.next();
					System.out.print("Enter Floor Level: ");
					floorLevel = scanner.next();
					System.out.print("Enter Quadrant: ");
					quadrant = scanner.next();
					System.out.println("***********************************************");
					System.out.println("                 VIEW SEATPLAN                *");
					System.out.println("***********************************************");
					displayManager.viewEmpSeatPlan(location, floorLevel, quadrant);
					break;
				}

				System.out.println("***********************************************");
				System.out.println("*               END OF SEATPLAN               *");
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
			} while (Employee.home_flg);
		} catch (ExceptionManager e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			logger.error("View Menu - User input mismatched.");
			System.out.println("Invalid input. Pls select only from the options.");
		}

	}
}