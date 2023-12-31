package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/*
 * All available custom exceptions
 * and rest will be handles by exception class
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EndUserException.class)
	public ResponseEntity<MyErrorDetails> endUserExceptionhandler(EndUserException eu, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(eu.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserLocationException.class)
	public ResponseEntity<MyErrorDetails> userLocationExceptionHandler(UserLocationException ule, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ule.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
}
