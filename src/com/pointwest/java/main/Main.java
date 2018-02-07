package com.pointwest.java.main;

import java.util.List;

import com.pointwest.java.bean.EmployeeUser;
import com.pointwest.java.ui.HomeUI;
import com.pointwest.java.ui.LoginUI;
import com.pointwest.java.ui.SearchBySpecificFilterUI;
import com.pointwest.java.ui.SearchUI;
import com.pointwest.java.ui.ViewBySpecificFilterUI;
import com.pointwest.java.ui.ViewSeatPlanUI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginUI loginUI = new LoginUI();
		List<EmployeeUser> employeeUserList = null;
		do {
			employeeUserList = loginUI.runProgram();

		} while (!(EmployeeUser.credentialValid));

		HomeUI homeUI = new HomeUI();
		do {
			int homeRetValue = homeUI.homeMenu(employeeUserList);
			switch (homeRetValue) {
			case 1:// Search
				SearchUI searchUI = new SearchUI();
				int searchRetValue = searchUI.searchMenu();
				SearchBySpecificFilterUI SearchBySpecificFilter = new SearchBySpecificFilterUI();
				SearchBySpecificFilter.searchByFilter(searchRetValue);
				break;
			case 2:// View Seat Plan
				ViewSeatPlanUI viewSeatPlanUI = new ViewSeatPlanUI();
				int viewSeatPlanRetValue = viewSeatPlanUI.viewSeatPlanMenu();

				ViewBySpecificFilterUI ViewBySpecificFilterUI = new ViewBySpecificFilterUI();
				ViewBySpecificFilterUI.viewByFilter(viewSeatPlanRetValue);
				break;
			case 3:// Logout
				loginUI.disconnectDB();
				break;
			}
		} while (true);
	}

}