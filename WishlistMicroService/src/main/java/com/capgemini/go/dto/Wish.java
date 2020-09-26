package com.capgemini.go.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Wish implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="user_id")
	private String userId;
	@Column(name="product_id")
	private String productId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Wish(Wish w) {
		super();
		this.userId = w.getUserId();
		this.productId = w.getProductId();
	}
	public Wish() {
		super();
	}
	public Wish(String userId, String productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}
	
	

}
