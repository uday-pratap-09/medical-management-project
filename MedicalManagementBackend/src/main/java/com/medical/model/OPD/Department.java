package com.medical.model.OPD;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long did;
	private String departmentName;
	private String description;
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private Set<OPDSchedule> schedule=new LinkedHashSet<>();
	public Department() {
	}
	public Department(String departmentName, String description) {
		super();
		this.departmentName = departmentName;
		this.description = description;
	}
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
