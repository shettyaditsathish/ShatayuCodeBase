package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.OrganiserDelegate;
	import com.shatayu.event.ShatayuEvent;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetAppointmentsDetailsByDateAndPatientIdCommand implements ICommand,IResponder
	{
		private var callBack:Function ;
		public function execute( event : CairngormEvent ) : void
		{
			
			var delegate : OrganiserDelegate = new OrganiserDelegate( this ); 
			
			var obj:Object = ShatayuEvent(event).dataLoad as Object;
			trace("CAme GetAppointmentsDetailsByDateAndPatientIdCommand" +obj );
			callBack = ShatayuEvent(event).callBackFunc;
			delegate.getAppointmentsDetailsByDateAndPatientId(obj["startDate"] as Date ,obj["endDate"] as Date,Number(obj["patientId"]));			
		}
		   
		public function result( event : Object ) : void
		{		
			//Logic pending can be added only once the UI is Complete
			callBack(event.result);
		}
		
		
		public function fault( event : Object ) : void
		{
			Alert.show("A problem has occured on the server side. Please contact the technical person " + event);
			//Need to build a Error Frasmework class
		}

	}
}