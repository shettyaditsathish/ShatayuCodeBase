package com.shatayu.command
{
	
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.event.ShatayuEvent;
	import com.shatayu.event.ViewDataHolder;
	import com.shatayu.event.ViewEvent;
	import com.shatayu.model.Panchkarma;
	import com.shatayu.model.TreatmentDrug;
	import com.shatayu.view.controller.ViewController;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class DeleteTreatmentDrugCommand implements ICommand,IResponder
	{
		private var trDrug:TreatmentDrug;
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in Add Drug Command");
			var delegate : PatientMgmtDelegate = new PatientMgmtDelegate( this ); 
			var arr:ArrayCollection =  new ArrayCollection();
			trDrug = ShatayuEvent(event).dataLoad as TreatmentDrug 
			arr.addItem(trDrug);
			delegate.deleteTreatmentDrugs(arr);			
		}
		   
		public function result( event : Object ) : void
		{		
			var viewDataHolder:ViewDataHolder = new ViewDataHolder();
			viewDataHolder.viewType = ViewController.currentView;
			viewDataHolder.viewData = new Object();
			viewDataHolder.viewData["command"] = "deleteTreatmentDrug";
			viewDataHolder.viewData["commandData"] = trDrug;
			ViewController.getInstance().dispatchEvent(new ViewEvent(ViewController.SHOW_VIEW,viewDataHolder));
			
		}
				
		public function fault( event : Object ) : void
		{
			Alert.show("A problem has occured on the server side. Please contact the technical person " + event);
			//Need to build a Error Frasmework class
		}

	}
}