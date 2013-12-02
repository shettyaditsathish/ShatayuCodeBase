package com.shatayu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.TreatmentPhotoDao;
import com.shatayu.model.Treatment;
import com.shatayu.model.TreatmentPhotos;

public class TreatmentPhotoDaoImpl extends HibernateDaoSupport implements TreatmentPhotoDao{

	
	public List<TreatmentPhotos> deleteTreatments(List<TreatmentPhotos> treatmentPicList) {
		getHibernateTemplate().deleteAll(treatmentPicList);
		return treatmentPicList;
	}

	
	public List<TreatmentPhotos> getTreatmentsPicsByTreatment(long treatmentId) {
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select t from TreatmentPhotos t where t.treatment.treatmentId = :treatmentId");;
		q.setParameter("treatmentId", treatmentId);
		return q.list();
	}

	
	public List<TreatmentPhotos> saveTreatmentPic(List<TreatmentPhotos> treatmentPicList) {
		getHibernateTemplate().saveOrUpdateAll(treatmentPicList);
		return treatmentPicList;
	}

	
	

}
