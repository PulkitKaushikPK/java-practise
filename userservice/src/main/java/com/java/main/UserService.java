package com.java.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


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

	public ResponseEntity<Object> postToCart(UserRequest request) throws JsonProcessingException {
		
		User user= new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		User us=calling(user);
		ResponseEntity<Object> responseUser= saveUser(user);
		String obj= mapper.writeValueAsString(request.getItems());
		Cart cart= new Cart();
		cart.setCheckoutFlag(false);
		cart.setDetails(obj);
		cart.setUserId(us.getUserId());
		System.out.println("usersaved is: "+ us);
		
		System.out.println("mapper shows"+ obj);
		Object res= restTemplate.postForEntity("http://localhost:8082/cart/", cart, Object.class);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
	public User calling(User user) {
		User out= userRepository.save(user);
		return out;
	}

}
