package com.medical.service;

import java.util.Set;

import com.medical.model.OPD.Appointment;
import com.medical.model.OPD.Department;

public interface AppointmentService {
	public Appointment addAppointment(Appointment appointment);
	public Appointment updateAppointment(Appointment appointment);
	public Set<Appointment> getAppointments();
	public Appointment getAppointment(Long patientId);
	public void deleteAppointment(Long patientId);
}
