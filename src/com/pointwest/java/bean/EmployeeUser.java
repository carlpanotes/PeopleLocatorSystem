package com.pointwest.java.bean;

public class EmployeeUser extends Employee {
	public static boolean credentialValid = false;

	public static boolean isCredentialValid() {
		return credentialValid;
	}

	public static void setCredentialValid(boolean credentialValid) {
		EmployeeUser.credentialValid = credentialValid;
	}
}