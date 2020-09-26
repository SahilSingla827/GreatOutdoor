package com.capgemini.go.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.go.dto.Wish;
import com.capgemini.go.dto.WishlistDto;
import com.capgemini.go.exception.ProductNotFoundException;
import com.capgemini.go.exception.SimilarProductAlreadyExistException;
import com.capgemini.go.exception.UserNotFoundException;

@SpringBootTest
class WishlistServiceImplTest {
	
	@Autowired
	WishlistService service;

	@Test
	void testAddProductToWishlistPass() {
		WishlistDto wishObj = new WishlistDto(new Wish("U10001","P10004"));
		assertThat(service.addProductToWishlist(wishObj)).isEqualTo("Product got added successfully to wishlist");
		service.removeProductFromWishlist(wishObj);
	}
	
	@Test
	void testAddProductToWishlistExceptionCase() {
		WishlistDto wishObj = new WishlistDto(new Wish("U10001","P10001"));
		assertThrows(SimilarProductAlreadyExistException.class, ()->{service.addProductToWishlist(wishObj);});
	}

	@Test
	void testFindProductInWishlistPass() {
		WishlistDto wishObj = new WishlistDto(new Wish("U10001","P10002"));
		assertThat(service.findProductInWishlist(wishObj)).isTrue();
	}
	
	@Test
	void testFindProductInWishlistFail() {
		WishlistDto wishObj = new WishlistDto(new Wish("U10001","P10006"));
		assertThat(service.findProductInWishlist(wishObj)).isFalse();
	}

	@Test
	void testRemoveProductFromWishlistPass() {
		WishlistDto wishObj = new WishlistDto(new Wish("U10001","P10001"));
		assertThat(service.removeProductFromWishlist(wishObj)).isEqualTo("Product removed successfully from wishlist");
		service.addProductToWishlist(wishObj);
	}
	
	@Test
	void testRemoveProductFromWishlistExceptionCase() {
		WishlistDto wishObj = new WishlistDto(new Wish("U10001","P10007"));
		assertThrows(ProductNotFoundException.class, ()->{service.removeProductFromWishlist(wishObj);});
	}

	@Test
	void testViewAllProductsInWishlistPass() {
		assertThat(service.viewAllProductsInWishlist("U10001")).isNotEmpty();
	}
	
	@Test
	void testViewAllProductsInWishlistExceptionCase() {
		assertThrows(UserNotFoundException.class, ()->{service.viewAllProductsInWishlist("U10006");});
	}

	@Test
	void testFindUserInWishlistPass() {
		WishlistDto wishObj = new WishlistDto(new Wish("U10001","P10002"));
		assertThat(service.findUserInWishlist(wishObj.getUserId())).isTrue();
	}
	
	@Test
	void testFindUserInWishlistFail() {
		WishlistDto wishObj = new WishlistDto(new Wish("U10007","P10002"));
		assertThat(service.findUserInWishlist(wishObj.getUserId())).isFalse();
	}


}
