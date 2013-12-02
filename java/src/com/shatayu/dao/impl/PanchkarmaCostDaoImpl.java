package com.shatayu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.PanchkarmaCostDao;
import com.shatayu.model.PanchkarmaCost;

public class PanchkarmaCostDaoImpl extends HibernateDaoSupport implements PanchkarmaCostDao{

	@Override
	public List<PanchkarmaCost> deletePanchkarmaCost(
			List<PanchkarmaCost> panchkarmaCostList) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < panchkarmaCostList.size(); i++) {
			session.delete((PanchkarmaCost)panchkarmaCostList.get(i));
		}
		
		session.flush();
		tx.commit();
		//getHibernateTemplate().deleteAll(panchkarmaList);
		return panchkarmaCostList;
	}
	
}
