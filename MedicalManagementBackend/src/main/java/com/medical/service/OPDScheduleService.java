package com.medical.service;

import java.util.Set;

import com.medical.model.OPD.OPDSchedule;

public interface OPDScheduleService {
	public OPDSchedule addOpd_Schedule(OPDSchedule opd);
	public OPDSchedule updateOpd_Schedule(OPDSchedule opd);
	public Set<OPDSchedule>getOpd_Schedules();
	public OPDSchedule getOpd_Schedule(Long opdId);
	public void deleteOpd_Schedule(Long opdId);
	
}
