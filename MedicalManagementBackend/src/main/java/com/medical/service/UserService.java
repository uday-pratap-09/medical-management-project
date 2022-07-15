package com.medical.service;

import java.util.Set;

import com.medical.model.User;
import com.medical.model.UserRole;

public interface UserService {
	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	//get user by username
	public User getUser(String username);
	//delete user by id
	public void deleteUser(Long userId);
}
