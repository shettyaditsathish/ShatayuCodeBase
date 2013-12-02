package com.shatayu.dao;

import java.util.Date;
import java.util.List;

import com.shatayu.model.Organiser;

public interface OrganiserDao {
	public List<Organiser> saveAppointment(List<Organiser> appointment);
	public List<Organiser> getAppointmentsByDate(Date startDate, Date endDate);
	public List<Organiser> getAppointmentsByPatientId(long patientId);
	public List<Organiser> getAppointmentsByDateAndPatientId(Date startDate, Date endDate, long patientId);
	public List<Organiser> deleteAppointment(List<Organiser> appointment);
}
