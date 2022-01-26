package com.java.main;

public class ResponseModel {
	
	private Cart cart;
	@Override
	public String toString() {
		return "ResponseModel [cart=" + cart + ", product=" + product + "]";
	}
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public ResponseModel(Cart cart, Product product) {
		super();
		this.cart = cart;
		this.product = product;
	}
	
	public ResponseModel() {}
	
	

}
