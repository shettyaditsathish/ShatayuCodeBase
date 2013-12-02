package com.shatayu.model;

// Generated 11 Jun, 2012 11:43:30 PM by Hibernate Tools 3.2.0.beta8

/**
 *             This class contains the panchkarma cost details.
 *         
 */
public class PanchkarmaCost implements java.io.Serializable {

	// Fields    

	private long panchkarmaCostId;
	private long panchkarmaId;
	private String attrName;
	private float attrValue;

	// Constructors

	/** default constructor */
	public PanchkarmaCost() {
	}

	/** minimal constructor */
	public PanchkarmaCost(String attrName) {
		this.attrName = attrName;
	}

	/** full constructor */
	public PanchkarmaCost(long panchkarmaId, String attrName, float attrValue) {
		this.panchkarmaId = panchkarmaId;
		this.attrName = attrName;
		this.attrValue = attrValue;
	}

	// Property accessors
	public long getPanchkarmaCostId() {
		return this.panchkarmaCostId;
	}

	public void setPanchkarmaCostId(long panchkarmaCostId) {
		this.panchkarmaCostId = panchkarmaCostId;
	}

	public long getPanchkarmaId() {
		return this.panchkarmaId;
	}

	public void setPanchkarmaId(long panchkarmaId) {
		this.panchkarmaId = panchkarmaId;
	}

	public String getAttrName() {
		return this.attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public float getAttrValue() {
		return this.attrValue;
	}

	public void setAttrValue(float attrValue) {
		this.attrValue = attrValue;
	}
	
	public void copyPanchCostToObject(PanchkarmaCost pcost) {
		this.setPanchkarmaCostId(pcost.getPanchkarmaCostId());
		this.setPanchkarmaId(pcost.getPanchkarmaId());
		this.setAttrName(pcost.getAttrName());
		this.setAttrValue(pcost.getAttrValue());
	}

}
