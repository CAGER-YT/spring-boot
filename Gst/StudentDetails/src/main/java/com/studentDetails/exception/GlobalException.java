package com.studentDetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=CustomException.class)
	public ResponseEntity<Object> getException(CustomException ce){
		return new ResponseEntity<>(ce.getMessage(),HttpStatus.NOT_FOUND);
	}
	

}
