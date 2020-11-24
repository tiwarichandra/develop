package com.springboot.token.service;

import java.util.List;
import java.util.Optional;

import com.springboot.token.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public Optional<User> findUserById(Long id);
	
	public List<User> getAllUser();
	
	public String updateUser(Long id,User user);

}
