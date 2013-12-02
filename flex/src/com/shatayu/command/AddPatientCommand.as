package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.event.ShatayuEvent;
	import com.shatayu.event.ViewDataHolder;
	import com.shatayu.event.ViewEvent;
	import com.shatayu.model.Patient;
	import com.shatayu.view.controller.ViewController;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class AddPatientCommand implements ICommand,IResponder
	{
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in Add Drug Command");
			var delegate : PatientMgmtDelegate = new PatientMgmtDelegate( this ); 
			var arr:ArrayCollection =  new ArrayCollection();
			var patient:Patient = ShatayuEvent(event).dataLoad as Patient 
			arr.addItem(patient);
			delegate.savePatientDetails(arr);			
		}
		   
		public function result( event : Object ) : void
		{		
			var arrList:ArrayCollection = event.result as ArrayCollection;
			var p:Patient =  arrList.getItemAt(0) as Patient;
			var viewDataHolder:ViewDataHolder = new ViewDataHolder();
			viewDataHolder.viewType = ViewController.ADD_PATIENT_VIEW;
			viewDataHolder.viewData = p;
			ViewController.getInstance().dispatchEvent(new ViewEvent(ViewController.SHOW_VIEW,viewDataHolder));
			trace("result length "+arrList.length);
		}
				
		public function fault( event : Object ) : void
		{
			Alert.show("A problem has occured on the server side. Please contact the technical person " + event);
			//Need to build a Error Frasmework class
		}

	}
}