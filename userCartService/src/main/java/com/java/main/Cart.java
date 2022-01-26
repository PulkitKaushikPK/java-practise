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
	private Long userId;
	private String details;
	private boolean checkoutFlag;
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public boolean isCheckoutFlag() {
		return checkoutFlag;
	}
	public void setCheckoutFlag(boolean checkoutFlag) {
		this.checkoutFlag = checkoutFlag;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", details=" + details + ", checkoutFlag="
				+ checkoutFlag + "]";
	}
	public Cart(Long cartId, Long userId, String details, boolean checkoutFlag) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.details = details;
		this.checkoutFlag = checkoutFlag;
	}
	
}