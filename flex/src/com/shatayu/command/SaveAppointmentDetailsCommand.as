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
	
	public class SaveAppointmentDetailsCommand implements ICommand,IResponder
	{
		public var appt:Appointment;
		private var callBack:Function ;
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in Add Drug Command");
			var delegate : OrganiserDelegate = new OrganiserDelegate( this ); 
			var arr:ArrayCollection =  new ArrayCollection();
			appt = ShatayuEvent(event).dataLoad as Appointment;
			arr.addItem(appt);
			callBack = ShatayuEvent(event).callBackFunc;
			delegate.saveAppointmentDetails(arr);			
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