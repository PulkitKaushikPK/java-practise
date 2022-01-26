package com.java.main;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Entity
//@Table(name = "product")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Product implements Serializable {
	
//	private static final long serialVersionUID = 1L;

//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
	private String name;
	private String description;
	private Long price;
	private Long maxQuantity;
	private Long ratings;
	
	public Product(Long productId, String name, String description, Long price, Long maxQuantity, Long ratings) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.maxQuantity = maxQuantity;
		this.ratings = ratings;
	}

	
	public Product() {}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", maxQuantity=" + maxQuantity + ", ratings=" + ratings + "]";
	}


	public Long getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(Long maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public Long getRatings() {
		return ratings;
	}

	public void setRatings(Long ratings) {
		this.ratings = ratings;
	}
	
	

}
