package com.medical.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.model.Role;
import com.medical.model.User;
import com.medical.model.UserRole;
import com.medical.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")

public class UserController {
	//creating user
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	//@ExceptionHandler(Exception.class)
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setPasssword(this.bCryptPasswordEncoder.encode(user.getPasssword()));
		Set<UserRole> roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(46L);
		role.setRoleName("Normal");
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		return this.userService.createUser(user,roles);
	}
	//@ExceptionHandler(Exception.class)
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	//delete  the user by id
	//@ExceptionHandler(Exception.class)
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
}
