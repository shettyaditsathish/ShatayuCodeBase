package com.shatayu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.DrugDao;
import com.shatayu.model.Drug;
import com.shatayu.model.Treatment;

public class DrugDaoImpl extends HibernateDaoSupport implements DrugDao {
	public List<Drug> addDrugs(List<Drug> drugList){
		getHibernateTemplate().saveOrUpdateAll(drugList);
		return drugList;
	}
	public List<Drug> updateDrugs(List<Drug> drugList){
		getHibernateTemplate().saveOrUpdateAll(drugList);
		return drugList;
	}
	public List<Drug> deleteDrugs(List<Drug> drugList){
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < drugList.size(); i++) {
			session.delete((Drug)drugList.get(i));
		}
		
		session.flush();
		tx.commit();
		//getHibernateTemplate().deleteAll(drugList);
		return drugList;
	}
	public List<Drug> getDrugsById(long drugId){
		DetachedCriteria nd=DetachedCriteria.forClass(Drug.class);   
        nd.add(Expression.eq("drugId", drugId));   
        return (List)getHibernateTemplate().findByCriteria(nd); 
		//return getHibernateTemplate().find("from Drug d where d.drugId="+drugId);
	}
	public List<Drug> getDrugs(){
		DetachedCriteria nd=DetachedCriteria.forClass(Drug.class);   
		return (List)getHibernateTemplate().findByCriteria(nd); 
	}
}
