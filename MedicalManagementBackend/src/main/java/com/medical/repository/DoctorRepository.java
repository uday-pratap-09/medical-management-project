package com.medical.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.medical.model.OPD.Doctor;
import com.medical.model.OPD.OPDSchedule;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

	//Set<Doctor> findByOpdschedule(OPD_Schedule opd);

	//Set<Doctor> findbyOpd(OPD_Schedule opd);

	Set<Doctor> findByOpd(OPDSchedule opd);

}
