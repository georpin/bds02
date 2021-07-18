package com.devsuperior.bds02.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.service.exception.DatabaseException;
import com.devsuperior.bds02.service.exception.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError();
		standardError.setError("Database exception");
		standardError.setMessage(e.getMessage());
		standardError.setPath(request.getRequestURI());
		standardError.setStatus(status.value());
		standardError.setTimestamp(Instant.now());
		return ResponseEntity.status(status).body(standardError);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError();
		standardError.setError("Resource not found");
		standardError.setMessage(e.getMessage());
		standardError.setPath(request.getRequestURI());
		standardError.setStatus(status.value());
		standardError.setTimestamp(Instant.now());
		return ResponseEntity.status(status).body(standardError);
	}
}
