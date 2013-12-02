package com.shatayu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.PatientDao;
import com.shatayu.model.Patient;

public class PatientDaoImpl extends HibernateDaoSupport implements PatientDao{
	
	public List<Patient> addPatients(List<Patient> p){
		String logs="CAme in add Patients";
		
		
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		for(int i=0;i<p.size();i++){
			if(p.get(i) == null)continue;
			Patient pt = (Patient)p.get(i);
			
			Patient pcache = (Patient)session.load(Patient.class, pt.getPatientId());
			logs = logs + "Patient   "+(pcache != null) ;	
			logs = logs + "Patient Id  "+pt.getPatientId();
			
			if(pt.getPatientId() != 0){
				logs = logs + "Came in merge Original  ";
				List patList = session.createQuery("select p from Patient p where p.patientId = "+pt.getPatientId()).list();
				
				Patient dbPt = null;
				for (int j = 0; j < patList.size(); j++) {
					if((Patient)patList.get(j) != null){
						dbPt = (Patient)patList.get(j);
						break;
					}
				}
				dbPt.copyToPatientObject(pt);
				session.saveOrUpdate(dbPt);
			}else{
				logs = logs + "Came in merge   ";
				session.saveOrUpdate(pt);
			}
			
		}
		session.flush();
		tx.commit();
		//getHibernateTemplate().saveOrUpdateAll(p);
		return p;
	}
	
	
	
	public List<Patient> deletePatients(List<Patient> p){
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < p.size(); i++) {
			Patient pt = (Patient)p.get(i);
			List patList = session.createQuery("select p from Patient p where p.patientId = "+pt.getPatientId()).list();
			Patient dbPt = null;
			for (int j = 0; j < patList.size(); j++) {
				if((Patient)patList.get(j) != null){
					dbPt = (Patient)patList.get(j);
					break;
				}
			}
			dbPt.copyToPatientObject(pt);
			session.delete(dbPt);
		}
		
		session.flush();
		tx.commit();
		return p;
	}
	
	public List<Patient> updatePatients(List<Patient> p){
		getHibernateTemplate().saveOrUpdateAll(p);
		return p;
	}
	
	public List<Patient> searchPatientByName(String name, String cond){
		DetachedCriteria nd=DetachedCriteria.forClass(Patient.class);
		if(cond.equals("firstName")){
			//nd.add(Expression.like("firstName", "%"+name+"%")); 
			return  getHibernateTemplate().getSessionFactory().openSession().createQuery("select p from Patient p where p.firstName like '%"+name+"%'").list();
		}else{
			//nd.add(Expression.like("lastName", "%"+name+"%")); 
			return  getHibernateTemplate().getSessionFactory().openSession().createQuery("select p from Patient p where p.lastName like '%"+name+"%'").list();
		}
          
        //return (List)getHibernateTemplate().findByCriteria(nd);   
	}
	
	
	
	public List<Patient> listAllPatients(){
		//DetachedCriteria nd=DetachedCriteria.forClass(Patient.class);   
        //return (List)getHibernateTemplate().findByCriteria(nd);
		return  getHibernateTemplate().getSessionFactory().openSession().createQuery("select p from Patient p").list();
		
		
		
	}
	public List<Patient> listPatientById(long patientId){
		 DetachedCriteria nd=DetachedCriteria.forClass(Patient.class);   
         nd.add(Expression.eq("patientId", patientId));   
         return (List)getHibernateTemplate().findByCriteria(nd);   
		//return getHibernateTemplate().find("from Patient p where patientId="+patientId);
	}



	@Override
	public List<Patient> searchPatientByPhoneNumber(String phNumber) {
		DetachedCriteria nd=DetachedCriteria.forClass(Patient.class);
		return  getHibernateTemplate().getSessionFactory().openSession().createQuery("select p from Patient p where p.mobile1 like '%"+phNumber+"%' OR p.mobile2 like '%"+phNumber+"%' OR p.landline like '%"+phNumber+"%'" ).list();
		
	}
}
