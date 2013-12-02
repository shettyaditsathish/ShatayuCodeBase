package com.shatayu.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.shatayu.dao.AppointmentDao;
import com.shatayu.model.Appointment;
import com.shatayu.model.Organiser;

public class AppointmentDaoImpl extends HibernateDaoSupport implements AppointmentDao {
	
	@Override
	public List<Appointment> deleteAppointmentDetails(
			List<Appointment> appointment) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < appointment.size(); i++) {
			session.delete((Appointment)appointment.get(i));
		}
		
		session.flush();
		tx.commit();
		//getHibernateTemplate().deleteAll(drugList);
		return appointment;
	}

	@Override
	public List<Appointment> getAppointmentsDetailsByDate(Date startDate,
			Date endDate) {
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select t from Appointment t where t.apptStartDate >= :apptStrtDate and t.apptEndDate <= :apptEdDate");;
		q.setParameter("apptStrtDate", startDate);	
		q.setParameter("apptEdDate", endDate);
		return q.list();
	}

	@Override
	public List<Appointment> getAppointmentsDetailsByDateAndPatientId(
			Date startDate, Date endDate, long patientId) {
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select t from Appointment t where t.apptStartDate >= :apptStrtDate and t.apptEndDate <= :apptEdDate and t.patientId = :patientId");;
		q.setParameter("apptStrtDate", startDate);	
		q.setParameter("apptEdDate", endDate);
		q.setParameter("patientId", patientId);
		return q.list();
	}

	@Override
	public List<Appointment> saveAppointmentDetails(
			List<Appointment> appointment) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		for(int i=0;i<appointment.size();i++){
			if(appointment.get(i) == null)continue;
			Appointment appt = (Appointment)appointment.get(i);
			
		
			
			if(appt.getAppointmentId() != 0){
				List apptList = session.createQuery("select appt from Appointment appt where appt.appointmentId = "+appt.getAppointmentId()).list();
				
				Appointment dbAppt = null;
				for (int j = 0; j < apptList.size(); j++) {
					if((Appointment)apptList.get(j) != null){
						dbAppt = (Appointment)apptList.get(j);
						break;
					}
				}
				dbAppt.copyToAppointmentObject(appt);
				session.saveOrUpdate(dbAppt);
			}else{
				session.saveOrUpdate(appt);
			}
			
		}
		session.flush();
		tx.commit();
		return appointment;
	}

	@Override
	public List<Appointment> getAppointmentsDetailsByAppointmentId(String apptId) {
		Query q = getHibernateTemplate().getSessionFactory().openSession().createQuery("select t from Appointment t where t.organiser.organiserId = :organiserId");;
		q.setParameter("organiserId", apptId);
		return q.list();
	
	}

}
