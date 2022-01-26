package com.java.main;

public class Cart {
	
	
	private Long userId;
	private String details;
	private boolean checkoutFlag;
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
		return "Cart [userId=" + userId + ", details=" + details + ", checkoutFlag=" + checkoutFlag + "]";
	}
	public Cart(Long userId, String details, boolean checkoutFlag) {
		super();
		this.userId = userId;
		this.details = details;
		this.checkoutFlag = checkoutFlag;
	}

	
	public Cart() {}
}
