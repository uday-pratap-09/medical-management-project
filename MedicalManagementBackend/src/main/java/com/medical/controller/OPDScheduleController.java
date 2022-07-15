package com.medical.controller;

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

import com.medical.model.OPD.OPDSchedule;
import com.medical.service.OPDScheduleService;

@RestController
@CrossOrigin("*")
@RequestMapping("/opdSchedule")
public class OPDScheduleController {
	@Autowired
	private OPDScheduleService opd_ScheduleService;
	//add opd schedule service
	@PostMapping("/")
	public ResponseEntity<OPDSchedule> add(@RequestBody OPDSchedule opd_Schedule){
		return ResponseEntity.ok(this.opd_ScheduleService.addOpd_Schedule(opd_Schedule));
	}
	//update opd schedule
	@PutMapping("/")
	public ResponseEntity<OPDSchedule> update(@RequestBody OPDSchedule opd_Schedule){
		return ResponseEntity.ok(this.opd_ScheduleService.updateOpd_Schedule(opd_Schedule));
	}
	//get schedule
	@GetMapping("/")
	public ResponseEntity<?> schedules(){
		return ResponseEntity.ok(this.opd_ScheduleService.getOpd_Schedules());
	}
	//get single schedule
	@GetMapping("/{oid}")
	public OPDSchedule schedule(@PathVariable("oid")Long oid) {
		return this.opd_ScheduleService.getOpd_Schedule(oid);
	}
	//delete schedule
	@DeleteMapping("/{oid}")
	public void delete(@PathVariable("oid") Long oid) {
		this.opd_ScheduleService.deleteOpd_Schedule(oid);
	}
}
