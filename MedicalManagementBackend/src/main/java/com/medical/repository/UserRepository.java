package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	public User findByUsername(String username);
}
