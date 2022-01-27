package com.java.models;

import java.util.List;

public class UserRequest {
	
	 private String firstName;
	 private String lastName;
	 private String email;
	 private boolean checkOut;
	 private List<CartDetails> items;
	 
	 public UserRequest(String firstName, String lastName, String email, boolean checkOut, List<CartDetails> items) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.checkOut = checkOut;
		this.items = items;
	}
	
	 public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<CartDetails> getItems() {
		return items;
	}
	public void setItems(List<CartDetails> items) {
		this.items = items;
	}
	public UserRequest(String firstName, String lastName, String email, List<CartDetails> items) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.items = items;
	}
	@Override
	public String toString() {
		return "UserRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", checkOut="
				+ checkOut + ", items=" + items + "]";
	}
	 
	public UserRequest() {}
	public boolean isCheckOut() {
		return checkOut;
	}
	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}
	 

}
