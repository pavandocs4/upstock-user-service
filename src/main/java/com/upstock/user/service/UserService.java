package com.upstock.user.service;

import org.springframework.stereotype.Service;

import com.upstock.client.starter.lib.global.exception.UserAlreadyExists;
import com.upstock.user.entity.UserData;

@Service
public interface UserService {
	UserData saveUser(UserData User) throws UserAlreadyExists;
}
