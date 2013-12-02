package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.event.ShatayuEvent;
	import com.shatayu.event.ViewDataHolder;
	import com.shatayu.event.ViewEvent;
	import com.shatayu.model.Drug;
	import com.shatayu.model.ModelLocatorImp;
	import com.shatayu.view.controller.ViewController;
	
	import flash.display.Sprite;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.core.Application;
	import mx.events.CloseEvent;
	import mx.rpc.IResponder;
	
	public class AddDrugCommand implements ICommand,IResponder
	{
		public var drug:Drug;
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in Add Drug Command");
			var delegate : PatientMgmtDelegate = new PatientMgmtDelegate( this ); 
			var arr:ArrayCollection =  new ArrayCollection();
			drug = ShatayuEvent(event).dataLoad as Drug
			arr.addItem(drug);
			delegate.saveDrug(arr);			
		}
		   
		public function result( event : Object ) : void
		{		
			var arrList:ArrayCollection = event.result as ArrayCollection;
			for(var i:uint = 0;i<arrList.length;i++){
				if(arrList[i] ==  null)continue;
				var drugObj:Drug = arrList[i] as Drug;
				for(var j:int =0;j<ModelLocatorImp.getInstance().drugList.length;j++){
					if(drugObj.drugId == Drug(ModelLocatorImp.getInstance().drugList[j]).drugId){
						ModelLocatorImp.getInstance().drugList[j] = drugObj;
					}
				}
				if(!ModelLocatorImp.getInstance().drugList.contains(drugObj)){
					ModelLocatorImp.getInstance().drugList.addItem(drugObj);
				}
			}
			
			Alert.show("Do you want to add a new drug?", "", 3, Sprite(Application.application), alertClickHandler);
			
			trace("result lebgth "+arrList.length);
			
		}
		
		private function alertClickHandler(event:CloseEvent):void {
            if (event.detail==Alert.YES){
                var viewDataHolder:ViewDataHolder = new ViewDataHolder();
				viewDataHolder.viewType = ViewController.ADD_DRUG_VIEW;
				ViewController.getInstance().dispatchEvent(new ViewEvent(ViewController.SHOW_VIEW,viewDataHolder));
            }
        }
				
		public function fault( event : Object ) : void
		{
			Alert.show("A problem has occured on the server side. Please contact the technical person " + event);
			//Need to build a Error Frasmework class
		}

	}
}