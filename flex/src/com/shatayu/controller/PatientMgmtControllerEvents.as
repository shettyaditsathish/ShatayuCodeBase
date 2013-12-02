package com.shatayu.controller
{
	public class PatientMgmtControllerEvents
	{
		public static const TEST_COMMAND:String = "testCommand";
		public static const ADD_DRUG_COMMAND:String = "addDrugCommand";
		public static const LIST_DRUG_COMMAND:String = "listDrugCommand";
		public static const ADD_PANCHKARMA_COMMAND:String = "addPanchkarmaCommand";
		public static const LIST_PANCHKARMA_COMMAND:String = "listPanchkarmaCommand";
		public static const ADD_PATIENT_COMMAND:String = "addPatientCommand";
		public static const LIST_ALL_PATIENTS_COMMAND:String = "listAllPatientsCommand";
		public static const LIST_PATIENT_BY_CRITERIA_COMMAND:String = "listPatientByCriteriaCommand";
		public static const LIST_TREATMENTS_BY_DATE_COMMAND:String = "listTreatmentsByDateCommand";
		public static const DELETE_PATIENT_COMMAND:String = "deletePatientCommand";
		public static const DELETE_TREATMENT_COMMAND:String = "deleteTreatmentCommand";
		public static const DELETE_PANCHKARMA_COMMAND:String = "deletePanchkarmaCommand";
		public static const DELETE_DRUG_COMMAND:String = "deleteDrugCommand";
		public static const DELETE_PATIENT_PANCHKARMA_COMMAND:String = "deletePatientPanchkarmaCommand";
		public static const DELETE_TREATMENT_DRUG_COMMAND:String = "deleteTreatmentDrugCommand";
		
		public static const SAVE_APPOINTMENT_COMMAND:String = "saveAppointmentCommand";
		public static const DELETE_APPOINTMENT_COMMAND:String = "deleteAppointmentCommand";
		public static const GET_APPOINTMENT_BY_DATE_COMMAND:String = "getAppointmentByDateCommand";
		public static const GET_APPOINTMENT_BY_DATE_AND_PATIENTID_COMMAND:String = "getAppointmentByDateAndPatientIdCommand";
		
		public static const SAVE_APPOINTMENT_DETAILS_COMMAND:String = "saveAppointmentDetailsCommand";
		public static const DELETE_APPOINTMENT_DETAILS_COMMAND:String = "deleteAppointmentDetailsCommand";
		public static const GET_APPOINTMENT_DETAILS_BY_DATE_COMMAND:String = "getAppointmentDetailsByDateCommand";
		public static const GET_APPOINTMENT_DETAILS_BY_DATE_AND_PATIENTID_COMMAND:String = "getAppointmentDetailsByDateAndPatientIdCommand";
		
		public static const GET_APPOINTMENT_DETAILS_BY_APPOINTMENTID_COMMAND:String = "getAppointmentDetailsByAppointmentIdCommand";
		public static const TREATMENT_MONTHS_CHART_COMMAND:String = "treatmentMonthsChart";
		public static const DRUG_MONTHS_CHART_COMMAND:String = "drugMonthsChart";
		
		public static const EMAIL_SEND_COMMAND:String = "emailSendCommand";
		public static const EMAIL_RECIEVE_COMMAND:String = "emailRecieveCommand";
		
		public static const SAVE_TREATMENT_PICS_COMMAND:String = "saveTreatmentsPicsCommand";
		public static const GET_TREATMENT_PICS_COMMAND:String = "getTreatmentsPicsCommand";
		
		public static const SAVE_PANCHKARMA_COST_COMMAND:String = "savePanchkarmaCostCommand";
		
	}
}