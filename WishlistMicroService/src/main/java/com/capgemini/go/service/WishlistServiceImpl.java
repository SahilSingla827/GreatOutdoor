package com.capgemini.go.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.dao.ProductRepo;
import com.capgemini.go.dao.WishlistDao;
import com.capgemini.go.dto.ProductDto;
import com.capgemini.go.dto.WishlistDto;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.exception.SimilarProductAlreadyExistException;
import com.capgemini.go.exception.UserNotFoundException;

@Service
public class WishlistServiceImpl implements WishlistService{
	
	
	
	@Autowired
	WishlistDao wishlistDao;
	
	@Autowired
	ProductRepo productDao;
	
	WishlistDto wishedProduct ;

	@Override
	public String addProductToWishlist(WishlistDto wish) {
		boolean productExist = findProductInWishlist( wish);
		if(productExist)
		{
			throw new SimilarProductAlreadyExistException(wish.getProductId());
		}
		else
		{
			wishlistDao.save(wish);
			return "Product got added successfully to wishlist";
			
		}
		
	}
	
	@Override
	public boolean findProductInWishlist(WishlistDto wishedProduct)
	{
		List<WishlistDto> existingWishlistProducts = wishlistDao.findByWishUserId(wishedProduct.getUserId());
		for(WishlistDto wishObj : existingWishlistProducts)
		{
			if(wishObj.getProductId().equals(wishedProduct.getProductId()))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public String removeProductFromWishlist(WishlistDto wish) {
		
		boolean productExist = findProductInWishlist( wish);
		if(productExist)
		{
			wishlistDao.delete(wish);
		}
		else
		{
			throw new ProductNotFoundException(wish.getProductId());
		}
		
		return "Product removed successfully from wishlist";
	}

	@Override
	public List<ProductDto> viewAllProductsInWishlist(String userId) {
		boolean userExist = findUserInWishlist(userId);
		if(userExist)
		{
			List<WishlistDto>userWishlist = wishlistDao.findByWishUserId(userId);
			List<ProductDto>products = new ArrayList<>();
			for(WishlistDto wishlistProduct :userWishlist )
			{
				ProductDto product = productDao.findByProductId(wishlistProduct.getProductId());
				products.add(product);
			}
			return products;
		}
		else
		{
			throw new UserNotFoundException(userId);
		}
	}
	
	@Override
	public boolean findUserInWishlist(String userId)
	{
		List<WishlistDto> existingUser = wishlistDao.findByWishUserId(userId);
		if(!existingUser.isEmpty() && existingUser.get(0)!=null && existingUser.get(0).getUserId().equals(userId))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
