package com.shatayu.dao;

import java.util.List;

import com.shatayu.model.TreatmentPhotos;

public interface TreatmentPhotoDao {
	public List<TreatmentPhotos> saveTreatmentPic(List<TreatmentPhotos> treatmentPicList);
	public List<TreatmentPhotos> deleteTreatments(List<TreatmentPhotos> treatmentPicList);
	public List<TreatmentPhotos> getTreatmentsPicsByTreatment(long treatmentId);
}
