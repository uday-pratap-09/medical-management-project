package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	
}
