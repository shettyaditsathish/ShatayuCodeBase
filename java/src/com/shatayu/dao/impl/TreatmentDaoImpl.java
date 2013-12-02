package com.shatayu.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.TreatmentDao;
import com.shatayu.model.Patient;
import com.shatayu.model.Treatment;

public class TreatmentDaoImpl extends HibernateDaoSupport implements TreatmentDao{
	public List<Treatment> addTreatments(List<Treatment> treatmentList){
		getHibernateTemplate().saveOrUpdateAll(treatmentList);
		return treatmentList;
	}
	
	public List<Treatment> updateTreatments(List<Treatment> treatmentList){
		getHibernateTemplate().saveOrUpdateAll(treatmentList);
		return treatmentList;
	}
	
	public List<Treatment> deleteTreatments(List<Treatment> treatmentList){
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < treatmentList.size(); i++) {
			Treatment t = (Treatment)treatmentList.get(i);
			List trList = session.createQuery("select t from Treatment t where t.treatmentId = "+t.getTreatmentId()).list();
			Treatment dbTr = null;
			for (int j = 0; j < trList.size(); j++) {
				if((Treatment)trList.get(j) != null){
					dbTr = (Treatment)trList.get(j);
					break;
				}
			}
			dbTr.copyToTreatmentObject(t);
			session.delete(dbTr);
		}
		
		session.flush();
		tx.commit();
		//getHibernateTemplate().deleteAll(treatmentList);
		return treatmentList;
	}
	
	public List<Treatment> getTreatmentsById(long treatmentId){
		DetachedCriteria nd=DetachedCriteria.forClass(Treatment.class);   
        nd.add(Expression.eq("treatmentId", treatmentId));   
        return (List)getHibernateTemplate().findByCriteria(nd);
      //return getHibernateTemplate().find("from Treatment t where t.treatmentId = "+treatmentId);
	}
	
	public List<Treatment> getTreatmentsByPatientId(long patientId){
		DetachedCriteria nd=DetachedCriteria.forClass(Treatment.class);   
        nd.add(Expression.eq("patientId", patientId));   
        return (List)getHibernateTemplate().findByCriteria(nd);
		//return getHibernateTemplate().find("from Treatment t where t.patientId = "+patientId);
	}
	
	public List<Treatment> getTreatmentsByDate(Date startDate, Date endDate){
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select t from Treatment t where t.treatmnetDate >= :startDate and t.treatmnetDate <= :endDate");;
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		return q.list();
	}
}
