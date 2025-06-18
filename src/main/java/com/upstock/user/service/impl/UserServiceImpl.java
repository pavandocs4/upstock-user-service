package com.upstock.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upstock.client.starter.lib.global.exception.UserAlreadyExists;
import com.upstock.user.entity.UserData;
import com.upstock.user.repository.UserDataRepository;
import com.upstock.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDataRepository userRepository;
	
	@Override
	public UserData saveUser(UserData user) throws UserAlreadyExists {
		// TODO Auto-generated method stub
		UserData savedUser = new UserData();
		try {
			userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new Exception("User already exists"));
			savedUser = userRepository.insert(user);
		} catch(Exception e) {
			throw new UserAlreadyExists("USER_001", e.getMessage());
		}
		return savedUser;
		
	}

}
