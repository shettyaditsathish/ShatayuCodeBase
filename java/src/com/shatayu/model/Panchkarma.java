package com.shatayu.model;

// Generated 11 Jun, 2012 11:43:30 PM by Hibernate Tools 3.2.0.beta8

import java.util.Collection;
import java.util.List;

/**
 *             This class contains the patient panchkarma treatment details.
 *         
 */
public class Panchkarma implements java.io.Serializable {

	// Fields    

	private long panchkarmaId;
	private String panchkarmaName;
	private float cost;
	private String procedure;
	private String diseases;
	private String details;
	private long noOfDays;
	private Collection<PanchkarmaCost> panchkarmaCost;

	// Constructors

	/** default constructor */
	public Panchkarma() {
	}

	/** minimal constructor */
	public Panchkarma(String panchkarmaName) {
		this.panchkarmaName = panchkarmaName;
	}

	/** full constructor */
	public Panchkarma(String panchkarmaName, float cost, String procedure,
			String diseases, String details, long noOfDays,
			Collection<PanchkarmaCost> panchkarmaCost) {
		this.panchkarmaName = panchkarmaName;
		this.cost = cost;
		this.procedure = procedure;
		this.diseases = diseases;
		this.details = details;
		this.noOfDays = noOfDays;
		this.panchkarmaCost = panchkarmaCost;
	}

	// Property accessors
	public long getPanchkarmaId() {
		return this.panchkarmaId;
	}

	public void setPanchkarmaId(long panchkarmaId) {
		this.panchkarmaId = panchkarmaId;
	}

	public String getPanchkarmaName() {
		return this.panchkarmaName;
	}

	public void setPanchkarmaName(String panchkarmaName) {
		this.panchkarmaName = panchkarmaName;
	}

	public float getCost() {
		return this.cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getProcedure() {
		return this.procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getDiseases() {
		return this.diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public long getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(long noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Collection<PanchkarmaCost> getPanchkarmaCost() {
		return this.panchkarmaCost;
	}

	public void setPanchkarmaCost(Collection<PanchkarmaCost> panchkarmaCost) {
		this.panchkarmaCost = panchkarmaCost;
	}
	
	public void copyToPanchkarmaObject(Panchkarma panch){
		this.setPanchkarmaId(panch.getPanchkarmaId());
		this.setPanchkarmaName(panch.getPanchkarmaName());
		List originaltreatPanchCostList = (List)this.getPanchkarmaCost();
		List panchCostList =  (List)panch.getPanchkarmaCost();
		for (int i = 0; i < panchCostList.size(); i++) {
			PanchkarmaCost pcost = (PanchkarmaCost)panchCostList.get(i);
			if(pcost.getPanchkarmaCostId() == 0){
				originaltreatPanchCostList.add(pcost);
				continue;
			}
			for (int j = 0; j < originaltreatPanchCostList.size(); j++) {
				PanchkarmaCost pCostTemp = (PanchkarmaCost)originaltreatPanchCostList.get(j);
				if(pCostTemp.getPanchkarmaCostId() == pcost.getPanchkarmaCostId()){
					pCostTemp.copyPanchCostToObject(pcost);
				}
			}
			
		}
		
		this.setCost(panch.getCost());
		this.setProcedure(panch.getProcedure());
		this.setDiseases(panch.getDiseases());
		this.setDetails(panch.getDetails());
		this.setNoOfDays(panch.getNoOfDays())
;	}

}
