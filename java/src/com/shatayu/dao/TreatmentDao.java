package com.shatayu.dao;

import java.util.Date;
import java.util.List;


import com.shatayu.model.Treatment;

public interface TreatmentDao {
	public List<Treatment> addTreatments(List<Treatment> treatmentList);
	public List<Treatment> updateTreatments(List<Treatment> treatmentList);
	public List<Treatment> deleteTreatments(List<Treatment> treatmentList);
	public List<Treatment> getTreatmentsById(long treatmentId);
	public List<Treatment> getTreatmentsByPatientId(long patientId);
	public List<Treatment> getTreatmentsByDate(Date startDate, Date endDate);
	
}
