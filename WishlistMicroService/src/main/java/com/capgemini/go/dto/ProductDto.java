package com.capgemini.go.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="product_table")
@Entity
public class ProductDto {
	@Column(name="product_id")
	@Id
	private String productId;
	@Column(name="product_name")
	private String productName;
	private String category;
	private double price;
	private String manufacturer;
	private String description;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return productName;
	}
	public void setName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductDto() {
		super();
	}
	public ProductDto(String productId, String productName, String category, String description, double price,
			String manufacturer) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.manufacturer = manufacturer;
		this.description = description;
	}
	
}
