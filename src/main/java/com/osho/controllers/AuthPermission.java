package com.osho.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.osho.model.Users;
import com.osho.services.UsersServices;

@RestController
@RequestMapping("/authenticate")
public class AuthPermission {
	
	private static final String CLAZZ = AuthPermission.class.getSimpleName();
	private static final Log LOG = LogFactory.getLog(CLAZZ);
	
	@Autowired
	UsersServices userServices;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	BCrypt bCrypt;
	
	private boolean result = false;

	@PostMapping("/login/user")
	public ModelAndView authenticateLogin(@RequestBody Map<String, String> userData)
	{
		Map<String, String> json = new HashMap<>();
		ModelAndView model = new ModelAndView();
		String username = userData.get("username");
		String password = userData.get("password");
		model.setStatus(HttpStatus.OK);
		
		LOG.info(CLAZZ+" Password : "+ password);
		LOG.info(CLAZZ+" inside Post"+ userData);
		
		model.setViewName("index");
		
		Users user = userServices.getUserName(username);
		result = !user.getLoginid().isEmpty() ? BCrypt.checkpw(password, user.getPassword()) : false;
		json.put("role", "role_name");
		json.put("token", "token_role_name");
		 
		if(!result)
		{
			json.put("user", "NOT_EXIST");
			json.put("status", "NOT_EXIST");
			model.setStatus(HttpStatus.NO_CONTENT);
		}
		//default : password
		//$2a$10$hvnZXAj6B8UoQN/QNXxCJOEN1mhy2hlA.9cATtrQ73xRP1/N50ate 
		LOG.info(CLAZZ+" Result:"+result);
		
		return model;
	}
	
	@RequestMapping(method = RequestMethod.OPTIONS, value = "/authenticate")
	public String authenticateLoginOp(@RequestBody Map<String, String> userData)
	{
		Map<String, String> json = new HashMap<>();
		json.put("role", "role_name");
		json.put("token", "token_role_name");
		
		LOG.info(CLAZZ+" inside Options:"+ userData);
		
		String username = userData.get("username");
		String password = userData.get("password");
		
		userServices.getAllUsers().forEach(user -> {
			try 
			{
				if(user.getLoginid().equals(username) 
						&& user.getPassword().equals(password)) 
				{ 
				  result=true;
				}
			} 
			catch (Exception e) 
			{
				LOG.info(CLAZZ+" Exception :", e);
			}
		});
		
		LOG.info(CLAZZ+" Result:"+ result);
		return  "success";
	}
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}

