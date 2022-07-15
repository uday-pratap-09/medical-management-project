package com.medical.service;

import java.util.Set;

import com.medical.model.OPD.Department;

public interface DepartmentService {
	public Department addDepartment(Department department);
	public Department updateDepartment(Department addDepartment);
	public Set<Department> getDepartments();
	public Department getDepartment(Long departmentId);
	public void deleteDepartment(Long departmentId);
}
