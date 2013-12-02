package com.shatayu.model;

// Generated 8 Jun, 2010 10:12:14 PM by Hibernate Tools 3.2.0.beta8

import java.sql.Timestamp;

/**
 *             This class contains the patient appointment details.
 *         
 */
public class Appointment implements java.io.Serializable {

	// Fields    

	private long appointmentId;
	private Timestamp apptStartDate;
	private Timestamp apptEndDate;
	private String apptStatus;
	private Organiser organiser;

	// Constructors

	/** default constructor */
	public Appointment() {
	}

	/** minimal constructor */
	public Appointment(Timestamp apptStartDate, Timestamp apptEndDate) {
		this.apptStartDate = apptStartDate;
		this.apptEndDate = apptEndDate;
	}

	/** full constructor */
	public Appointment(Timestamp apptStartDate, Timestamp apptEndDate,
			String apptStatus, Organiser organiser) {
		this.apptStartDate = apptStartDate;
		this.apptEndDate = apptEndDate;
		this.apptStatus = apptStatus;
		this.organiser = organiser;
	}

	// Property accessors
	public long getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Timestamp getApptStartDate() {
		return this.apptStartDate;
	}

	public void setApptStartDate(Timestamp apptStartDate) {
		this.apptStartDate = apptStartDate;
	}

	public Timestamp getApptEndDate() {
		return this.apptEndDate;
	}

	public void setApptEndDate(Timestamp apptEndDate) {
		this.apptEndDate = apptEndDate;
	}

	public String getApptStatus() {
		return this.apptStatus;
	}

	public void setApptStatus(String apptStatus) {
		this.apptStatus = apptStatus;
	}

	public Organiser getOrganiser() {
		return this.organiser;
	}

	public void setOrganiser(Organiser organiser) {
		this.organiser = organiser;
	}
	
	public void copyToAppointmentObject(Appointment appt) {
		this.setAppointmentId(appt.getAppointmentId());
		this.setApptEndDate(appt.getApptEndDate());
		this.setApptStartDate(appt.getApptStartDate());
		this.setApptStatus(appt.getApptStatus());
		this.setOrganiser(appt.getOrganiser());
	}
	
	public Appointment clone(){
		Appointment appt = new Appointment();
		appt.setAppointmentId(this.getAppointmentId());
		appt.setApptEndDate(this.getApptEndDate());
		appt.setApptStartDate(this.getApptStartDate());
		appt.setApptStatus(this.getApptStatus());
		appt.setOrganiser(this.getOrganiser());
		return appt;
	}
}
