package com.java.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cart")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Cart {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long cartId;	
	private Long productId;	
	private Long userId;
	private Long quantity;
	private boolean checkoutFlag;
	public Cart(Long cartId, Long productId, Long userId, Long quantity, boolean checkoutFlag) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.checkoutFlag = checkoutFlag;
	}


	public boolean isCheckoutFlag() {
		return checkoutFlag;
	}


	public void setCheckoutFlag(boolean checkoutFlag) {
		this.checkoutFlag = checkoutFlag;
	}


	public Cart(Long cartId, Long productId, Long userId, Long quantity) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productId=" + productId + ", userId=" + userId + ", quantity=" + quantity
				+ ", checkoutFlag=" + checkoutFlag + "]";
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Cart() {}
	
	

}
