package com.java.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.exceptions.InvalidRequestBodyException;
import com.java.exceptions.ResourceNotFoundException;
import com.java.models.Cart;
import com.java.models.Product;
import com.java.models.ProductDetails;
import com.java.models.ResponseModel;
import com.java.repository.CartRepository;

@Service
public class CartService {
	
	 @Autowired
	  private CartRepository cartRepository;
	 
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 @Autowired
	 ObjectMapper mapper;
	 
	 
	 public ResponseEntity<Object> saveCart(Cart cart) {
		 
		 if(cart==null) {
			 throw new ResourceNotFoundException("Enter valid request to enter to cart");
		 }
		 Cart newcart=cartRepository.save(cart);		 
	     return new ResponseEntity<>(newcart,HttpStatus.OK);
	    }
	 
	 public ResponseEntity<Object> updateCart(Long userId) throws JsonMappingException, JsonProcessingException {
		
		 if(userId==null) {
			 throw new InvalidRequestBodyException("Enter userId to retrieve object");
		 }
		Cart cart=cartRepository.getByUserId(userId);
		String userOrders=cart.getDetails(); 
		Long productId,quantity;
		List<ProductDetails> myObjects = Arrays.asList(mapper.readValue(userOrders, ProductDetails[].class));		
		for(ProductDetails product: myObjects) {
			productId=product.getProductId();
			quantity=product.getQuantity();
		 updateProductDetails(productId,quantity);
		 
		}
		cart.setCheckoutFlag(true);
		Cart result=cartRepository.save(cart);
				 
	    return new ResponseEntity<>(result,HttpStatus.OK);
	    }
	 
	 
	 public ResponseEntity<Object> getCartDetailsByUserId(Long id) {	     
		 	Cart user=cartRepository.getByUserId(id);
	       return new ResponseEntity<>(user,HttpStatus.OK);
	    }
	 
	 public ResponseEntity<Object> getProductDetailsByCart(Long id) {	     
		 ResponseModel model=new ResponseModel();
		 Cart cart=cartRepository.getById(10L);
		 System.out.println("here we have: "+cart);
		 Product productDetail= restTemplate.getForObject("http://PRODUCT-SERVICE/products/"+id.toString(), Product.class);
		 model.setProduct(productDetail);
		 model.setCart(cart);
		 System.out.println("combind they are: "+model);
	     return new ResponseEntity<>(model,HttpStatus.OK);
	    }
	 
	 public ResponseEntity<Object> updateProductDetails(Long pId, Long quantity){
		 
		restTemplate.put("http://PRODUCT-SERVICE/products/update/"+pId.toString()+"/"+quantity.toString(), Object.class);

		 return new ResponseEntity<>("SuccesFully Updated Products",HttpStatus.OK);
	 }
	 
	 public boolean isNullOrEmpty(String value) {
			if(value != null && !"".equals(value)) {
				return false;
			}
			else {
				return true;
			}
		}

	 
	 

}
