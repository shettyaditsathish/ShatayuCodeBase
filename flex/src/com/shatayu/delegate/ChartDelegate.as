package com.shatayu.delegate
{
	import mx.collections.ArrayCollection;
	import mx.core.Application;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class ChartDelegate{
		private var responder:IResponder;
		private var service:RemoteObject;
		
		public function ChartDelegate(responder:IResponder){
			this.service = Application.application.services.chartDelegate;
			this.responder = responder
		}
		
		public function getDataForTreatmentNumbers(startDate:Date,endDate:Date):void{
			var token : AsyncToken = service.getDataForTreatmentNumbers(startDate,endDate);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
		public function getMedicineUsageByList(drugList:ArrayCollection,startDate:Date,endDate:Date):void{
			var token : AsyncToken = service.getMedicineUsageByList(drugList,startDate,endDate);
			token.resultHandler = responder.result;
			token.faultHandler = responder.fault;
		}
		
	}
}