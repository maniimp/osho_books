package com.osho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osho.model.Users;
import com.osho.services.UsersServices;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersServices userServices;
	
	@GetMapping("/user")
	public List<Users> displayAllUSers()
	{
		return userServices.getAllUsers();
	}
	
	@GetMapping("/user/{userId}")
	public Users display(@PathVariable Long userId)
	{
		return userServices.getUser(userId);
	}
	
	@PostMapping("/user")
	public String addUsers(@RequestBody Users user)
	{
		userServices.addUser(user);
		return userServices.getUser(user.getUser_id()).getLoginid();
		
	}
	
	@DeleteMapping("/user/{userId}")
	public String deleteUser(@PathVariable Long userId)
	{
		String userLogin = userServices.getUser(userId).getLoginid();
		userServices.deleteUser(userId);
		return userLogin;
	}
	
}
