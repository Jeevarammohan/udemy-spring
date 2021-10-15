package com.udemyapp.exception;

/**
 * @author JeevaR
 *
 */
public class CredentialNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CredentialNotFoundException() {
		super();
	}

	public CredentialNotFoundException(String message) {
		super(message);
	}

}
