package com.medical.model.OPD;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dId;
	private String doctorName;
	private String doctorMobileNo;
	private String doctorEmailId;
	private String doctorQualification;
	private String doctorWorkExperience;
	@ManyToOne(fetch = FetchType.EAGER)
	private OPDSchedule opd;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	public Doctor(String doctorName, String doctorMobileNo, String doctorEmailId, String doctorQualification,
			String doctorWorkExperience, OPDSchedule opd) {
		super();
		this.doctorName = doctorName;
		this.doctorMobileNo = doctorMobileNo;
		this.doctorEmailId = doctorEmailId;
		this.doctorQualification = doctorQualification;
		this.doctorWorkExperience = doctorWorkExperience;
		this.opd = opd;
	}
	public Long getdId() {
		return dId;
	}
	public void setdId(Long dId) {
		this.dId = dId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorMobileNo() {
		return doctorMobileNo;
	}
	public void setDoctorMobileNo(String doctorMobileNo) {
		this.doctorMobileNo = doctorMobileNo;
	}
	public String getDoctorEmailId() {
		return doctorEmailId;
	}
	public void setDoctorEmailId(String doctorEmailId) {
		this.doctorEmailId = doctorEmailId;
	}
	public String getDoctorQualification() {
		return doctorQualification;
	}
	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}
	public String getDoctorWorkExperience() {
		return doctorWorkExperience;
	}
	public void setDoctorWorkExperience(String doctorWorkExperience) {
		this.doctorWorkExperience = doctorWorkExperience;
	}
	public OPDSchedule getOpdschedule() {
		return opd;
	}
	public void setOpdSchedule(OPDSchedule opd) {
		this.opd = opd;
	}
}