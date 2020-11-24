package com.springboot.token.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.token.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {

	User findByUsername(String username);

}
