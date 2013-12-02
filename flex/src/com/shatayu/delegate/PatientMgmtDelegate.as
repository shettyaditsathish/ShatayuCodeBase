package com.shatayu.delegate
{
	import com.shatayu.model.Panchkarma;
	import com.shatayu.model.Treatment;
	
	import mx.collections.ArrayCollection;
	import mx.core.Application;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class PatientMgmtDelegate
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		
		public function PatientMgmtDelegate(responder:IResponder){
			trace("CAme in delegate constructor");
			this.service = Application.application.services.patientMgmtDelegate;
			this.responder = responder
		}
		
		public function testFramework(param:String):void{
			trace("CAme in callback of testFrameworkd");
			var token : AsyncToken = service.testFramework(param);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function addUser(employeeId:String,empName:String):void{
			trace("CAme in callback of testFrameworkd");
			var token : AsyncToken = service.addUser(employeeId,empName);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function saveDrug(drugs:ArrayCollection):void{
			trace("CAme in callback of saveDrug");
			var token : AsyncToken = service.saveDrug(drugs);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function getDrugs():void{
			trace("CAme in callback of saveDrug");
			var token : AsyncToken = service.getDrugs();
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function savePanchkarma(panchkarmaList:ArrayCollection):void{
			var token : AsyncToken = service.savePanchkarma(panchkarmaList);
			var panchkarma:Panchkarma = panchkarmaList[0];
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function getPanchkarma():void{
			trace("CAme in callback of saveDrug");
			var token : AsyncToken = service.getPanchkarma();
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function savePatientDetails(patientList:ArrayCollection):void{
			var token : AsyncToken = service.savePatientDetails(patientList);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function searchPatientByCriteria(searchValue:String,cond:String):void{
			var token : AsyncToken = service.searchPatientByCriteria(searchValue,cond);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function getPatients():void{
			var token : AsyncToken = service.getPatients();
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function getTreatmentsAndCostByDate(startDate:Date,endDate:Date):void{
			var token : AsyncToken = service.getTreatmentsAndCostByDate(startDate,endDate);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		
		public function deletePatient(patientList:ArrayCollection):void{
			var token : AsyncToken = service.deletePatient(patientList);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function deleteTreatment(treatmentList:ArrayCollection):void{
			var token : AsyncToken = service.deleteTreatment(treatmentList);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function deleteDrug(drugList:ArrayCollection):void{
			var token : AsyncToken = service.deleteDrug(drugList);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function deletePanchkarma(panchkarmaList:ArrayCollection):void{
			var token : AsyncToken = service.deletePanchkarma(panchkarmaList);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function deletePatientPanchkarma(panchTreatList:ArrayCollection):void{
			var token : AsyncToken = service.deletePatientPanchkarma(panchTreatList);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function deleteTreatmentDrugs(trDrug:ArrayCollection):void{
			var token : AsyncToken = service.deleteTreatmentDrugs(trDrug);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function saveTreatmentPics(picList:ArrayCollection):void{
			var token : AsyncToken = service.saveTreatmentPics(picList);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function getTreatmentPicsByTreatmentId(tr:Treatment):void{
			var token : AsyncToken = service.getTreatmentPicsByTreatmentId(tr);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function savePanchkarmaCost(panchkarma:Panchkarma):void{
			var token : AsyncToken = service.savePanchkarmaCost(panchkarma);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
	}
}