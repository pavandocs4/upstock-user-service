package com.upstock.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.newpackage.TestService;
import com.upstock.client.starter.lib.autoconfigtest.ConfigTestService;
import com.upstock.client.starter.lib.global.exception.UserAlreadyExists;
import com.upstock.client.starter.lib.global.exception.UserException;
import com.upstock.client.starter.lib.global.exception.UserNotFound;
import com.upstock.user.entity.UserData;
import com.upstock.user.service.UserService;


@CrossOrigin(
	    origins = "http://localhost:3000",
	    methods = {RequestMethod.GET, RequestMethod.POST},
	    allowedHeaders = "*",
	    allowCredentials = "true"
	)
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//This bean is autowired from the another library to introduce concept of @import annotation
	@Autowired
	private ConfigTestService configTestService;
	
	@Autowired
	private TestService testService;
	
	@PostMapping("/create")
	public ResponseEntity<UserData> saveUserDetails(@RequestBody UserData user) throws UserAlreadyExists{
		UserData savedUser = userService.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserData> getUserDetails(@PathVariable String id) throws UserNotFound{
		UserData user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	@PostMapping("/testApi")
	public ResponseEntity<String> getTestResponse(){
		String res = userService.testMethod();
		return new ResponseEntity<String>(res, HttpStatus.OK);
		
	}
	
	@GetMapping("/testRandom")
	public ResponseEntity<Double> getTestRandomNoResponse(){
		double res = testService.randomNoGenerator();
		configTestService.testConfigMsg();
		return new ResponseEntity<Double>(res, HttpStatus.OK);
		
	}
	
}
