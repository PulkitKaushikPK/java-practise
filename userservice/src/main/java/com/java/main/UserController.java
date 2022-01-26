package com.java.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<Object> saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUsers(@PathVariable("id") Long userId){
		return userService.getUserById(userId);
	}
	
	@PostMapping("/get")
	public ResponseEntity<Object> getUsers(@RequestBody UserRequest request) throws JsonProcessingException{
//		System.out.println("body is: "+request);
		return userService.postToCart(request);
//		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	
	
   

}