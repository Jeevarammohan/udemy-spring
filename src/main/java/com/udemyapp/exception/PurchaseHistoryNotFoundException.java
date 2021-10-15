package com.udemyapp.exception;

/**
 * @author JeevaR
 *
 */
public class PurchaseHistoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PurchaseHistoryNotFoundException() {
		super();
	}

	public PurchaseHistoryNotFoundException(String message) {
		super(message);
	}
	
	

}
