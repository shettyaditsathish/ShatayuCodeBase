package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.event.ShatayuEvent;
	import com.shatayu.event.ViewDataHolder;
	import com.shatayu.event.ViewEvent;
	import com.shatayu.view.controller.ViewController;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class ListPatientsByCriteriaCommand implements ICommand,IResponder
	{
		private var callBackFunc:Function;
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in Add Drug Command");
			var delegate : PatientMgmtDelegate = new PatientMgmtDelegate( this ); 
			var dataLoad:Object = ShatayuEvent(event).dataLoad; 
			delegate.searchPatientByCriteria(String(dataLoad["searchValue"]),String(dataLoad["cond"]));	
			callBackFunc = ShatayuEvent(event).callBackFunc;
					
		}
		   
		public function result( event : Object ) : void
		{	
			
			var arrList:ArrayCollection = event.result as ArrayCollection;
			if(callBackFunc != null){
				callBackFunc(arrList);
			}else{
				var viewDataHolder:ViewDataHolder = new ViewDataHolder();
				viewDataHolder.viewType = ViewController.LIST_PATIENT_BY_NAME_VIEW;
				viewDataHolder.viewData = arrList;
				ViewController.getInstance().dispatchEvent(new ViewEvent(ViewController.SHOW_VIEW,viewDataHolder));
				trace("result length "+arrList.length);
			}
		}
				
		public function fault( event : Object ) : void
		{
			Alert.show("A problem has occured on the server side. Please contact the technical person " + event);
			//Need to build a Error Frasmework class
		}

	}
}