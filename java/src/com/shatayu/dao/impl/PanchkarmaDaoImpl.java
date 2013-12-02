package com.shatayu.dao.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.PanchkarmaDao;
import com.shatayu.model.Panchkarma;

public class PanchkarmaDaoImpl extends HibernateDaoSupport implements PanchkarmaDao{
	public List<Panchkarma> addPanchkarma(List<Panchkarma> panchkarmaList){
		String logs="CAme in add Panchkarma";
		
		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		for(int i=0;i<panchkarmaList.size();i++){
			if(panchkarmaList.get(i) == null)continue;
			Panchkarma pt = (Panchkarma)panchkarmaList.get(i);
			
			logs = logs + "Panchkarma Id  "+pt.getPanchkarmaId();
			
			if(pt.getPanchkarmaId() != 0){
				logs = logs + "Came in merge Original  ";
				List panchList = session.createQuery("select p from Panchkarma p where p.panchkarmaId = "+pt.getPanchkarmaId()).list();
				
				Panchkarma dbPanchkarma = null;
				
				for (int j = 0; j < panchList.size(); j++) {
					if((Panchkarma)panchList.get(j) != null){
						dbPanchkarma = (Panchkarma)panchList.get(j);
						break;
					}
				}
				
				
				dbPanchkarma.copyToPanchkarmaObject(pt);
				try{
					logs = logs + "dbPanchkarma  "+dbPanchkarma.getPanchkarmaId();
					File fl = new File("D:\\SaveCostErr.text");
					
					FileOutputStream fo = new FileOutputStream(fl);
					fo.write(logs.getBytes());
					fo.close();
				}catch(Exception e){
					
				}
				session.saveOrUpdate(dbPanchkarma);
			}else{
				logs = logs + "Came in merge   ";
				session.saveOrUpdate(pt);
			}
			
		}
		session.flush();
		tx.commit();
		
		return panchkarmaList;
	}
	public List<Panchkarma> deletePanchkarma(List<Panchkarma> panchkarmaList){
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < panchkarmaList.size(); i++) {
			session.delete((Panchkarma)panchkarmaList.get(i));
		}
		
		session.flush();
		tx.commit();
		//getHibernateTemplate().deleteAll(panchkarmaList);
		return panchkarmaList;
	}
	public List<Panchkarma> getPanchkarma(){
		/*DetachedCriteria nd=DetachedCriteria.forClass(Panchkarma.class);   
		return (List)getHibernateTemplate().findByCriteria(nd);*/
		return  getHibernateTemplate().getSessionFactory().openSession().createQuery("select p from Panchkarma p").list();
	}
	
	public Panchkarma getPanchkarmaById(long panchkarmaId){
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select p from Panchkarma p where p.panchkarmaId = :panchId");;
		q.setParameter("panchId", panchkarmaId);
		List<Panchkarma> panchList= q.list();
		
		if(panchList != null && panchList.size() ==1){
			return panchList.get(0);
		}
		return null;
	}
}
