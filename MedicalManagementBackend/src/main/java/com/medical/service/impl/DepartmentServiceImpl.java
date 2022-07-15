package com.medical.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.model.OPD.Department;
import com.medical.repository.DepartmentRepository;
import com.medical.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		return this.departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return this.departmentRepository.save(department);
	}

	@Override
	public Set<Department> getDepartments() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.departmentRepository.findAll());
	}

	@Override
	public Department getDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		return this.departmentRepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		Department department=new Department();
		department.setDid(departmentId);
		this.departmentRepository.delete(department);
	}

}
