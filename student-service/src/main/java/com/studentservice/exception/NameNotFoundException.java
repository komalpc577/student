package com.studentservice.exception;

public class NameNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public NameNotFoundException(String message) {
		System.out.println("record not found with this Name");
	}
	

}
