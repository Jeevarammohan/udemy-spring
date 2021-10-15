package com.udemyapp.exception;

public class InstructorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InstructorNotFoundException() {
		super();
	}

	public InstructorNotFoundException(String message) {
		super(message);
	}

}
