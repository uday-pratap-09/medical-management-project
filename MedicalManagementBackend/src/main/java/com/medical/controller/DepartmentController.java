package com.medical.controller;

import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medical.model.OPD.Department;
import com.medical.service.DepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin("*")
public class DepartmentController {
	//add department
	@Autowired
	private DepartmentService departmentService;
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Department department){
		Department department1=this.departmentService.addDepartment(department);
		return ResponseEntity.ok(department1);
	}
	//get department
	@GetMapping("/{departmentId}")
	public Department getDepartment(@PathVariable("departmentId")Long departmentId) {
		return this.departmentService.getDepartment(departmentId);
	}
	//get all departments
	@GetMapping("/")
	public ResponseEntity<?> getDepartment()
{
		return ResponseEntity.ok(this.departmentService.getDepartments());
}
//update Category
@PutMapping("/")
public Department updateDepartment(@RequestBody Department department) {
	return this.departmentService.updateDepartment(department);
}
@DeleteMapping("/{departmentId}")
public void deleteDepartment(@PathVariable("departmentId")Long departmentId) {
	this.departmentService.deleteDepartment(departmentId);
}
}
