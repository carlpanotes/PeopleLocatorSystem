package com.pointwest.java.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.java.bean.EmployeeUser;
import com.pointwest.java.dao.PeopleLocatorDao;

public class LoginManager {
	Logger logger = Logger.getLogger(LoginManager.class);

	public List<EmployeeUser> loginToDB(String userName, String userPassword) throws ExceptionManager {
		logger.info("loginToDB - Start");
		PeopleLocatorDao peopleLocatorDao = new PeopleLocatorDao();

		List<EmployeeUser> employee = peopleLocatorDao.connectToDB(userName, userPassword);
		logger.info("loginToDB - End");
		return employee;
	}
}