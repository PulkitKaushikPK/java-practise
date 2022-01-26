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
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<Object> saveProduct(@RequestBody Product user){
		return productService.saveProduct(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") Long productId){
		return productService.getProductById(productId);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Object> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/sort/price")
	public ResponseEntity<Object> sortProductByPrice(){
		return productService.sortProductByPrice();
	}
	
	@GetMapping("/filter/{price}")
	public ResponseEntity<Object> filterProductByPrice(@PathVariable("price") Long price){
		return productService.filterProductByPrice(price);
	}
	
	@GetMapping("/sort/rating")
	public ResponseEntity<Object> sortProductByRating(){
		return productService.sortProductByRating();
	}
	
	@GetMapping("/quantity/{id}")
	public ResponseEntity<Object> availableProducts(@PathVariable("id") Long productId){
		return productService.getQuantityById(productId);
	}
	
	
}
