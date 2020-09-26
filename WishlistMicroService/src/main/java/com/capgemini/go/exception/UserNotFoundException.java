package com.capgemini.go.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final String userId;

	public UserNotFoundException(String userId) {
		super("There exist no items in the user wishlist with User Id : "+userId);
		this.userId = userId;
	}
	

}
