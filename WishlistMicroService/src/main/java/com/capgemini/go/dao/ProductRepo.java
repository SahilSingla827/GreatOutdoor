package com.capgemini.go.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.go.dto.ProductDto;


@Repository
public interface ProductRepo extends JpaRepository<ProductDto, String> {
	public ProductDto findByProductId(String productId);
}
