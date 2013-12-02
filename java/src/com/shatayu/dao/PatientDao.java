package com.shatayu.dao;

import java.util.List;
import java.util.Map;

import com.shatayu.model.Patient;

public interface PatientDao {
	public List<Patient> addPatients(List<Patient> p);
	public List<Patient> deletePatients(List<Patient> p);
	public List<Patient> updatePatients(List<Patient> p);
	public List<Patient> listAllPatients();
	public List<Patient> listPatientById(long patientId);
	public List<Patient> searchPatientByName(String name,String cond);
	public List<Patient> searchPatientByPhoneNumber(String phNumber);
	
}