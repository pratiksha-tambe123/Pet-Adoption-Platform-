package com.pet.service;

import com.pet.entities.User;

public interface IUserService {

	public User registerUser(String email, String password,String role);
	
	public User authenticateUser(String email, String password);

	public User getUserById(Integer userId);
	
}
