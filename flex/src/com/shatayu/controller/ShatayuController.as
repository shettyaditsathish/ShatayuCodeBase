package com.shatayu.controller
{
	import com.adobe.cairngorm.control.FrontController;
	import com.shatayu.command.AddDrugCommand;
	import com.shatayu.command.AddPanchkarmaCommand;
	import com.shatayu.command.AddPatientCommand;
	import com.shatayu.command.DeleteAppointmentCommand;
	import com.shatayu.command.DeleteAppointmentDetailsCommand;
	import com.shatayu.command.DeleteDrugCommand;
	import com.shatayu.command.DeletePanchkarmaCommand;
	import com.shatayu.command.DeletePatientCommand;
	import com.shatayu.command.DeletePatientPanchkarmaCommand;
	import com.shatayu.command.DeleteTreatmentCommand;
	import com.shatayu.command.DeleteTreatmentDrugCommand;
	import com.shatayu.command.GetAppointmentDetailsByAppointmentId;
	import com.shatayu.command.GetAppointmentsByDateAndPatientIdCommand;
	import com.shatayu.command.GetAppointmentsByDateCommand;
	import com.shatayu.command.GetAppointmentsDetailsByDateAndPatientIdCommand;
	import com.shatayu.command.GetAppointmentsDetailsByDateCommand;
	import com.shatayu.command.GetTreatmentPicsCommand;
	import com.shatayu.command.ListAllPatientsCommand;
	import com.shatayu.command.ListDrugCommand;
	import com.shatayu.command.ListPanchkarmaCommand;
	import com.shatayu.command.ListPatientsByCriteriaCommand;
	import com.shatayu.command.ListTreatmentsByDateCommand;
	import com.shatayu.command.SaveAppointmentCommand;
	import com.shatayu.command.SaveAppointmentDetailsCommand;
	import com.shatayu.command.SavePanchkarmaCostCommand;
	import com.shatayu.command.SaveTreatmentPicsCommand;
	import com.shatayu.command.TestCommand;
	import com.shatayu.command.charts.DrugMonthsChartCommand;
	import com.shatayu.command.charts.EmailRecieveCommand;
	import com.shatayu.command.charts.EmailSendCommand;
	import com.shatayu.command.charts.TreatmentMonthsChartCommand;
	
	public class ShatayuController extends FrontController{
		public function ShatayuController()
		{
			//Alert.show("Added command");
			addCommand(PatientMgmtControllerEvents.TEST_COMMAND,TestCommand);
			addCommand(PatientMgmtControllerEvents.ADD_DRUG_COMMAND,AddDrugCommand);
			addCommand(PatientMgmtControllerEvents.LIST_DRUG_COMMAND,ListDrugCommand);
			addCommand(PatientMgmtControllerEvents.ADD_PANCHKARMA_COMMAND,AddPanchkarmaCommand);
			addCommand(PatientMgmtControllerEvents.LIST_PANCHKARMA_COMMAND,ListPanchkarmaCommand);
			addCommand(PatientMgmtControllerEvents.ADD_PATIENT_COMMAND,AddPatientCommand);
			addCommand(PatientMgmtControllerEvents.LIST_PATIENT_BY_CRITERIA_COMMAND,ListPatientsByCriteriaCommand);
			addCommand(PatientMgmtControllerEvents.LIST_ALL_PATIENTS_COMMAND,ListAllPatientsCommand);
			addCommand(PatientMgmtControllerEvents.LIST_TREATMENTS_BY_DATE_COMMAND,ListTreatmentsByDateCommand);
			addCommand(PatientMgmtControllerEvents.DELETE_PATIENT_COMMAND,DeletePatientCommand);
			addCommand(PatientMgmtControllerEvents.DELETE_TREATMENT_COMMAND,DeleteTreatmentCommand);
			addCommand(PatientMgmtControllerEvents.DELETE_PANCHKARMA_COMMAND,DeletePanchkarmaCommand);
			addCommand(PatientMgmtControllerEvents.DELETE_DRUG_COMMAND,DeleteDrugCommand);
			addCommand(PatientMgmtControllerEvents.DELETE_PATIENT_PANCHKARMA_COMMAND,DeletePatientPanchkarmaCommand);
			addCommand(PatientMgmtControllerEvents.DELETE_TREATMENT_DRUG_COMMAND,DeleteTreatmentDrugCommand);
			
			addCommand(PatientMgmtControllerEvents.SAVE_APPOINTMENT_COMMAND,SaveAppointmentCommand);
			addCommand(PatientMgmtControllerEvents.DELETE_APPOINTMENT_COMMAND,DeleteAppointmentCommand);
			addCommand(PatientMgmtControllerEvents.GET_APPOINTMENT_BY_DATE_COMMAND,GetAppointmentsByDateCommand);
			addCommand(PatientMgmtControllerEvents.GET_APPOINTMENT_BY_DATE_AND_PATIENTID_COMMAND,GetAppointmentsByDateAndPatientIdCommand);
			
			addCommand(PatientMgmtControllerEvents.SAVE_APPOINTMENT_DETAILS_COMMAND,SaveAppointmentDetailsCommand);
			addCommand(PatientMgmtControllerEvents.DELETE_APPOINTMENT_DETAILS_COMMAND,DeleteAppointmentDetailsCommand);
			addCommand(PatientMgmtControllerEvents.GET_APPOINTMENT_DETAILS_BY_DATE_COMMAND,GetAppointmentsDetailsByDateCommand);
			addCommand(PatientMgmtControllerEvents.GET_APPOINTMENT_DETAILS_BY_DATE_AND_PATIENTID_COMMAND,GetAppointmentsDetailsByDateAndPatientIdCommand);
			//Alert.show("Added command");
			
			addCommand(PatientMgmtControllerEvents.GET_APPOINTMENT_DETAILS_BY_APPOINTMENTID_COMMAND,GetAppointmentDetailsByAppointmentId);
			addCommand(PatientMgmtControllerEvents.TREATMENT_MONTHS_CHART_COMMAND,TreatmentMonthsChartCommand);
			addCommand(PatientMgmtControllerEvents.DRUG_MONTHS_CHART_COMMAND,DrugMonthsChartCommand);
			
			addCommand(PatientMgmtControllerEvents.EMAIL_SEND_COMMAND,EmailSendCommand);
			addCommand(PatientMgmtControllerEvents.EMAIL_RECIEVE_COMMAND,EmailRecieveCommand);
			
			addCommand(PatientMgmtControllerEvents.SAVE_TREATMENT_PICS_COMMAND,SaveTreatmentPicsCommand);
			addCommand(PatientMgmtControllerEvents.GET_TREATMENT_PICS_COMMAND,GetTreatmentPicsCommand);
			
			addCommand(PatientMgmtControllerEvents.SAVE_PANCHKARMA_COST_COMMAND,SavePanchkarmaCostCommand);
		}

	}
}