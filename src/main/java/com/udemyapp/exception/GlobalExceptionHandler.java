package com.udemyapp.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author JeevaR
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Method not allowed";
		APIErrors errors = new APIErrors(timeStamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Media Type not supported";
		APIErrors errors = new APIErrors(timeStamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Path Variable is missing";
		APIErrors errors = new APIErrors(timeStamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Request Parameter is missing";
		APIErrors errors = new APIErrors(timeStamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
	        HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "No Handler found";
		APIErrors errors = new APIErrors(timeStamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Type mismatch";
		APIErrors errors = new APIErrors(timeStamp, message, status.value(), error);
		return ResponseEntity.status(status).body(errors);
	}

	@ExceptionHandler(CourseNotFoundException.class)
	protected ResponseEntity<Object> handleCoursetNotFound(CourseNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Course Not Found";
		APIErrors errors = new APIErrors(timeStamp, message, HttpStatus.EXPECTATION_FAILED.value(), error);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errors);
	}

	@ExceptionHandler(CredentialNotFoundException.class)
	protected ResponseEntity<Object> handleCredentialNotFound(CredentialNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Credential Not Found";
		APIErrors errors = new APIErrors(timeStamp, message, HttpStatus.EXPECTATION_FAILED.value(), error);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errors);
	}

	@ExceptionHandler(InstructorNotFoundException.class)
	protected ResponseEntity<Object> handleInstructorNotFound(InstructorNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Instructor Not Found";
		APIErrors errors = new APIErrors(timeStamp, message, HttpStatus.EXPECTATION_FAILED.value(), error);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errors);
	}

	@ExceptionHandler(PurchaseHistoryNotFoundException.class)
	protected ResponseEntity<Object> handlePurchaseHistoryNotFound(PurchaseHistoryNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "PurchaseHistory Not Found";
		APIErrors errors = new APIErrors(timeStamp, message, HttpStatus.EXPECTATION_FAILED.value(), error);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errors);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	protected ResponseEntity<Object> handleStudentNotFound(StudentNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Student Not Found";
		APIErrors errors = new APIErrors(timeStamp, message, HttpStatus.EXPECTATION_FAILED.value(), error);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errors);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleOther(Exception ex) {
		String message = ex.getMessage();
		LocalDateTime timeStamp = LocalDateTime.now();
		String error = "Other Exception";
		APIErrors errors = new APIErrors(timeStamp, message, HttpStatus.BAD_REQUEST.value(), error);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

}
