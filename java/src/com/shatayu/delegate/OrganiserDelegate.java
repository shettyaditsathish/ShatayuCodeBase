package com.shatayu.delegate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shatayu.dao.AppointmentDao;
import com.shatayu.dao.OrganiserDao;
import com.shatayu.dao.PatientPanchkarmaDao;
import com.shatayu.email.EmailFactory;
import com.shatayu.email.EmailProvider;
import com.shatayu.model.Appointment;
import com.shatayu.model.Mail;
import com.shatayu.model.Organiser;
import com.shatayu.model.Patient;
import com.shatayu.model.PatientPanchkarma;
import com.shatayu.util.Logger;

import flex.messaging.FlexContext;

public class OrganiserDelegate {
	
	private ServletContext getServletContext(){
		HttpServletRequest req = FlexContext.getHttpRequest();
		return req.getSession().getServletContext();
		
	}
	
	public List saveAppointment(List appointment) throws Exception{
		try{
			OrganiserDao edao = (OrganiserDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("OrganiserDao");
			return edao.saveAppointment(appointment);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List deleteAppointment(List appointment) throws Exception{
		try{
			
			for (Object obj : appointment) {
				Organiser org = (Organiser)obj;
				
				if(org.getStatus() != null && org.getStatus().equals("C")){
					
					PatientPanchkarmaDao ppedao = (PatientPanchkarmaDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("PatientPanchkarmaDao");
					
					List<PatientPanchkarma> ppList = ppedao.getPanchkarmaTreatmentByDetails(org.getPatient().getPatientId(), org.getPanchkarmaId(), org.getStartDate(), org.getEndDate());
					
					if(ppList != null && ppList.size() > 0){
						//throw new Exception("Please delete the main appointment before deleting the organiser appointment");
						PatientPanchkarmaDao ppdao = (PatientPanchkarmaDao) WebApplicationContextUtils
						.getRequiredWebApplicationContext(getServletContext()).getBean("PatientPanchkarmaDao");
						ppdao.deletePanchkarmaTreatments(ppList);
					}
					
					
					
				}
			}
			
			OrganiserDao edao = (OrganiserDao) WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext()).getBean("OrganiserDao");
			
			return edao.deleteAppointment(appointment);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getAppointmentsByDate(Date startDate, Date endDate) throws Exception{
		try{
			OrganiserDao edao = (OrganiserDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("OrganiserDao");
			List orgainserList = edao.getAppointmentsByDate(startDate, endDate);
				for(int i=0;i< orgainserList.size();i++){
					Organiser org = (Organiser)orgainserList.get(i);
					org.setPatient(org.getPatient().clone());
				}
			return orgainserList;
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getAppointmentsByDateAndPatientId(Date startDate,
			Date endDate, Patient patient) throws Exception{
		try{
			OrganiserDao edao = (OrganiserDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("OrganiserDao");
			List orgainserList = null;
			if(startDate == null && endDate == null){
				orgainserList = edao.getAppointmentsByPatientId(patient.getPatientId());
			}else
				orgainserList = edao.getAppointmentsByDateAndPatientId(startDate, endDate, patient.getPatientId());
			for(int i=0;i< orgainserList.size();i++){
				Organiser org = (Organiser)orgainserList.get(i);
				org.setPatient(org.getPatient().clone());
			}
			return orgainserList;
		}catch (Throwable e) {
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public List saveAppointmentDetails(List appointment) throws Exception{
		try{
			AppointmentDao edao = (AppointmentDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("AppointmentDao");
			return edao.saveAppointmentDetails(appointment);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List deleteAppointmentDetails(List appointment) throws Exception{
		try{
			AppointmentDao edao = (AppointmentDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("AppointmentDao");
			return edao.deleteAppointmentDetails(appointment);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getAppointmentsDetailsByAppointmentId(String appointmentId) throws Exception{
		try{
			AppointmentDao edao = (AppointmentDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("AppointmentDao");
			List apptList = edao.getAppointmentsDetailsByAppointmentId(appointmentId);
			for(int i=0;i<apptList.size();i++){
				Appointment appt = (Appointment)apptList.get(i);
				appt.setOrganiser(appt.getOrganiser().clone());
			}
			
			return apptList;
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getAppointmentsDetailsByDate(Date startDate, Date endDate) throws Exception{
		try{
			AppointmentDao edao = (AppointmentDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("AppointmentDao");
			
			List apptList = edao.getAppointmentsDetailsByDate(startDate, endDate);
			for(int i=0;i<apptList.size();i++){
				Appointment appt = (Appointment)apptList.get(i);
				appt.setOrganiser(appt.getOrganiser().clone());
			}
			
			return apptList;
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getAppointmentsDetailsByDateAndPatientId(Date startDate,
			Date endDate, long patientId) throws Exception{
		try{
			
			AppointmentDao edao = (AppointmentDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("AppointmentDao");
			
			List apptList = edao.getAppointmentsDetailsByDateAndPatientId(startDate, endDate, patientId);
			for(int i=0;i<apptList.size();i++){
				Appointment appt = (Appointment)apptList.get(i);
				appt.setOrganiser(appt.getOrganiser().clone());
			}
			
			return apptList;
		}catch (Throwable e) {
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public String sendEmail(String emailProvider,List<String> toAddressP,String subject,String message){
		EmailProvider emp = EmailFactory.getInstance().getEmailProvider(emailProvider);
		return emp.sendMail(toAddressP, subject, message);
	}
	
	public List<Mail> recieveEmail(String emailProvider){
		EmailProvider emp = EmailFactory.getInstance().getEmailProvider(emailProvider);
		return emp.recieveMail();
	}
	
	public static void main(String[] args){
		OrganiserDelegate og = new OrganiserDelegate();
		ArrayList<String> ls = new ArrayList<String>();
		ls.add("shettyaditsathish@gmail.com");
		og.sendEmail("shatayu", ls, "Check", "Message sending");
	}
	
	//
}
