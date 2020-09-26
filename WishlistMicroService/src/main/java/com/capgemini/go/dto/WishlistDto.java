package com.capgemini.go.dto;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



@Table(name = "wishlist")
@Entity
public class WishlistDto {
	
	@EmbeddedId
	private Wish wish;
	public String getUserId() {
		return wish.getUserId();
	}
	public void setUserId(String userId) {
		wish.setUserId(userId);
	}
	public String getProductId() {
		return wish.getProductId();
	}
	public void setProductId(String productId) {
		wish.setProductId(productId); 
	}
	public WishlistDto() {
		super();
	}
	public WishlistDto(Wish wish) {
		super();
		this.wish = wish;
	}
	
}
