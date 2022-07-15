package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.model.OPD.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
