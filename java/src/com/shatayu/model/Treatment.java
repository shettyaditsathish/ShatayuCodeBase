package com.shatayu.model;

// Generated 16 Jan, 2010 12:06:45 PM by Hibernate Tools 3.2.0.beta8

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

/**
 *             This class contains the patient treatment details.
 *         
 */
public class Treatment implements java.io.Serializable {

	// Fields    

	private long treatmentId;
	private Timestamp treatmnetDate;
	private String signsSymptons;
	private String tongue;
	private String pulse;
	private String results;
	private String paid;
	private String paymentType;
	private float amountPaid;
	private Collection<TreatmentDrug> treatmentDrug;
	private Patient patient;
	private float balance;

	// Constructors

	/** default constructor */
	public Treatment() {
	}

	/** minimal constructor */
	public Treatment(Timestamp treatmnetDate, String signsSymptons,
			String tongue, String pulse) {
		this.treatmnetDate = treatmnetDate;
		this.signsSymptons = signsSymptons;
		this.tongue = tongue;
		this.pulse = pulse;
	}

	/** full constructor */
	public Treatment(Timestamp treatmnetDate, String signsSymptons,
			String tongue, String pulse, String results, float cost,
			String paid, float amountPaid,
			Collection<TreatmentDrug> treatmentDrug, Patient patient) {
		this.treatmnetDate = treatmnetDate;
		this.signsSymptons = signsSymptons;
		this.tongue = tongue;
		this.pulse = pulse;
		this.results = results;
		this.paid = paid;
		this.amountPaid = amountPaid;
		this.treatmentDrug = treatmentDrug;
		this.patient = patient;
	}

	// Property accessors
	public long getTreatmentId() {
		return this.treatmentId;
	}

	public void setTreatmentId(long treatmentId) {
		this.treatmentId = treatmentId;
	}

	public Timestamp getTreatmnetDate() {
		return this.treatmnetDate;
	}

	public void setTreatmnetDate(Timestamp treatmnetDate) {
		this.treatmnetDate = treatmnetDate;
	}

	public String getSignsSymptons() {
		return this.signsSymptons;
	}

	public void setSignsSymptons(String signsSymptons) {
		this.signsSymptons = signsSymptons;
	}

	public String getTongue() {
		return this.tongue;
	}

	public void setTongue(String tongue) {
		this.tongue = tongue;
	}

	public String getPulse() {
		return this.pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
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

	public Collection<TreatmentDrug> getTreatmentDrug() {
		return this.treatmentDrug;
	}

	public void setTreatmentDrug(Collection<TreatmentDrug> treatmentDrug) {
		this.treatmentDrug = treatmentDrug;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void copyToTreatmentObject(Treatment tr) {
		this.setTreatmentId(tr.getTreatmentId());
		this.setTreatmnetDate(tr.getTreatmnetDate());
		this.setSignsSymptons(tr.getSignsSymptons());
		this.setTongue(tr.getTongue());
		this.setPulse(tr.getPulse());
		this.setResults(tr.getResults());
		this.setPaid(tr.getPaid());
		this.setAmountPaid(tr.getAmountPaid());
		this.setPaymentType(tr.getPaymentType());
		this.setPatient(tr.getPatient());
		this.setBalance(tr.getBalance());
		
		List originaltreatDrugList = (List)this.getTreatmentDrug();
		List treatmentDrugList =  (List)tr.getTreatmentDrug();
		for (int i = 0; i < treatmentDrugList.size(); i++) {
			TreatmentDrug trd = (TreatmentDrug)treatmentDrugList.get(i);
			trd.setTreatment(this);
			if(trd.getTreatmentDrugId() == 0){
				originaltreatDrugList.add(trd);
				continue;
			}
			for (int j = 0; j < originaltreatDrugList.size(); j++) {
				TreatmentDrug trdTemp = (TreatmentDrug)originaltreatDrugList.get(j);
				if(trdTemp.getTreatmentDrugId() == trd.getTreatmentDrugId()){
					trdTemp.copyToTreatmentDrugObject(trd);
				}
			}
			
		}
		
		
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
