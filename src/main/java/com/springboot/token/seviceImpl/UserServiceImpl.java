package com.springboot.token.seviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.token.entity.AuthenticationRequest;
import com.springboot.token.entity.User;
import com.springboot.token.repository.UserRepository;
import com.springboot.token.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//MongoTemplate mongoTemplate;
	
	@Override
	public User saveUser(User user) {
	
		return userRepository.save(user);
		//return "data saved successfully";
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		//AuthenticationRequest authenticationRequest = null;
	return (UserDetails) new User(user.getUsername(),user.getPassword());
	}

	@Override
	public Optional<User> findUserById(Long id) {
		
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public String updateUser(Long id, User user) {
		Optional<User> user1 = userRepository.findById(id);
		User userData = user1.get();
		if(user1.isPresent()) {
//			User userData = user1.get();
			userData.setFirstName(user.getFirstName());
			userData.setLastName(user.getLastName());
			userData.setUsername(user.getUsername());
			userData.setPassword(user.getPassword());
			userData.setContactNumber(user.getContactNumber());
			userData.setDob(user.getDob());
			 userRepository.save(userData);
			 return "USER UPDATED SUCCESSFULLY";
		}
		else {
			return "No record found with these Id";
		}
		
		
	}

}
