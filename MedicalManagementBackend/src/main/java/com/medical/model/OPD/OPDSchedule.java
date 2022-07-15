package com.medical.model.OPD;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OPDSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sId;
	private String opdName;
	private String consultantName;
	private String opdDays;
	private String location;
	private String opdRegistrationTimings;
	private String numberOfDoctors;
	public String getNumberOfDoctors() {
		return numberOfDoctors;
	}
	public void setNumberOfDoctors(String numberOfDoctors) {
		this.numberOfDoctors = numberOfDoctors;
	}
	private boolean active=false;
	@ManyToOne(fetch = FetchType.EAGER)
	private Department department;
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	@OneToMany(mappedBy ="opd",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Doctor> doctors=new HashSet<>();
	
	public OPDSchedule() {
		// TODO Auto-generated constructor stub
	}
	public OPDSchedule(String opdName, String consultantName, String opdDays, String location,
			String opdRegistrationTimings, boolean active) {
		super();
		this.opdName = opdName;
		this.consultantName = consultantName;
		this.opdDays = opdDays;
		this.location = location;
		this.opdRegistrationTimings = opdRegistrationTimings;
		this.active = active;
	}
	public long getsId() {
		return sId;
	}
	public void setsId(long sId) {
		this.sId = sId;
	}
	public String getOpdName() {
		return opdName;
	}
	public void setOpdName(String opdName) {
		this.opdName = opdName;
	}
	public String getConsultantName() {
		return consultantName;
	}
	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}
	public String getOpdDays() {
		return opdDays;
	}
	public void setOpdDays(String opdDays) {
		this.opdDays = opdDays;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOpdRegistrationTimings() {
		return opdRegistrationTimings;
	}
	public void setOpdRegistrationTimings(String opdRegistrationTimings) {
		this.opdRegistrationTimings = opdRegistrationTimings;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
