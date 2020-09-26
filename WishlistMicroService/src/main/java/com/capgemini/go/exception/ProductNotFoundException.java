package com.capgemini.go.exception;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final String productId;

	public ProductNotFoundException(String productId) {
		super("There exists no product with Product Id : "+productId+" that can be removed from your wishlist");
		this.productId = productId;
	}
	

}
