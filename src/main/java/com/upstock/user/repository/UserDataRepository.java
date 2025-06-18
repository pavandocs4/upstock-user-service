package com.upstock.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.upstock.user.entity.UserData;

public interface UserDataRepository extends MongoRepository<UserData, String>{

	Optional<UserData> findByUsername(String username);

}
