package com.shatayu.dao;

import java.util.Date;
import java.util.List;

import com.shatayu.model.Appointment;

public interface AppointmentDao {
	public List<Appointment> saveAppointmentDetails(List<Appointment> appointment);
	public List<Appointment> getAppointmentsDetailsByDate(Date startDate, Date endDate);
	public List<Appointment> getAppointmentsDetailsByDateAndPatientId(Date startDate, Date endDate, long patientId);
	public List<Appointment> getAppointmentsDetailsByAppointmentId(String apptId);
	public List<Appointment> deleteAppointmentDetails(List<Appointment> appointment);
}
