package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.dto.ProductDto;
import com.capgemini.go.dto.WishlistDto;

public interface WishlistService {

	public String addProductToWishlist(WishlistDto wish);
	public String removeProductFromWishlist(WishlistDto wish);
	public List<ProductDto> viewAllProductsInWishlist(String userId);
	public boolean findProductInWishlist(WishlistDto wishedProduct);
	public boolean findUserInWishlist(String userId);
}
