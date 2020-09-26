package com.capgemini.go.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.dto.ProductDto;
import com.capgemini.go.dto.Wish;
import com.capgemini.go.dto.WishlistDto;
import com.capgemini.go.service.WishlistService;



@RestController
public class WishlistController {
	String productId;
	String userId;
	
	@Autowired
	WishlistService wishService;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value = "/addProductToWishlist",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addProductToWishlist(@RequestBody Wish wishedProduct)
	{
		logger.info("Adding product to wishlist");
		WishlistDto w = new WishlistDto(wishedProduct);
		String response = wishService.addProductToWishlist(w);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/removeProductFromWishlist")
	public ResponseEntity<String> removeProductFromWishlist(@RequestBody Wish wishedProduct)
	{
		logger.info("Removing product from wishlist");
		WishlistDto w = new WishlistDto(wishedProduct);
		String response = wishService.removeProductFromWishlist(w);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(value="allWishlistProducts/{userId}")
	public ResponseEntity<List<ProductDto>> viewAllProductsInWishlist(@PathVariable String userId)
	{
		logger.info("Displaying All products in User wishlist");
		List<ProductDto> productsList = wishService.viewAllProductsInWishlist(userId);
		return new ResponseEntity<>(productsList,HttpStatus.OK);
	}
}
