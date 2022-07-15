package com.medical.model.OPD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patientId;
//	private String opdName;
//	private String consultantName;
//	private String location;
	private String patientName;
	private String patientGender;
	private String patientAge;
	private String patientMobileNumber;
	private String patientAddress;
	private String appointmentDate;
	private String appointmentTime;
	private String patientDisease;
	public Appointment() {
	}
	
	public Appointment(Long patientId, String patientName,
			String patientGender, String patientAge, String patientMobileNumber, String patientAddress,
			String appointmentDate, String appointmentTime, String patientDisease) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.patientMobileNumber = patientMobileNumber;
		this.patientAddress = patientAddress;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.patientDisease = patientDisease;
	}


	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}

	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getPatientDisease() {
		return patientDisease;
	}
	public void setPatientDisease(String patientDisease) {
		this.patientDisease = patientDisease;
	}
	
}
