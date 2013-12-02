package com.shatayu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.TreatmentDrugDao;
import com.shatayu.model.TreatmentDrug;

public class TreatmentDrugDaoImpl  extends HibernateDaoSupport implements TreatmentDrugDao{

	@Override
	public List<TreatmentDrug> deleteTreatmentDrug(List<TreatmentDrug> treatmentDrugList) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < treatmentDrugList.size(); i++) {
			TreatmentDrug t = (TreatmentDrug)treatmentDrugList.get(i);
			int  row = session.createQuery("delete from TreatmentDrug t where t.treatmentDrugId = "+t.getTreatmentDrugId()).executeUpdate();
			if(row == 0){
				throw new RuntimeException("Not Deleted");
			}
		}
		
		session.flush();
		tx.commit();
		//getHibernateTemplate().deleteAll(treatmentList);
		return treatmentDrugList;
	}

}
