package com.shatayu.model;

// Generated 10 Jan, 2010 10:15:27 PM by Hibernate Tools 3.2.0.beta8

/**
 *             This class contains the patient treatment details.
 *         
 */
public class TreatmentDrug implements java.io.Serializable {

	// Fields    

	private long treatmentDrugId;
	private long drugId;
	private String duration;
	private long noOfDays;
	private Treatment treatment;

	// Constructors

	/** default constructor */
	public TreatmentDrug() {
	}

	/** minimal constructor */
	public TreatmentDrug(String duration) {
		this.duration = duration;
	}

	/** full constructor */
	public TreatmentDrug(long drugId, String duration, long noOfDays,
			Treatment treatment) {
		this.drugId = drugId;
		this.duration = duration;
		this.noOfDays = noOfDays;
		this.treatment = treatment;
	}

	// Property accessors
	public long getTreatmentDrugId() {
		return this.treatmentDrugId;
	}

	public void setTreatmentDrugId(long treatmentDrugId) {
		this.treatmentDrugId = treatmentDrugId;
	}

	public long getDrugId() {
		return this.drugId;
	}

	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public long getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(long noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Treatment getTreatment() {
		return this.treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	
	public void copyToTreatmentDrugObject(TreatmentDrug trd) {
		this.setTreatmentDrugId(trd.getTreatmentDrugId());
		this.setDrugId(trd.getDrugId());
		this.setDuration(trd.getDuration());
		this.setNoOfDays(trd.getNoOfDays());
	}

}
