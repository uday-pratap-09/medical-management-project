package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.model.OPD.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
