package com.shatayu.delegate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shatayu.dao.DrugDao;
import com.shatayu.dao.PatientPanchkarmaDao;
import com.shatayu.dao.TreatmentDao;
import com.shatayu.model.Drug;
import com.shatayu.model.Treatment;
import com.shatayu.model.TreatmentDrug;

import flex.messaging.FlexContext;

public class ChartDelegate {
	
	private static String[] monthArr = new String[]{"Jan","Feb","Mar","Apr","May","Jun", "Jul","Aug", "Sep","Oct","Nov","Dec"};
	
	public ArrayList<HashMap<String, Object>> getDataForTreatmentNumbers(Date startDate, Date endate){
		ArrayList<HashMap<String, Object>> chartDataList = new ArrayList<HashMap<String, Object>>();
		System.out.println(" check year "+startDate.getYear() + "   "+endate.getYear());
		startDate.setDate(1);
		do{
			HashMap<String, Object> mp = new HashMap();
			mp.put("month", getMonthDetailsByDate(startDate));
			
			Date queryStartDate = new Date();
			queryStartDate.setTime(startDate.getTime());
			queryStartDate.setDate(1);
			
			Date queryEndDate = new Date();
			queryEndDate.setTime(startDate.getTime());
			queryEndDate.setDate(1);
			queryEndDate.setMonth(queryEndDate.getMonth()+1);
			queryEndDate.setDate(queryEndDate.getDate() - 1);
			
			
			
			TreatmentDao edao = (TreatmentDao) WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext()).getBean("TreatmentDao");
			
			List tr =  edao.getTreatmentsByDate(queryStartDate, queryEndDate);
			
			mp.put("treatments", new Integer(tr.size()));
			PatientPanchkarmaDao pp = (PatientPanchkarmaDao) WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext()).getBean("PatientPanchkarmaDao");
			
			 List patientPanchkarmaList = pp.getPanchkarmaTreatmentByDate(queryStartDate, queryEndDate);
			
			
			mp.put("panchkarmas", new Integer(patientPanchkarmaList.size()));
			chartDataList.add(mp);
			startDate.setMonth(startDate.getMonth() + 1);
			
		}while(!(startDate.getTime() > endate.getTime()));
		return chartDataList;
	}
	
	private String getMonthDetailsByDate(Date reqDate){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(reqDate.getTime());
		return  monthArr[cal.get(cal.MONTH)] +  "'" + cal.get(cal.YEAR);
		
	}
	
	public List<HashMap<String, Object>> getAllMedicineUsage(Date startDate, Date endate){
		DrugDao  drugDao = (DrugDao)WebApplicationContextUtils
		.getRequiredWebApplicationContext(getServletContext()).getBean("DrugDao");
		List<Drug> drugList = drugDao.getDrugs();
		return getMedicineUsageByList(drugList,startDate,endate);
		
		
	}
	
	public List<HashMap<String, Object>> getMedicineUsageByList(List<Drug> drugList,Date startDate, Date endate){
		List<HashMap<String, Object>> result =new ArrayList<HashMap<String,Object>>();
		startDate.setDate(1);
		do{
			HashMap<String, Object> mp = new HashMap();
			mp.put("month", getMonthDetailsByDate(startDate));
			
			Date queryStartDate = new Date();
			queryStartDate.setTime(startDate.getTime());
			queryStartDate.setDate(1);
			
			Date queryEndDate = new Date();
			queryEndDate.setTime(startDate.getTime());
			queryEndDate.setDate(1);
			queryEndDate.setMonth(queryEndDate.getMonth()+1);
			queryEndDate.setDate(queryEndDate.getDate() - 1);
			
			TreatmentDao edao = (TreatmentDao) WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext()).getBean("TreatmentDao");
			
			
			
			List<Treatment> tr =  edao.getTreatmentsByDate(queryStartDate, queryEndDate);
			for (Treatment treatment : tr) {
				List<TreatmentDrug> tdr = (List<TreatmentDrug>) treatment.getTreatmentDrug();
				for (TreatmentDrug treatmentDrug : tdr) {
					long drugId = treatmentDrug.getDrugId();
					String duration = treatmentDrug.getDuration();
					String[] durArr = duration.split("-");
					long quantity = 0;
					for (int i = 0; i < durArr.length; i++) {
						if(durArr[i].trim().length() > 0 ){
							try{
								quantity = quantity + Long.parseLong(durArr[i].trim());
							}catch(Throwable e){
								
							}
						}
						
					}
					long noOfDays = treatmentDrug.getNoOfDays();
					long totalQuantity = quantity * noOfDays;
					for (Drug dg : drugList){
						
						if(mp.get(dg.getDrugName()) == null){
							mp.put(dg.getDrugName(), new Long(0));
						}
						if(dg.getDrugId() ==  drugId){
							mp.put(dg.getDrugName(), new Long(((Long)mp.get(dg.getDrugName())).longValue() + totalQuantity));
						}
						
					}
				}
			}
			startDate.setMonth(startDate.getMonth() + 1);
			result.add(mp);
		}while(!(startDate.getTime() > endate.getTime()));
		
		return result;
	}
	
	
	
	public static void main(String[] args){
		ChartDelegate ch = new ChartDelegate();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2010);
		
		Date startDate = new Date();
		startDate.setTime(cal.getTimeInMillis());
		
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.YEAR, 2010);
		Date endDate = new Date();
		endDate.setTime(cal.getTimeInMillis());
		System.out.println("start Date "+ startDate +" endDate "+endDate);
		System.out.println(" result "+ ch.getDataForTreatmentNumbers(startDate, endDate) );
	}
	
	private ServletContext getServletContext(){
		HttpServletRequest req = FlexContext.getHttpRequest();
		return req.getSession().getServletContext();
		
	}
}
 