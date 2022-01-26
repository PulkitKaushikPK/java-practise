package com.java.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/")
	public ResponseEntity<Object> saveTocart(@RequestBody Cart cart){
		return cartService.saveCart(cart);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCartDetailsById(@PathVariable("id") Long cartId){
		return cartService.getCartDetailsById(cartId);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Object> getCartDetailsByUserId(@PathVariable("id") Long userId){
		return cartService.getProductDetailsByCart(userId);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveTocart1(@RequestBody Cart cart){
		return cartService.saveCart(cart);
	}
	
	
	
	

}
