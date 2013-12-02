package com.shatayu.model;

// Generated 29 May, 2011 1:15:07 PM by Hibernate Tools 3.2.0.beta8

/**
 *             This class contains the treatment Pics.
 *         
 */
public class TreatmentPhotos implements java.io.Serializable {

	// Fields    

	private long treatmentPhotosId;
	private String description;
	private byte[] imageData;
	private Treatment treatment;

	// Constructors

	/** default constructor */
	public TreatmentPhotos() {
	}

	/** minimal constructor */
	public TreatmentPhotos(byte[] imageData) {
		this.imageData = imageData;
	}

	/** full constructor */
	public TreatmentPhotos(String description, byte[] imageData,
			Treatment treatment) {
		this.description = description;
		this.imageData = imageData;
		this.treatment = treatment;
	}

	// Property accessors
	public long getTreatmentPhotosId() {
		return this.treatmentPhotosId;
	}

	public void setTreatmentPhotosId(long treatmentPhotosId) {
		this.treatmentPhotosId = treatmentPhotosId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImageData() {
		return this.imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public Treatment getTreatment() {
		return this.treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

}
