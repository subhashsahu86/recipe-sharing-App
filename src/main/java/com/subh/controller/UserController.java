package com.subh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subh.entity.User;
import com.subh.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;

	 @PostMapping("/newUser")
	public User createUser(@RequestBody User user) throws Exception {
		
		 //use Service
		 User createdUser = userService.createUser(user);
		 
		 return createdUser;
		
	}
	 
	 @DeleteMapping("/users/{userId}")
	 public String deleteUser( @PathVariable Long userId) throws Exception {
		  
		 //use service
		 
		 userService.deleteUser(userId);
	
	        return "User Deleted Successfully Having userId : " + userId;
	 }
	  
	 @GetMapping("/users")
	 public List<User> getAllUsers(){
		 
		 //use service
		 
		 List<User> users = userService.findAllUsers();
	   
		 return users;
	 }
	
	 
	 
	 
}
