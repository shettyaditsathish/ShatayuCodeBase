package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.event.ShatayuEvent;
	import com.shatayu.event.ViewDataHolder;
	import com.shatayu.event.ViewEvent;
	import com.shatayu.view.controller.ViewController;
	
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class ListTreatmentsByDateCommand implements ICommand,IResponder
	{
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in ListTreatmentsByDateCommand");
			var delegate : PatientMgmtDelegate = new PatientMgmtDelegate( this ); 
			var dataLoad:Object = ShatayuEvent(event).dataLoad; 
			delegate.getTreatmentsAndCostByDate(dataLoad["startDate"] as Date,dataLoad["endDate"] as Date);			
		}
		   
		public function result( event : Object ) : void
		{		
			trace("CAme in ListTreatmentsByDateCommand 1");
			var obj:Object = event.result as Object;
			var viewDataHolder:ViewDataHolder = new ViewDataHolder();
			viewDataHolder.viewType = ViewController.LIST_TREATMENTS_BY_DATE_VIEW;
			viewDataHolder.viewData = obj;
			trace("CAme in ListTreatmentsByDateCommand 2");
			ViewController.getInstance().dispatchEvent(new ViewEvent(ViewController.SHOW_VIEW,viewDataHolder));
			trace("objh "+obj);
		}
				
		public function fault( event : Object ) : void
		{
			Alert.show("A problem has occured on the server side. Please contact the technical person " + event);
			//Need to build a Error Frasmework class
		}

	}
}