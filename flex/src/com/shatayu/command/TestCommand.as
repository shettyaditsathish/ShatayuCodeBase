package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.event.ShatayuEvent;
	
	import mx.controls.Alert;
	import mx.core.Application;
	import mx.rpc.IResponder;
	
	public class TestCommand implements ICommand,IResponder
	{
		public function execute( event : CairngormEvent ) : void
		{
			Alert.show("CAme in TestCommand");
			var delegate : PatientMgmtDelegate = new PatientMgmtDelegate( this );   
			var obj:Object = ShatayuEvent(event).dataLoad;
			//delegate.testFramework( ShatayuEvent(event).dataLoad as String);
			delegate.addUser(String(obj["empId"]),String(obj["empName"]));    
			
		}
		   
		public function result( event : Object ) : void
		{			
			Alert.show("result");
			Application.application.resultCallBack(event.result as String);
		}
				
		public function fault( event : Object ) : void
		{
			Alert.show("A problem has occured on the server side. Please contact the technical person " + event);
			//Need to build a Error Frasmework class
		}

	}
}