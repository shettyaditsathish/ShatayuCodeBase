package com.shatayu.delegate
{
	import com.shatayu.model.Patient;
	
	import mx.collections.ArrayCollection;
	import mx.core.Application;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class OrganiserDelegate
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		
		public function OrganiserDelegate(responder:IResponder){
			trace("CAme in delegate constructor");
			this.service = Application.application.services.organiserDelegate;
			this.responder = responder
		}
		
		public function saveAppointmentDetails(appointmentDetails:ArrayCollection):void{
			var token : AsyncToken = service.saveAppointmentDetails(appointmentDetails);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}


		public function deleteAppointmentDetails(appointmentDetails:ArrayCollection):void{
			var token : AsyncToken = service.deleteAppointmentDetails(appointmentDetails);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}

		public function getAppointmentsDetailsByDate( startDate:Date,  endDate:Date):void{
			var token : AsyncToken = service.getAppointmentsDetailsByDate(startDate,endDate);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}

		public function getAppointmentsDetailsByDateAndPatientId(startDate:Date,  endDate:Date, patientId:Number):void{
			var token : AsyncToken = service.getAppointmentsDetailsByDateAndPatientId(startDate,endDate,patientId);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		
		
		public function saveAppointment(organiser:ArrayCollection):void{
			var token : AsyncToken = service.saveAppointment(organiser);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}


		public function deleteAppointment(organiser:ArrayCollection):void{
			var token : AsyncToken = service.deleteAppointment(organiser);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}

		public function getAppointmentsByDate( startDate:Date,  endDate:Date):void{
			var token : AsyncToken = service.getAppointmentsByDate(startDate,endDate);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}

		public function getAppointmentsByDateAndPatientId(startDate:Date,  endDate:Date, patient:Patient):void{
			var token : AsyncToken = service.getAppointmentsByDateAndPatientId(startDate,endDate,patient);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function getAppointmentsDetailsByAppointmentId( appointmentId:String):void{
			var token : AsyncToken = service.getAppointmentsDetailsByAppointmentId( appointmentId );
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function sendEmail( emailProvider:String,toAddressP:ArrayCollection, subject:String,message:String):void{
			var token : AsyncToken = service.sendEmail( emailProvider,toAddressP ,subject,message);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		
		public function recieveEmail( emailProvider:String):void{
			var token : AsyncToken = service.recieveEmail( emailProvider);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}

	}
}