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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@Api("Wishlist Management Service")
public class WishlistController {
	String productId;
	String userId;
	
	@Autowired
	WishlistService wishService;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value = "/addProductToWishlist",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add product to Wishlist")
	public ResponseEntity<String> addProductToWishlist(@ApiParam(value="Wish in json format")@RequestBody Wish wishedProduct)
	{
		logger.info("Adding product to wishlist");
		WishlistDto w = new WishlistDto(wishedProduct);
		String response = wishService.addProductToWishlist(w);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/removeProductFromWishlist")
	@ApiOperation(value = "Remove Product From Wishist")
	public ResponseEntity<String> removeProductFromWishlist(@ApiParam(value="Wish in json format")@RequestBody Wish wishedProduct)
	{
		logger.info("Removing product from wishlist");
		WishlistDto w = new WishlistDto(wishedProduct);
		String response = wishService.removeProductFromWishlist(w);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(value="allWishlistProducts/{userId}")
	@ApiOperation(value = "Get All Products In User Wishlist")
	public ResponseEntity<List<ProductDto>> viewAllProductsInWishlist( @ApiParam(value="UserId of the user")@PathVariable String userId)
	{
		logger.info("Displaying All products in User wishlist");
		List<ProductDto> productsList = wishService.viewAllProductsInWishlist(userId);
		return new ResponseEntity<>(productsList,HttpStatus.OK);
	}
}
