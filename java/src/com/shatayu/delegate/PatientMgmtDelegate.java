/*
 * Created on 26 Jul, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.shatayu.delegate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shatayu.dao.DrugDao;
import com.shatayu.dao.OrganiserDao;
import com.shatayu.dao.PanchkarmaCostDao;
import com.shatayu.dao.PanchkarmaDao;
import com.shatayu.dao.PatientDao;
import com.shatayu.dao.PatientPanchkarmaDao;
import com.shatayu.dao.TreatmentDao;
import com.shatayu.dao.TreatmentDrugDao;
import com.shatayu.dao.TreatmentPhotoDao;
import com.shatayu.dao.impl.OrganiserDaoImpl;
import com.shatayu.model.Panchkarma;
import com.shatayu.model.PanchkarmaCost;
import com.shatayu.model.Patient;
import com.shatayu.model.PatientPanchkarma;
import com.shatayu.model.Treatment;
import com.shatayu.model.TreatmentPhotos;
import com.shatayu.util.Logger;

import flex.messaging.FlexContext;

/**
 * @author Shetty
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class PatientMgmtDelegate {

	public String addUser(String employeeId, String employeeName) {
		System.out.println("CAme in addUser");
		HttpServletRequest req = FlexContext.getHttpRequest();
		if (req == null)
			return "req object is null";
		ServletContext sc = req.getSession().getServletContext();
		if (sc == null)
			return "sc object is null";
		EmployeeHIbernateDAO edao = (EmployeeHIbernateDAO) WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc).getBean(
						"EmployeeHIbernateDAO");
		System.out.println("CAme in addUser 1 " + edao);
		if (edao == null)
			return "edao object is null";
		Employee e = new Employee();
		e.setEmployeeId(employeeId);
		e.setEmployeeName(employeeName);
		edao.addEmployee(e);
		return "success";
	}

	public ArrayList getEmployeeList() {
		EmployeeHIbernateDAO edao = (EmployeeHIbernateDAO) WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext()).getBean("daoTarget");
		return edao.getAllEmployees();
	}

	public String testFramework(String param) {
		return "Framework set up successfule Here is the param you sent"
				+ param;

	}
	
	public List savePatientDetails(List patients) throws Exception{
		try{
			/*FileOutputStream fo = new FileOutputStream("D:\\shetty1.txt");
			fo.write(patients.toString().getBytes());*/
			PatientDao edao = (PatientDao) WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext()).getBean("PatientDao");
			return edao.addPatients(patients);
		}catch(Throwable e){
			e.printStackTrace();
			
			/*try {
				
				PrintWriter pw = new PrintWriter(new File("D:\\shetty.txt"));
				e.printStackTrace(pw);
				pw.flush();
				pw.close();
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}*/
			Logger.log(e);
			
			throw new Exception(e.getMessage());
			
		}
		
	}
	
	public List deletePatients(List patients) throws Exception{
		try{
			PatientDao edao = (PatientDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("PatientDao");
			return edao.deletePatients(patients);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getPatients() throws Exception{
		try{
			PatientDao edao = (PatientDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("PatientDao");
			return edao.listAllPatients();
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getPatientById(Double patientId) throws Exception{
		try{
			PatientDao edao = (PatientDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("PatientDao");
			return edao.listPatientById(patientId.longValue());
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public List saveDrug(List drugs) throws Exception{
		try{
			DrugDao edao = (DrugDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("DrugDao");
			return edao.addDrugs(drugs);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List deleteDrugs(List drugs) throws Exception{
		try{
			DrugDao edao = (DrugDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("DrugDao");
			return edao.deleteDrugs(drugs);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List deleteTreatmentDrugs(List treatmentDrugs) throws Exception{
		try{
			TreatmentDrugDao edao = (TreatmentDrugDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("TreatmentDrugDao");
			return edao.deleteTreatmentDrug(treatmentDrugs);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getDrugs() throws Exception{
		try{
			DrugDao edao = (DrugDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("DrugDao");
			return edao.getDrugs();
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getDrugById(Double drugId) throws Exception{
		try{
			DrugDao edao = (DrugDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("DrugDao");
			return edao.getDrugsById(drugId.longValue());
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List searchPatientByCriteria(String searchValue,String cond) throws Exception{
		try{
			PatientDao edao = (PatientDao) WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext()).getBean("PatientDao");
			
			if(cond.equals("phoneNumber")){
				return edao.searchPatientByPhoneNumber(searchValue);
			}else{
				return edao.searchPatientByName(searchValue,cond);
			}
			
			
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List savePanchkarma(List panchkarmaList) throws Exception{
		try{
			PanchkarmaDao edao = (PanchkarmaDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("PanchkarmaDao");
			return edao.addPanchkarma(panchkarmaList);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List savePanchkarmaCost(Panchkarma panchkarma) throws Exception{
		try{
			PanchkarmaDao panchdao = (PanchkarmaDao) WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext()).getBean("PanchkarmaDao");
			Panchkarma panchById = panchdao.getPanchkarmaById(panchkarma.getPanchkarmaId());
			if(panchById.getPanchkarmaCost() != null && panchById.getPanchkarmaCost().size() > 0){
				
				PanchkarmaCostDao edao = (PanchkarmaCostDao) WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext()).getBean("PanchkarmaCostDao");
				edao.deletePanchkarmaCost(new ArrayList<PanchkarmaCost>(panchById.getPanchkarmaCost()));
			}
			
			
			List<Panchkarma> panchList = new ArrayList<Panchkarma>();
			panchList.add(panchkarma);
			return savePanchkarma(panchList);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List getPanchkarma() throws Exception{
		try{
			PanchkarmaDao edao = (PanchkarmaDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("PanchkarmaDao");
			return edao.getPanchkarma();
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	private ServletContext getServletContext(){
		HttpServletRequest req = FlexContext.getHttpRequest();
		return req.getSession().getServletContext();
		
	}
	
	
	public List deleteTreatment(List treatmentList) throws Exception{
		try{
			TreatmentDao edao = (TreatmentDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("TreatmentDao");
			return edao.deleteTreatments(treatmentList);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List deletePanchkarma(List panchkarmaList) throws Exception{
		try{
			PanchkarmaDao edao = (PanchkarmaDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("PanchkarmaDao");
			return edao.deletePanchkarma(panchkarmaList);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List deletePatient(List patientList) throws Exception{
		try{
			PatientDao edao = (PatientDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("PatientDao");
			return edao.deletePatients(patientList);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List deleteDrug(List drugList) throws Exception{
		try{
			DrugDao edao = (DrugDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("DrugDao");
			return edao.deleteDrugs(drugList);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List deletePatientPanchkarma(List panchTreatList) throws Exception{
		try{
			PatientPanchkarmaDao edao = (PatientPanchkarmaDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("PatientPanchkarmaDao");
			return edao.deletePanchkarmaTreatments(panchTreatList);
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public Map getTreatmentsAndCostByDate(Date startDate, Date endDate) throws Exception{
		try{
			Map resultMap = null;
			TreatmentDao edao = (TreatmentDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("TreatmentDao");
			
			List tr =  edao.getTreatmentsByDate(startDate, endDate);
			
			
			for(int i=0;i<tr.size();i++){
				Treatment treatment = (Treatment)tr.get(i);
				treatment.setPatient((Patient)treatment.getPatient().clone());
			}
			
			PatientPanchkarmaDao pp = (PatientPanchkarmaDao) WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext()).getBean("PatientPanchkarmaDao");
			 List patientPanchkarmaList = pp.getPanchkarmaTreatmentByDate(startDate, endDate);
			 
			 
			 for(int j=0;j<patientPanchkarmaList.size();j++){
				 PatientPanchkarma ppM = (PatientPanchkarma)patientPanchkarmaList.get(j);
				 ppM.setPatient((Patient)ppM.getPatient().clone());
			 }
			
			
				
			 resultMap = new HashMap();
			 //resultMap.put("treatmentCost", new Double(totalTreatmentCost));
			 //resultMap.put("panchkarmaTreatmentCost", new Double(ppCost));
			 resultMap.put("treatmentList", tr);
			 resultMap.put("patientPanchkarmaList", patientPanchkarmaList);
			 
			
			return resultMap;
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	
	public List<TreatmentPhotos> saveTreatmentPics(List<TreatmentPhotos> picList) throws Exception{
		try{
			TreatmentPhotoDao edao = (TreatmentPhotoDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("TreatmentPhotoDao");
			
			List<TreatmentPhotos> trPicList =  edao.saveTreatmentPic(picList);
			return trPicList;
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List<TreatmentPhotos> deleteTreatmentPics(List<TreatmentPhotos> picList) throws Exception{
		try{
			TreatmentPhotoDao edao = (TreatmentPhotoDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("TreatmentPhotoDao");
			
			List<TreatmentPhotos> trPicList =  edao.deleteTreatments(picList);
			return trPicList;
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	
	public List<TreatmentPhotos> getTreatmentPicsByTreatmentId(Treatment treatment) throws Exception{
		try{
			TreatmentPhotoDao edao = (TreatmentPhotoDao) WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext()).getBean("TreatmentPhotoDao");			
			List<TreatmentPhotos> trPicList =  edao.getTreatmentsPicsByTreatment(treatment.getTreatmentId());
			return trPicList;
		}catch (Throwable e) {
			// TODO: handle exception
			Logger.log(e);
			throw new Exception(e.getMessage());
		}
	}
	

}
