package com.capgemini.go.exception;

public class SimilarProductAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final String productId;

	public SimilarProductAlreadyExistException(String productId) {
		super("This product is already there in your wishlist");
		this.productId = productId;
	}
	

}
