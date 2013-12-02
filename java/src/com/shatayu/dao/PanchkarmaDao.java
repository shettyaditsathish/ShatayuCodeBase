package com.shatayu.dao;

import java.util.List;

import com.shatayu.model.Panchkarma;

public interface PanchkarmaDao {
	public List<Panchkarma> addPanchkarma(List<Panchkarma> panchkarmaList);
	public List<Panchkarma> deletePanchkarma(List<Panchkarma> panchkarmaList);
	public List<Panchkarma> getPanchkarma();
	public Panchkarma getPanchkarmaById(long panchkarmaId);
}
