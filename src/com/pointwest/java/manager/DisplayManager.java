package com.pointwest.java.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.java.bean.Employee;
import com.pointwest.java.bean.EmployeeUser;
import com.pointwest.java.dao.PeopleLocatorDao;

public class DisplayManager {
	Logger logger = Logger.getLogger(DisplayManager.class);

	public String displayUser(List<EmployeeUser> employeeUserList) {
		logger.info("displayUser - Start");
		String userDisplay = null;
		for (Employee employeeNameList : employeeUserList) {
			userDisplay = employeeNameList.getFirst_name() + " " + employeeNameList.getLast_name() + " ["
					+ employeeNameList.getRole() + "]";
		}
		logger.info("displayUser - End");
		return userDisplay;
	}

	public void displaySearchResult(String emp, int flg) throws ExceptionManager {
		logger.info("displaySearchResult - Start");
		int counter = 1;

		PeopleLocatorDao peopleLocatorDao = new PeopleLocatorDao();
		List<Employee> empIDRetVal = peopleLocatorDao.searchEmployee(emp, flg);
		System.out.println("***********************************************");
		System.out.println("*             SEARCH RESULT - (" + empIDRetVal.size() + ")             *");
		System.out.println("***********************************************");
		System.out.println("[NO] | FIRST NAME | LAST NAME | SEAT | LOCAL | SHIFT | PROJECT(S)");
		System.out.println("***********************************************");
		for (Employee employeeNameList : empIDRetVal) {
			System.out.println("[" + counter + "] | " + employeeNameList.getEmp_id() + " | "
					+ employeeNameList.getFirst_name() + " | " + employeeNameList.getLast_name() + " | "
					+ employeeNameList.getSeat() + " | " + employeeNameList.getLocal_number() + " | "
					+ employeeNameList.getShift() + " | " + employeeNameList.getProj_alias());
			++counter;
		}
		logger.info("displaySearchResult - End");
	}

	public void viewEmpSeatPlan(String location, String floor, String quadrant) throws ExceptionManager {
		logger.info("viewEmpSeatPlan - Start");
		PeopleLocatorDao peopleLocatorDao = new PeopleLocatorDao();
		List<Employee> empIDRetVal = peopleLocatorDao.viewSeatPlan(location, floor, quadrant);

		for (int x = 1; x <= 3; x++) {
			for (Employee employeeNameList : empIDRetVal) {
				if (employeeNameList.getRow_number().equals(Integer.toString(x))) {
					System.out.print("[" + employeeNameList.getSeat() + " - " + employeeNameList.getFirst_name() + " "
							+ employeeNameList.getLast_name() + "] | ");
				}
			}
			System.out.print("\n");
		}
		logger.info("viewEmpSeatPlan - End");
	}
}