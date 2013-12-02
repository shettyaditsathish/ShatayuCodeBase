package com.shatayu.model;

// Generated 2 Jan, 2010 11:28:58 AM by Hibernate Tools 3.2.0.beta8

/**
 *             This class contains the drug details.
 *         
 */
public class Drug implements java.io.Serializable {

	// Fields    

	private long drugId;
	private String drugName;
	private float drugCost;
	private String drugContent;
	private long quantity;
	private String details;

	// Constructors

	/** default constructor */
	public Drug() {
	}

	/** minimal constructor */
	public Drug(String drugName) {
		this.drugName = drugName;
	}

	/** full constructor */
	public Drug(String drugName, float drugCost, String drugContent,
			long quantity, String details) {
		this.drugName = drugName;
		this.drugCost = drugCost;
		this.drugContent = drugContent;
		this.quantity = quantity;
		this.details = details;
	}

	// Property accessors
	public long getDrugId() {
		return this.drugId;
	}

	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public float getDrugCost() {
		return this.drugCost;
	}

	public void setDrugCost(float drugCost) {
		this.drugCost = drugCost;
	}

	public String getDrugContent() {
		return this.drugContent;
	}

	public void setDrugContent(String drugContent) {
		this.drugContent = drugContent;
	}

	public long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
