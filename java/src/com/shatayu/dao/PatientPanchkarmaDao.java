package com.shatayu.dao;

import java.util.Date;
import java.util.List;

import com.shatayu.model.PatientPanchkarma;

public interface PatientPanchkarmaDao{
	public List<PatientPanchkarma> getPanchkarmaTreatmentByDate(Date startDate,Date endDate);
	public List<PatientPanchkarma> deletePanchkarmaTreatments(List panchTreatList);
	public List<PatientPanchkarma> getPanchkarmaTreatmentByDetails(long patientId,long panchkarmaId,Date startDate,
			Date endDate);
}
 