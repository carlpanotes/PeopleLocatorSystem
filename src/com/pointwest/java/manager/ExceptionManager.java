package com.pointwest.java.manager;

public class ExceptionManager extends Exception {
	public static final String MESSAGE = "Invalid input. Pls select only from the options.";
	public static final String DB_MESSAGE = "Encountered issues from database.";
	public String displayMessage;

	public String getDisplayMessage() {
		return displayMessage;
	}

	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}

	public String getMessage() {
		return MESSAGE;
	}

	public static String getDbMessage() {
		return DB_MESSAGE;
	}
}