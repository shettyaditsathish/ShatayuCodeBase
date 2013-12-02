package com.shatayu.model;

// Generated 16 Jan, 2010 12:33:53 PM by Hibernate Tools 3.2.0.beta8

import java.sql.Timestamp;

/**
 *             This class contains the patient treatment details.
 *         
 */
public class PatientPanchkarma implements java.io.Serializable {

	// Fields    

	private long patientPanchId;
	private long panchkarmaId;
	private Timestamp startDate;
	private Timestamp endDate;
	private String results;
	private String paid;
	private float amountPaid;
	
	private String paymentType;
	private Patient patient;
	private float balance;

	// Constructors

	/** default constructor */
	public PatientPanchkarma() {
	}

	/** minimal constructor */
	public PatientPanchkarma(Timestamp startDate, Timestamp endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/** full constructor */
	public PatientPanchkarma(long panchkarmaId, Timestamp startDate,
			Timestamp endDate, String results, String paid, float amountPaid,
			float cost, Patient patient) {
		this.panchkarmaId = panchkarmaId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.results = results;
		this.paid = paid;
		this.amountPaid = amountPaid;
		
		this.patient = patient;
	}

	// Property accessors
	public long getPatientPanchId() {
		return this.patientPanchId;
	}

	public void setPatientPanchId(long patientPanchId) {
		this.patientPanchId = patientPanchId;
	}

	public long getPanchkarmaId() {
		return this.panchkarmaId;
	}

	public void setPanchkarmaId(long panchkarmaId) {
		this.panchkarmaId = panchkarmaId;
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

	public String getResults() {
		return this.results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getPaid() {
		return this.paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public float getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	
	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void copyToPatientPanchkarmaObject(PatientPanchkarma pp) {
		this.setPatientPanchId(pp.getPatientPanchId());
		this.setPanchkarmaId(pp.getPanchkarmaId());
		this.setStartDate(pp.getStartDate());
		this.setEndDate(pp.getEndDate());
		this.setResults(pp.getResults());
		this.setPaid(pp.getPaid());
		this.setAmountPaid(pp.getAmountPaid());
		this.setPaymentType(pp.getPaymentType());
		this.setPatient(pp.getPatient());
		this.setBalance(pp.getBalance());
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
