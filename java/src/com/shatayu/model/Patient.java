package com.shatayu.model;

// Generated 11 Jan, 2010 12:08:37 AM by Hibernate Tools 3.2.0.beta8

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

/**
 *             This class contains the patient details.
 *         
 */
public class Patient implements java.io.Serializable {

	// Fields    

	private long patientId;
	private String firstName;
	private String lastName;
	private String middleName;
	private long age;
	private String sex;
	private Timestamp initialDate;
	private String mobile1;
	private String mobile2;
	private String landline;
	private String knownCases;
	private String history;
	private String address;
	private Collection<Treatment> treatment;
	private Collection<PatientPanchkarma> panchkarmaTreatment;

	// Constructors

	/** default constructor */
	public Patient() {
	}

	/** minimal constructor */
	public Patient(String firstName, String sex, Timestamp initialDate) {
		this.firstName = firstName;
		this.sex = sex;
		this.initialDate = initialDate;
	}

	/** full constructor */
	public Patient(String firstName, String lastName, String middleName,
			long age, String sex, Timestamp initialDate, String mobile1,
			String mobile2, String landline, String knownCases, String history,
			String address, Collection<Treatment> treatment,
			Collection<PatientPanchkarma> panchkarmaTreatment) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.age = age;
		this.sex = sex;
		this.initialDate = initialDate;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.landline = landline;
		this.knownCases = knownCases;
		this.history = history;
		this.address = address;
		this.treatment = treatment;
		this.panchkarmaTreatment = panchkarmaTreatment;
	}

	// Property accessors
	public long getPatientId() {
		return this.patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public long getAge() {
		return this.age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getInitialDate() {
		return this.initialDate;
	}

	public void setInitialDate(Timestamp initialDate) {
		this.initialDate = initialDate;
	}

	public String getMobile1() {
		return this.mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return this.mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getLandline() {
		return this.landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getKnownCases() {
		return this.knownCases;
	}

	public void setKnownCases(String knownCases) {
		this.knownCases = knownCases;
	}

	public String getHistory() {
		return this.history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Treatment> getTreatment() {
		return this.treatment;
	}

	public void setTreatment(Collection<Treatment> treatment) {
		this.treatment = treatment;
	}

	public Collection<PatientPanchkarma> getPanchkarmaTreatment() {
		return this.panchkarmaTreatment;
	}

	public void setPanchkarmaTreatment(
			Collection<PatientPanchkarma> panchkarmaTreatment) {
		this.panchkarmaTreatment = panchkarmaTreatment;
	}
	
	public String toString() {
		return this.patientId + "  "+this.firstName+"  "+this.lastName;
    }
	
	public Patient clone() {
		Patient p = new Patient();
		p.setPatientId(patientId);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setMiddleName(middleName);
		p.setAge(age);
		p.setSex(sex);
		p.setInitialDate(initialDate);
		p.setMobile1(mobile1);
		p.setMobile2(mobile2);
		p.setLandline(landline);
		p.setKnownCases(knownCases);
		p.setHistory(history);
		p.setAddress(address);
		p.setTreatment(treatment);
		p.setPanchkarmaTreatment(panchkarmaTreatment);
		return p;
		
		
    }
	
	public void copyToPatientObject(Patient p) {
		this.setPatientId(p.getPatientId());
		this.setFirstName(p.getFirstName());
		this.setLastName(p.getLastName());
		this.setMiddleName(p.getMiddleName());
		this.setAge(p.getAge());
		this.setSex(p.getSex());
		this.setInitialDate(p.getInitialDate());
		this.setMobile1(p.getMobile1());
		this.setMobile2(p.getMobile2());
		this.setLandline(p.getLandline());
		this.setKnownCases(p.getKnownCases());
		this.setHistory(p.getHistory());
		this.setAddress(p.getAddress());
		List trlist = (List)p.getTreatment();
		List originalTreatment = (List)this.getTreatment();
		if(trlist != null){
			for (int i = 0; i < trlist.size(); i++) {
				Treatment tr = (Treatment)trlist.get(i);
				tr.setPatient(this);
				if(tr.getTreatmentId() == 0 ){
					originalTreatment.add(tr);
					continue;
				}
				for (int j = 0; j < originalTreatment.size(); j++) {
					Treatment trTemp = (Treatment)originalTreatment.get(j);
					if(trTemp.getTreatmentId() == tr.getTreatmentId()){
						trTemp.copyToTreatmentObject(tr);
					}
				}
			}
		}
		
		List panchkarmaList = (List)p.getPanchkarmaTreatment();
		List originalPanchkarmaList = (List)this.getPanchkarmaTreatment();
		if(panchkarmaList == null)return;
		
		for (int k = 0; k < panchkarmaList.size(); k++) {
			PatientPanchkarma ppT = (PatientPanchkarma)panchkarmaList.get(k);
			ppT.setPatient(this);
			
			if(ppT.getPatientPanchId() == 0){
				
				originalPanchkarmaList.add(ppT);
				continue;
			}
			for (int l = 0; l < originalPanchkarmaList.size(); l++) {
				PatientPanchkarma ppTemp = (PatientPanchkarma)originalPanchkarmaList.get(l);
				if(ppTemp.getPatientPanchId() == ppT.getPatientPanchId()){
					ppTemp.copyToPatientPanchkarmaObject(ppT);
				}
			}
		}
		
		//this.setTreatment(treatment);
		//this.setPanchkarmaTreatment(panchkarmaTreatment);
		
		
		
    }

}
