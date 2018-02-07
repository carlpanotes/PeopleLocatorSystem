package com.pointwest.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.java.bean.Employee;
import com.pointwest.java.bean.EmployeeUser;
import com.pointwest.java.manager.ExceptionManager;

public class PeopleLocatorDao {
	Logger logger = Logger.getLogger(PeopleLocatorDao.class);
	String db = "jdbc:mysql://172.26.83.193:3306/plsdb";
	String user = "newuser";
	String password = "password123";
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public List<EmployeeUser> connectToDB(String userName, String userPassword) throws ExceptionManager {
		logger.info("connectToDB - Start");
		List<EmployeeUser> employees = null;

		try {
			conn = DriverManager.getConnection(db, user, password);
			String query = "SELECT * FROM employee WHERE username = ? AND password = ?";
			ps = conn.prepareStatement(query);

			ps.setString(1, userName);
			ps.setString(2, userPassword);
			rs = ps.executeQuery();

			employees = new ArrayList<EmployeeUser>();
			while (rs.next()) {
				EmployeeUser employee = new EmployeeUser();
				employee.setFirst_name(rs.getString("first_name"));
				employee.setLast_name(rs.getString("last_name"));
				employee.setRole(rs.getString("role"));
				EmployeeUser.setCredentialValid(true);
				employees.add(employee);
			}
		} catch (SQLException e1) {
			System.out.println("Encountered issues from database.");
			throw new ExceptionManager();
		} finally {
			logger.info("connectToDB - End");
		}
		return employees;
	}

	public List<Employee> searchEmployee(String emp, int flg) throws ExceptionManager {
		logger.info("searchEmployee - Start");
		List<Employee> employees = null;

		try {
			conn = DriverManager.getConnection(db, user, password);
			Statement statement = conn.createStatement();
			String empFilter = "%" + emp + "%";
			String query = null;
			switch (flg) {
			case 1:
				query = "SELECT * FROM employee LEFT JOIN employee_seat ON employee.emp_id = employee_seat.emp_id LEFT JOIN seat ON employee_seat.seat_id = seat.seat_id LEFT JOIN employee_project ON employee.emp_id = employee_project.employee_id LEFT JOIN project ON employee_project.proj_alias = project.proj_alias WHERE employee.emp_id like \""
						+ empFilter + "\"";
				break;
			case 2:
				query = "SELECT * FROM employee LEFT JOIN employee_seat ON employee.emp_id = employee_seat.emp_id LEFT JOIN seat ON employee_seat.seat_id = seat.seat_id LEFT JOIN employee_project ON employee.emp_id = employee_project.employee_id LEFT JOIN project ON employee_project.proj_alias = project.proj_alias WHERE employee.first_name like \""
						+ empFilter + "\"";
				break;
			case 3:
				query = "SELECT * FROM employee LEFT JOIN employee_seat ON employee.emp_id = employee_seat.emp_id LEFT JOIN seat ON employee_seat.seat_id = seat.seat_id LEFT JOIN employee_project ON employee.emp_id = employee_project.employee_id LEFT JOIN project ON employee_project.proj_alias = project.proj_alias WHERE employee_project.proj_alias like \""
						+ empFilter + "\"";
				break;
			}

			rs = statement.executeQuery(query);

			employees = new ArrayList<Employee>();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmp_id(rs.getString("emp_id"));
				employee.setFirst_name(rs.getString("first_name"));
				employee.setLast_name(rs.getString("last_name"));
				employee.setRole(rs.getString("role"));
				employee.setShift(rs.getString("shift"));
				employee.setBldg_id(rs.getString("bldg_id"));
				employee.setFloor_number(rs.getString("floor_number"));
				employee.setQuadrant(rs.getString("quadrant"));
				employee.setRow_number(rs.getString("row_number"));
				employee.setColumn_number(rs.getString("column_number"));
				employee.setLocal_number(rs.getString("local_number"));
				employee.setProj_alias(rs.getString("proj_alias"));
				employees.add(employee);
			}
		} catch (SQLException e1) {
			System.out.println("Encountered issues from database.");
			throw new ExceptionManager();
		} finally {
			closeConnection(conn, ps, rs);
			logger.info("searchEmployee - End");
		}
		return employees;

	}

	public List<Employee> viewSeatPlan(String emp, String emp2) throws ExceptionManager {
		logger.info("viewSeatPlan - Start");
		List<Employee> employees = null;

		try {
			conn = DriverManager.getConnection(db, user, password);
			String query = "SELECT * FROM employee LEFT JOIN employee_seat ON employee.emp_id = employee_seat.emp_id LEFT JOIN seat ON employee_seat.seat_id = seat.seat_id LEFT JOIN employee_project ON employee.emp_id = employee_project.employee_id LEFT JOIN project ON employee_project.proj_alias = project.proj_alias WHERE seat.bldg_id = ? AND seat.floor_number = ?";
			ps = conn.prepareStatement(query);

			ps.setString(1, emp);
			ps.setString(2, emp2);
			rs = ps.executeQuery();

			employees = new ArrayList<Employee>();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmp_id(rs.getString("emp_id"));
				employee.setFirst_name(rs.getString("first_name"));
				employee.setLast_name(rs.getString("last_name"));
				employee.setRole(rs.getString("role"));
				employee.setShift(rs.getString("shift"));
				employee.setBldg_id(rs.getString("bldg_id"));
				employee.setFloor_number(rs.getString("floor_number"));
				employee.setQuadrant(rs.getString("quadrant"));
				employee.setRow_number(rs.getString("row_number"));
				employee.setColumn_number(rs.getString("column_number"));
				employee.setLocal_number(rs.getString("local_number"));
				employee.setProj_alias(rs.getString("proj_alias"));
				employees.add(employee);
			}
		} catch (SQLException e1) {
			System.out.println("Encountered issues from database.");
			throw new ExceptionManager();
		} finally {
			closeConnection(conn, ps, rs);
			logger.info("viewSeatPlan - End");
		}
		return employees;

	}

	public List<Employee> viewSeatPlan(String emp, String emp2, String emp3) throws ExceptionManager {
		logger.info("viewSeatPlan - Start");
		List<Employee> employees = null;

		try {
			conn = DriverManager.getConnection(db, user, password);
			String query = "SELECT * FROM employee INNER JOIN employee_seat ON employee.emp_id = employee_seat.emp_id INNER JOIN seat ON employee_seat.seat_id = seat.seat_id INNER JOIN employee_project ON employee.emp_id = employee_project.employee_id INNER JOIN project ON employee_project.proj_alias = project.proj_alias WHERE seat.bldg_id = ? AND seat.floor_number = ? AND seat.quadrant = ?";
			ps = conn.prepareStatement(query);

			ps.setString(1, emp);
			ps.setString(2, emp2);
			ps.setString(3, emp3);
			rs = ps.executeQuery();

			employees = new ArrayList<Employee>();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmp_id(rs.getString("emp_id"));
				employee.setFirst_name(rs.getString("first_name"));
				employee.setLast_name(rs.getString("last_name"));
				employee.setRole(rs.getString("role"));
				employee.setShift(rs.getString("shift"));
				employee.setBldg_id(rs.getString("bldg_id"));
				employee.setFloor_number(rs.getString("floor_number"));
				employee.setQuadrant(rs.getString("quadrant"));
				employee.setRow_number(rs.getString("row_number"));
				employee.setColumn_number(rs.getString("column_number"));
				employee.setLocal_number(rs.getString("local_number"));
				employee.setProj_alias(rs.getString("proj_alias"));
				employees.add(employee);
			}
		} catch (SQLException e1) {
			logger.error("Encountered issues from database.");
			throw new ExceptionManager();
		} finally {
			closeConnection(conn, ps, rs);
			logger.info("viewSeatPlan - End");
		}
		return employees;

	}

	public void closeConnection(Connection conn, Statement statement, ResultSet rs) throws ExceptionManager {
		logger.info("closeConnection - Start");
		try {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			throw new ExceptionManager();
		}
		logger.info("closeConnection - End");
	}
}