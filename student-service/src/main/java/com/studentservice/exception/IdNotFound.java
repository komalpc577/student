package com.studentservice.exception;

public class IdNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public IdNotFound(String message) {
		System.out.println("Id not found please enter valid Id");
	}
	
}
