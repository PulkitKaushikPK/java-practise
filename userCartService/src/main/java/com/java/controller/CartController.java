package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.java.models.Cart;
import com.java.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/") 
	public ResponseEntity<Object> saveTocart(@RequestBody Cart cart){
		return cartService.saveCart(cart);
	}
	
	//To get Cart by userId
	@GetMapping("/{userId}") 
	public ResponseEntity<Object> getCartDetailsById(@PathVariable("userId") Long userId) throws JsonMappingException, JsonProcessingException{
		return cartService.getCartDetailsByUserId(userId);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Object> getCartDetailsByUserId(@PathVariable("id") Long userId){
		return cartService.getProductDetailsByCart(userId);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveTocart1(@RequestBody Cart cart){
		return cartService.saveCart(cart);
	}
	
	//For updating cart 
	@PutMapping("/checkout/{userId}")
	public ResponseEntity<Object> checkOut(@PathVariable("userId") Long userId) throws JsonMappingException, JsonProcessingException{
		return cartService.updateCart(userId);
	}
	
	
	
	

}
