package com.capgemini.go.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.go.dto.Wish;
import com.capgemini.go.dto.WishlistDto;

@Repository
public interface WishlistDao extends JpaRepository<WishlistDto, Wish> {
	public List<WishlistDto> findByWishUserId(String userId);
	public List<WishlistDto> findByWishProductId(String productId);
	
	
}
