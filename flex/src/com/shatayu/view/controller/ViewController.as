package com.shatayu.view.controller
{
	import com.shatayu.event.ViewDataHolder;
	import com.shatayu.event.ViewEvent;
	import com.shatayu.view.interfaces.IView;
	
	import flash.events.EventDispatcher;
	
	import mx.containers.ViewStack;
	import mx.core.Application;
	
	public class ViewController extends EventDispatcher
	{
		public static var SHOW_VIEW:String="showView";
		public static var ADD_DRUG_VIEW:String="adddrugView";
		public static var LIST_DRUG_VIEW:String="listddrugView";
		public static var ADD_PANCHKARMA_VIEW:String="addPanchkarmaView";
		public static var LIST_PANCHKARMA_VIEW:String="listPanchkarmaView";
		public static var ADD_PATIENT_VIEW:String="addPatientView";
		public static var LIST_PATIENT_BY_NAME_VIEW:String="listdPatientByNameView";
		public static var LIST_ALL_PATIENT_VIEW:String="listAllPatientView";
		public static var LIST_TREATMENTS_BY_DATE_VIEW:String="listTreatmentsByDateView";
		public static var ORGANISER_DISPLAY:String="organiserDisplay";
		public static var SHOW_CHARTS:String="showCharts";
		public static var SHOW_EMAIL:String="showEmail";
		public static var SHOW_EXP:String="showExp";
		public static var SHOW_PANCH_COST:String="showPanchCost";
		private static var objInst:ViewController;
		
		public static var currentView:String;
		
		public function ViewController()
		{
			this.addEventListener(SHOW_VIEW,showView);
		}
		
		public static function getInstance():ViewController
		{
			if(objInst != null)
				return objInst;
			objInst = new ViewController();
			return objInst; 
		}
		
		public function showView(ev:ViewEvent):void{
			var viewDataHolder:ViewDataHolder = ev.viewDataHolder;
			currentView = viewDataHolder.viewType;
			switch(viewDataHolder.viewType){
				case ADD_PATIENT_VIEW:
					IView(Application.application.addPatient).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.addPatient;
					break;
				case ADD_DRUG_VIEW:
					IView(Application.application.addDrug).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.addDrug;
					break;
				case LIST_DRUG_VIEW:
					IView(Application.application.listDrug).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.listDrug;
					break;
				case ADD_PANCHKARMA_VIEW:
					IView(Application.application.addPanchkarma).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.addPanchkarma;
					break;
				case LIST_PANCHKARMA_VIEW:
					IView(Application.application.listPanchkarma).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.listPanchkarma;
					break;
				case LIST_PATIENT_BY_NAME_VIEW:
					IView(Application.application.listPatient).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.listPatient;
					
					Application.application.listPatient.isSearch = true;
					break;
				case LIST_ALL_PATIENT_VIEW:
					IView(Application.application.listPatient).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.listPatient;
					Application.application.listPatient.isSearch = false;
					break;
				case LIST_TREATMENTS_BY_DATE_VIEW:
					IView(Application.application.listTreatmentsByDate).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.listTreatmentsByDate;
					break;
				case ORGANISER_DISPLAY:
					IView(Application.application.organiser).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.organiser;
					break;
				case SHOW_CHARTS:
					IView(Application.application.charts).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.charts;
					break;
				case SHOW_EMAIL:
					IView(Application.application.email).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.email;
					break;
				case SHOW_EXP:
					IView(Application.application.expenses).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.expenses;
					break;
				case SHOW_PANCH_COST:
					IView(Application.application.expenses).viewData = viewDataHolder.viewData;
					ViewStack(Application.application.viewStack).selectedChild = Application.application.panchCalc;
					break;				
				default:
					break;
			}
		}

	}
}