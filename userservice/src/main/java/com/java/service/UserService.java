package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.models.Cart;
import com.java.models.User;
import com.java.models.UserRequest;
import com.java.repository.UserRepository;


@Service
public class UserService {
	
	 @Autowired
	  private UserRepository userRepository;
	 
	 @Autowired
	 private RestTemplate restTemplate;
	 
	 ObjectMapper mapper = new ObjectMapper();
	 
	 public ResponseEntity<Object> saveUser(User user) {
		 User newUser=userRepository.save(user);
	     return new ResponseEntity<>(newUser,HttpStatus.OK);
	    }
	 
	 public ResponseEntity<Object> getUserById(Long id) {	     
		 	User user=userRepository.getById(id);
	       return new ResponseEntity<>(user,HttpStatus.OK);
	    }
	 
	 
//used for post checkout
	public ResponseEntity<Object> postToCart(UserRequest request) throws JsonProcessingException {
		
		User user= new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		User savedUser=saveuser(user);
		ResponseEntity<Object> responseUser= saveUser(user);
		String items= mapper.writeValueAsString(request.getItems());
		Cart cart= new Cart();
		cart.setCheckoutFlag(false);
		cart.setDetails(items);
		cart.setUserId(savedUser.getUserId());
		System.out.println("usersaved is: "+ savedUser);
		
		System.out.println("mapper shows"+ items);
		Object res= restTemplate.postForEntity("http://localhost:8082/cart/", cart, Object.class);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	public User saveuser(User user) {
		User out= userRepository.save(user);
		return out;
	}
	
	

}
