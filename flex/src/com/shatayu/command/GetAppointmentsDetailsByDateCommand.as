package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.OrganiserDelegate;
	import com.shatayu.event.ShatayuEvent;
	import com.shatayu.model.Appointment;
	import com.shatayu.model.Organiser;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetAppointmentsDetailsByDateCommand implements ICommand,IResponder
	{
		private var callBack:Function ;
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in Add Drug Command");
			var delegate : OrganiserDelegate = new OrganiserDelegate( this ); 
			
			var obj:Object = ShatayuEvent(event).dataLoad as Object;
			callBack = ShatayuEvent(event).callBackFunc;
			delegate.getAppointmentsDetailsByDate((obj["startDate"] as Date),(obj["endDate"] as Date));			
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