package com.java.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService {
	
	 @Autowired
	  private CartRepository cartRepository;
	 
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 public ResponseEntity<Object> saveCart(Cart cart) {
		 
		 Cart newcart=cartRepository.save(cart);
	     return new ResponseEntity<>(newcart,HttpStatus.OK);
	    }
	 
	 public ResponseEntity<Object> getCartDetailsById(Long id) {	     
		 Cart user=cartRepository.getById(id);
	       return new ResponseEntity<>(user,HttpStatus.OK);
	    }
	 
	 public ResponseEntity<Object> getCartDetailsByUserId(Long id) {	     
		 	Cart user=cartRepository.getByUserId(id);
	       return new ResponseEntity<>(user,HttpStatus.OK);
	    }
	 
	 public ResponseEntity<Object> getProductDetailsByCart(Long id) {	     
		 ResponseModel model=new ResponseModel();
		 Cart cart=cartRepository.getById(10L);
		 System.out.println("here we have: "+cart);
		 Product productDetail= restTemplate.getForObject("http://localhost:8081/products/"+id.toString(), Product.class);
		 model.setProduct(productDetail);
		 model.setCart(cart);
		 System.out.println("combind they are: "+model);
	     return new ResponseEntity<>(model,HttpStatus.OK);
	    }
	 

}
