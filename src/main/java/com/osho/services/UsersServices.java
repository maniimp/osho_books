package com.osho.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osho.model.Users;
import com.osho.repository.UsersRespository;

@Service
public class UsersServices {
	
	@Autowired
	UsersRespository userRepository;
	
	Users itrUser;
	
	public List<Users> getAllUsers(){
		List<Users> userList = new ArrayList<Users>();
		userRepository.findAll().forEach(userList ::add);
		userList.forEach(user -> System.out.println("user : "+user.getUser_id().toString()));
		return userList;
	}
	
	public Users getUser(Long id) {
		return userRepository.findById(id).get();
	}
	
	public Users getUserName(String username) {
		
		userRepository.findAll().forEach(user -> {
			if(user.getLoginid().equals(username))
			{
				itrUser = user;
			}
		});
		return itrUser;
	}
	
	public void addUser(Users user) {
		userRepository.save(user);
	}
	
	public void updateUser(Long id,Users user) {
		userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
