package com.shatayu.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.OrganiserDao;
import com.shatayu.model.Organiser;
import com.shatayu.model.Patient;

public class OrganiserDaoImpl extends HibernateDaoSupport implements OrganiserDao {

	@Override
	public List<Organiser> deleteAppointment(List<Organiser> appointment) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < appointment.size(); i++) {
			session.delete((Organiser)appointment.get(i));
		}
		
		session.flush();
		tx.commit();
		//getHibernateTemplate().deleteAll(drugList);
		return appointment;
	}

	@Override
	public List<Organiser> getAppointmentsByDate(Date startDate, Date endDate) {
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select t from Organiser t where t.startDate >= :startDate and t.endDate <= :endDate");;
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		return q.list();
		
	}

	@Override
	public List<Organiser> getAppointmentsByDateAndPatientId(Date startDate,
			Date endDate, long patientId) {
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select t from Organiser t where t.startDate >= :startDate and t.endDate <= :endDate and t.patient.patientId = :patientId");;
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		q.setParameter("patientId", patientId);
		return q.list();
	}

	@Override
	public List<Organiser> saveAppointment(List<Organiser> appointment) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		for(int i=0;i<appointment.size();i++){
			if(appointment.get(i) == null)continue;
			Organiser org = (Organiser)appointment.get(i);
			
		
			
			if(org.getOrganiserId() != 0){
				List orgList = session.createQuery("select org from Organiser org where org.organiserId = "+org.getOrganiserId()).list();
				
				Organiser dbOrg = null;
				for (int j = 0; j < orgList.size(); j++) {
					if((Organiser)orgList.get(j) != null){
						dbOrg = (Organiser)orgList.get(j);
						break;
					}
				}
				dbOrg.copyToOrganiserObject(org);
				session.saveOrUpdate(dbOrg);
			}else{
				session.saveOrUpdate(org);
			}
			
		}
		session.flush();
		tx.commit();
		return appointment;
	}

	@Override
	public List<Organiser> getAppointmentsByPatientId(long patientId) {
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select t from Organiser t where t.patient.patientId = :patientId");;
		q.setParameter("patientId", patientId);
		return q.list();
	}

}
