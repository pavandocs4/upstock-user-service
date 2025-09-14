package com.upstock.user.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upstock.client.starter.lib.global.exception.UserAlreadyExists;
import com.upstock.client.starter.lib.global.exception.UserException;
import com.upstock.client.starter.lib.global.exception.UserNotFound;
import com.upstock.user.custom.cache.CustomCache;
import com.upstock.user.entity.UserData;
import com.upstock.user.repository.UserDataRepository;
import com.upstock.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDataRepository userRepository;

	@Override
	public UserData saveUser(UserData user) throws UserAlreadyExists {
		// TODO Auto-generated method stub
		UserData savedUser = new UserData();
		try {

			if (userRepository.findByUsername(user.getUsername()).isPresent())
				throw new Exception("User already exists");
			savedUser = userRepository.insert(user);
		} catch (Exception e) {
			throw new UserAlreadyExists("USER_001", e.getMessage());
		}
		return savedUser;

	}
	
	
	//Assignment-> implement the custom cache to get the user by id
	@Override
	@CustomCache
	public UserData getUserById(String id) throws UserNotFound {
		// TODO Auto-generated method stub
		UserData user = new UserData();
		try {
			user = userRepository.findById(id).orElseThrow(Exception::new
			);
		} catch(Exception e) {
			throw new UserNotFound("USER_002", "User not found with id:"+id);
		}
		
		return user;
	}

	@Override
	public String testMethod() {
		// TODO Auto-generated method stub 
		//
		
		HttpResponse<String> res = null;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(URI.create("http://localhost:8081/login/saveAccessCode?code=abcxy"))
				.GET()
				.build();
		try {
			res = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// @GetMapping("/saveAccessCode")
	  //  public ResponseEntity<String> saveAccessCode(@RequestParam("code") String accessCode )
		return res.body();
	}

}
