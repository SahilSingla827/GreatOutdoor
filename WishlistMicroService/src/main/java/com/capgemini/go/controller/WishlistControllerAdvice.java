package com.capgemini.go.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.exception.SimilarProductAlreadyExistException;
import com.capgemini.go.exception.UserNotFoundException;

@ControllerAdvice
public class WishlistControllerAdvice {

	@ExceptionHandler(SimilarProductAlreadyExistException.class)
	  public ResponseEntity<String> similarProductAlreadyExistException(final SimilarProductAlreadyExistException e) {
		
	    return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
	  }
	
	@ExceptionHandler(ProductNotFoundException.class)
	  public ResponseEntity<String> productNotFoundException(final ProductNotFoundException e) {
		
	    return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(UserNotFoundException.class)
	  public ResponseEntity<String> userNotFoundException(final UserNotFoundException e) {
		
	    return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	  }
}
