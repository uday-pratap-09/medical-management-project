package com.medical.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.model.OPD.Doctor;
import com.medical.model.OPD.OPDSchedule;
import com.medical.repository.DoctorRepository;
import com.medical.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return this.doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return this.doctorRepository.save(doctor);
	}

	@Override
	public Set<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.doctorRepository.findAll());
	}

	@Override
	public Doctor getDoctor(Long dId) {
		// TODO Auto-generated method stub
		return this.doctorRepository.findById(dId).get();
	}

	@Override
	public Set<Doctor> getDoctorsByOPD(OPDSchedule opd) {
		// TODO Auto-generated method stub

		// return this.doctorRepository.findByOPD(opd);
		

		return this.doctorRepository.findByOpd(opd);

	}

	@Override
	public void deleteDoctor(Long dId) {
		// TODO Auto-generated method stub
		Doctor doctor = new Doctor();
		doctor.setdId(dId);
		this.doctorRepository.delete(doctor);
	}

}
