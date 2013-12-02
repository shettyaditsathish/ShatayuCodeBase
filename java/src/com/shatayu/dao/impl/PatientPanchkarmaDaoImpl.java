package com.shatayu.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.PatientPanchkarmaDao;
import com.shatayu.model.Panchkarma;
import com.shatayu.model.PatientPanchkarma;
import com.shatayu.model.Treatment;

public class PatientPanchkarmaDaoImpl extends HibernateDaoSupport implements PatientPanchkarmaDao{

	@Override
	public List<PatientPanchkarma> getPanchkarmaTreatmentByDate(Date startDate,
			Date endDate) {
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select pp from PatientPanchkarma pp where pp.startDate >= :startDate and pp.startDate <= :endDate");;
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		return q.list();
	}
	
	public List<PatientPanchkarma> getPanchkarmaTreatmentByDetails(long patientId,long panchkarmaId,Date startDate,
			Date endDate) {
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select pp from PatientPanchkarma pp where pp.panchkarmaId = :panchkarmaId and pp.patient.patientId = :patientId and pp.startDate = :startDate and pp.endDate = :endDate");;
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		q.setParameter("patientId", patientId);
		q.setParameter("panchkarmaId", panchkarmaId);
		return q.list();
	}
	
	public List<PatientPanchkarma> deletePanchkarmaTreatments(List panchTreatList){
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < panchTreatList.size(); i++) {
			PatientPanchkarma ppt = (PatientPanchkarma)panchTreatList.get(i);
			List pptList = session.createQuery("select t from PatientPanchkarma t where t.patientPanchId = "+ppt.getPatientPanchId()).list();
			PatientPanchkarma dbPpt = null;
			for (int j = 0; j < pptList.size(); j++) {
				if((PatientPanchkarma)pptList.get(j) != null){
					dbPpt = (PatientPanchkarma)pptList.get(j);
					break;
				}
			}
			dbPpt.copyToPatientPanchkarmaObject(ppt);
			session.delete(dbPpt);
		}
		
		session.flush();
		tx.commit();
		//getHibernateTemplate().deleteAll(panchkarmaList);
		return panchTreatList;
	}

}
