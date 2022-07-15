package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medical.model.OPD.OPDSchedule;

public interface OPDScheduleRepository extends JpaRepository<OPDSchedule,Long> {

}
