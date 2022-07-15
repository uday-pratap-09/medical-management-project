package com.medical.controller;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Collections;
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

import com.medical.model.OPD.Doctor;
import com.medical.model.OPD.OPDSchedule;
import com.medical.service.DoctorService;
import com.medical.service.OPDScheduleService;


@RestController
@CrossOrigin("*")
@RequestMapping("/doctors")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private OPDScheduleService opdScheduleService;
	//add doctor
	@PostMapping("/")
	public ResponseEntity<Doctor> add(@RequestBody Doctor doctor){
		return ResponseEntity.ok(this.doctorService.addDoctor(doctor));
	}
	//update doctor details
	@PutMapping("/")
	public ResponseEntity<Doctor> update(@RequestBody Doctor doctor){
		return ResponseEntity.ok(this.doctorService.updateDoctor(doctor));
	}
	//get all doctors of any opd
	@GetMapping("/opd/{sId}")
	public ResponseEntity<?> getDoctorsByOPD(@PathVariable("sId")Long sId){
//		OPD_Schedule opd_Schedule=new OPD_Schedule();
//		opd_Schedule.setsId(dId);
//		Set<Doctor> getdoctorsbyOPD=this.doctorService.getDoctorsByOPD(opd_Schedule);
//		return ResponseEntity.ok(getdoctorsbyOPD);
		//OPD_Schedule opd_Schedule=new OPD_Schedule();
//		Set<Doctor> doctors=opd_Schedule.getDoctors();
//		List list=new ArrayList(doctors);
//		if(list.size()>Integer.parseInt(opd_Schedule.get))
		OPDSchedule opd_Schedule2=this.opdScheduleService.getOpd_Schedule(sId);
		Set<Doctor> doctors=opd_Schedule2.getDoctors();
		List list=new ArrayList(doctors);
		if(list.size()>Integer.parseInt(opd_Schedule2.getNumberOfDoctors())) {
			list=list.subList(0, Integer.parseInt(opd_Schedule2.getNumberOfDoctors()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	//get single doctor
	@GetMapping("/{opdId}")
	public Doctor get(@PathVariable("opdId")Long opdId) {
		return this.doctorService.getDoctor(opdId);
	}
	//delete question
	@DeleteMapping("/{opdId}")
	public void delete(@PathVariable("opdId")Long opdId) {
		this.doctorService.deleteDoctor(opdId);
	}
}
