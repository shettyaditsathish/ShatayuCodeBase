package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.event.ShatayuEvent;
	import com.shatayu.model.Treatment;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetTreatmentPicsCommand implements ICommand,IResponder
	{
		private var callBack:Function ;
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in Add Drug Command");
			var delegate : PatientMgmtDelegate = new PatientMgmtDelegate( this ); 
			callBack = ShatayuEvent(event).callBackFunc;
			var tr:Treatment = ShatayuEvent(event).dataLoad as Treatment; 
			delegate.getTreatmentPicsByTreatmentId(tr);			
		}
		   
		public function result( event : Object ) : void
		{		
			callBack(event.result);
		}
		
		
				
		public function fault( event : Object ) : void
		{
			Alert.show("A problem has occured on the server side. Please contact the technical person " + event);
			//Need to build a Error Frasmework class
		}

	}
}