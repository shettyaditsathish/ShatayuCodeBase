package com.shatayu.dao;

import java.util.List;

import com.shatayu.model.Drug;
import com.shatayu.model.Treatment;

public interface DrugDao {
	public List<Drug> addDrugs(List<Drug> drugList);
	public List<Drug> updateDrugs(List<Drug> drugList);
	public List<Drug> deleteDrugs(List<Drug> drugList);
	public List<Drug> getDrugsById(long drugId);
	public List<Drug> getDrugs();
}
