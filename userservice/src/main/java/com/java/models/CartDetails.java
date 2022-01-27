package com.java.models;

public class CartDetails {
	
	private Long quantity;
	private Long productId;
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
	public CartDetails(Long quantity, Long productId) {
		super();
		this.quantity = quantity;
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "CartDeiatls [quantity=" + quantity + ", productId=" + productId + "]";
	}
	
	public CartDetails() {}
}
