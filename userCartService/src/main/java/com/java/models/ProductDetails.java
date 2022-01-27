package com.java.models;

public class ProductDetails {
	
	private Long quantity;
	private Long productId;
	@Override
	public String toString() {
		return "ProductDetails [quantity=" + quantity + ", productId=" + productId + "]";
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public ProductDetails(Long quantity, Long productId) {
		super();
		this.quantity = quantity;
		this.productId = productId;
	}
	
	public ProductDetails() {}

}
