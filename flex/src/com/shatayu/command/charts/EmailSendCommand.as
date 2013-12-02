package com.shatayu.command.charts
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.OrganiserDelegate;
	import com.shatayu.event.ShatayuEvent;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class EmailSendCommand implements ICommand,IResponder
	{
		private var callBack:Function ;
		public function execute( event : CairngormEvent ) : void
		{
			var delegate :OrganiserDelegate = new OrganiserDelegate( this ); 
			
			var obj:Object = ShatayuEvent(event).dataLoad as Object;
			callBack = ShatayuEvent(event).callBackFunc;
			//trace("start Date  "+(obj["startDate"] as Date) + "  end Date "+(obj["endDate"] as Date))
			delegate.sendEmail(obj["emailProvider"] as String,obj["toAddress"] as ArrayCollection,obj["subject"] as String,obj["message"] as String);			
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