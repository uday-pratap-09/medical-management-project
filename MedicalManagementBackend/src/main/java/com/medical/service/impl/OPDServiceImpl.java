package com.medical.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.model.OPD.OPDSchedule;
import com.medical.repository.OPDScheduleRepository;
import com.medical.service.OPDScheduleService;
@Service
public class OPDServiceImpl implements OPDScheduleService {
	@Autowired
	private OPDScheduleRepository opd_ScheduleRepository;
	@Override
	public OPDSchedule addOpd_Schedule(OPDSchedule opd) {
		// TODO Auto-generated method stub
		return this.opd_ScheduleRepository.save(opd);
	}

	@Override
	public OPDSchedule updateOpd_Schedule(OPDSchedule opd) {
		// TODO Auto-generated method stub
		return this.opd_ScheduleRepository.save(opd);
	}
	@Override
	public Set<OPDSchedule> getOpd_Schedules() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.opd_ScheduleRepository.findAll());
	}
	@Override
	public OPDSchedule getOpd_Schedule(Long opdId) {
		// TODO Auto-generated method stub
		return this.opd_ScheduleRepository.findById(opdId).get();
	}

	@Override
	public void deleteOpd_Schedule(Long opdId) {
		// TODO Auto-generated method stub
//		OPD_Schedule opd_Schedule=new OPD_Schedule();
//		opd_Schedule.setsId(opdId);
		this.opd_ScheduleRepository.deleteById(opdId);
	}


}
