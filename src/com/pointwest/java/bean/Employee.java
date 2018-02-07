package com.pointwest.java.bean;

public class Employee {
	private String emp_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String role;
	private String shift;
	private String seat;
	private String local_number;
	private String project;
	private String bldg_id;
	private String floor_number;
	private String quadrant;
	private String row_number;
	private String column_number;
	private String proj_alias;

	public static int counter = 0;
	public static boolean home_flg = true;

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Employee.counter = counter;
	}

	public static boolean isHome_flg() {
		return home_flg;
	}

	public static void setHome_flg(boolean home_flg) {
		Employee.home_flg = home_flg;
	}

	public String getProj_alias() {
		return proj_alias;
	}

	public void setProj_alias(String proj_alias) {
		this.proj_alias = proj_alias;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public String getBldg_id() {
		return bldg_id;
	}

	public void setBldg_id(String bldg_id) {
		this.bldg_id = bldg_id;
	}

	public String getFloor_number() {
		return floor_number;
	}

	public void setFloor_number(String floor_number) {
		this.floor_number = floor_number;
	}

	public String getQuadrant() {
		return quadrant;
	}

	public void setQuadrant(String quadrant) {
		this.quadrant = quadrant;
	}

	public String getRow_number() {
		return row_number;
	}

	public void setRow_number(String row_number) {
		this.row_number = row_number;
	}

	public String getColumn_number() {
		return column_number;
	}

	public void setColumn_number(String column_number) {
		this.column_number = column_number;
	}

	public String getSeat() {
		return seat = bldg_id + floor_number + "F" + quadrant + row_number + "-" + column_number;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getLocal_number() {
		return local_number;
	}

	public void setLocal_number(String local_number) {
		this.local_number = local_number;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}
}