package com.pet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pet.entities.User;
import com.pet.enums.RoleEnum;
import com.pet.repository.UserRepository;

import jakarta.transaction.Transactional;
@Component
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private  BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User registerUser(String email, String password,String role) {
		User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        //user.setPassword(passwordEncoder.encode(password)); // In real applications, hash the password
        user.setRole(RoleEnum.valueOf(role));
        return userRepository.save(user);
	}

	@Override
	public User authenticateUser(String email, String password) {
		User user = userRepository.findByEmail(email);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            return user;
//        }
		if(user!=null && user.getPassword().equals(password)) {
			return user;
		}
        return null;
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepository.getById(userId);
				//.orElseThrow(()-> new RuntimeException("User nor found"));
	}

}
