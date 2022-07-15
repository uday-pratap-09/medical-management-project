package com.medical.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medical.config.JwtUtils;
import com.medical.model.JwtRequest;
import com.medical.model.JwtResponse;
import com.medical.model.User;
import com.medical.service.impl.UserDetailsServiceImpl;
@CrossOrigin("*")
@RestController
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private JwtUtils jwtUtils;
	
	//generate token
	@ExceptionHandler(Exception.class)
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		} catch (UsernameNotFoundException e) {
			// TODO: handle exception
			throw new Exception("User Not Found");
		}
		//user authenticated
	UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	String token=this.jwtUtils.generateToken(userDetails);
	return ResponseEntity.ok(new JwtResponse(token));
	}
	private void authenticate(String username,String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			// TODO: handle exception
			throw new Exception("USER DISABLED "+e.getMessage());
		}catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Invalid Credentials "+e.getMessage());
		}
	}
	//return the details of current user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
		
	}
}
