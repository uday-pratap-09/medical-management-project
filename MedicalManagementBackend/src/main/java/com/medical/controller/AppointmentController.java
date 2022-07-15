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

import com.medical.model.OPD.Appointment;
import com.medical.model.OPD.Department;
import com.medical.service.AppointmentService;
import com.medical.service.DepartmentService;

@RestController
@RequestMapping("/appointment")
@CrossOrigin("*")
public class AppointmentController {
	//add department
	@Autowired
	private AppointmentService appointmentService;
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Appointment appointment){
		Appointment appointment2=this.appointmentService.addAppointment(appointment);
		return ResponseEntity.ok(appointment2);
	}
	//get department
	@GetMapping("/{appointmentId}")
	public Appointment getDepartment(@PathVariable("appointmentId")Long appointmentId) {
		return this.appointmentService.getAppointment(appointmentId);
	}
	//get all departments
	@GetMapping("/")
	public ResponseEntity<?> getAppointment()
{
		return ResponseEntity.ok(this.appointmentService.getAppointments());
}
//update Category
@PutMapping("/")
public Appointment updateAppointment(@RequestBody Appointment appointment) {
	return this.appointmentService.updateAppointment(appointment);
}
@DeleteMapping("/{appointmentId}")
public void deleteDepartment(@PathVariable("appointmentId")Long appointmentId) {
	this.appointmentService.deleteAppointment(appointmentId);
}
}
