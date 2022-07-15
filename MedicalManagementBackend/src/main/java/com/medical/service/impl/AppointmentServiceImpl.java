package com.medical.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.model.OPD.Appointment;
import com.medical.model.OPD.Department;
import com.medical.repository.AppointmentRepository;
import com.medical.service.AppointmentService;
@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Override
	public Appointment addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return this.appointmentRepository.save(appointment);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return this.appointmentRepository.save(appointment);
	}

	@Override
	public Set<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.appointmentRepository.findAll());
	}

	@Override
	public Appointment getAppointment(Long patientId) {
		// TODO Auto-generated method stub
		return this.appointmentRepository.findById(patientId).get();
	}

	@Override
	public void deleteAppointment(Long patientId) {
		// TODO Auto-generated method stub

	}

}
