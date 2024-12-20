package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {
	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<Object> handle(ProductNotFound p){
		return new ResponseEntity<>("The Product is out of Stock",HttpStatus.GATEWAY_TIMEOUT);
	}
	
    @ExceptionHandler(InvalidProduct.class)
    public ResponseEntity<String> handleInvalidProductException(InvalidProduct ex) {
        // Customize the response for InvalidProduct exception
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}

