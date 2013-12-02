package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.event.ShatayuEvent;
	import com.shatayu.model.Panchkarma;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class SavePanchkarmaCostCommand implements ICommand,IResponder
	{
		private var callBack:Function ;
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in SavePanchkarmaCommand");
			var delegate : PatientMgmtDelegate = new PatientMgmtDelegate( this ); 
			callBack = ShatayuEvent(event).callBackFunc;
			var panchkarma:Panchkarma = ShatayuEvent(event).dataLoad as Panchkarma; 
			delegate.savePanchkarmaCost(panchkarma);			
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