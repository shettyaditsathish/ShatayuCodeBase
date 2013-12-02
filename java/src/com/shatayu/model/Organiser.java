package com.shatayu.model;

// Generated 8 Jun, 2010 10:12:14 PM by Hibernate Tools 3.2.0.beta8

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

/**
 *             This class contains the patient organiser details.
 *         
 */
public class Organiser implements java.io.Serializable {

	// Fields    

	private long organiserId;
	private long panchkarmaId;
	private String treatmentDetails;
	private Timestamp startDate;
	private Timestamp endDate;
	private String paid;
	private String status;
	private String apptType;
	private float amountPaid;
	private Patient patient;
	private Collection<Appointment> appointment;
	private float balance;
	// Constructors

	/** default constructor */
	public Organiser() {
	}

	/** minimal constructor */
	public Organiser(Timestamp startDate, Timestamp endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/** full constructor */
	public Organiser(long panchkarmaId, String treatmentDetails,
			Timestamp startDate, Timestamp endDate, String paid, String status,
			String apptType, Patient patient,
			Collection<Appointment> appointment) {
		this.panchkarmaId = panchkarmaId;
		this.treatmentDetails = treatmentDetails;
		this.startDate = startDate;
		this.endDate = endDate;
		this.paid = paid;
		this.status = status;
		this.apptType = apptType;
		this.patient = patient;
		this.appointment = appointment;
	}

	// Property accessors
	public long getOrganiserId() {
		return this.organiserId;
	}

	public void setOrganiserId(long organiserId) {
		this.organiserId = organiserId;
	}

	public long getPanchkarmaId() {
		return this.panchkarmaId;
	}

	public void setPanchkarmaId(long panchkarmaId) {
		this.panchkarmaId = panchkarmaId;
	}

	public String getTreatmentDetails() {
		return this.treatmentDetails;
	}

	public void setTreatmentDetails(String treatmentDetails) {
		this.treatmentDetails = treatmentDetails;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getPaid() {
		return this.paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApptType() {
		return this.apptType;
	}

	public void setApptType(String apptType) {
		this.apptType = apptType;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Collection<Appointment> getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Collection<Appointment> appointment) {
		this.appointment = appointment;
	}
	
	public void copyToOrganiserObject(Organiser org) {
		this.setOrganiserId(org.getOrganiserId());
		this.setPanchkarmaId(org.getPanchkarmaId());
		this.setTreatmentDetails(org.getTreatmentDetails());
		this.setStartDate(org.getStartDate());
		this.setEndDate(org.getEndDate());
		this.setPaid(org.getPaid());
		this.setAmountPaid(org.getAmountPaid());
		this.setStatus(org.getStatus());
		this.setApptType(org.getApptType());
		this.setBalance(org.getBalance());
		this.getPatient().copyToPatientObject(org.getPatient());
		List apptList = (List)org.getAppointment();
		List orgApptList = (List)this.getAppointment();
		for(int i= 0 ;i< apptList.size();i++){
			Appointment appointment = (Appointment)apptList.get(i);
			if(appointment.getAppointmentId() == 0){
				orgApptList.add(appointment);
				continue;
			}
			for(int j= 0 ;j< orgApptList.size();j++){
				Appointment orgAppt= (Appointment)orgApptList.get(i);
				if(orgAppt.getAppointmentId() == appointment.getAppointmentId()){
					orgAppt.copyToAppointmentObject(appointment);
				}
			}
		}
	}
	
	public Organiser clone(){
		Organiser org = new Organiser();
		org.setOrganiserId(this.getOrganiserId());
		org.setPanchkarmaId(this.getPanchkarmaId());
		org.setTreatmentDetails(this.getTreatmentDetails());
		org.setStartDate(this.getStartDate());
		org.setEndDate(this.getEndDate());
		org.setPaid(this.getPaid());
		org.setAmountPaid(this.getAmountPaid());
		org.setStatus(this.getStatus());
		org.setApptType(this.getApptType());
		org.setPatient(this.getPatient().clone());
		org.setAppointment(this.getAppointment());
		org.setBalance(this.getBalance());
		return org;
	}

	public float getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}
