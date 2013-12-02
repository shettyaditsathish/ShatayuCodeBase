package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.event.ShatayuEvent;
	import com.shatayu.event.ViewDataHolder;
	import com.shatayu.event.ViewEvent;
	import com.shatayu.model.ModelLocatorImp;
	import com.shatayu.model.Panchkarma;
	import com.shatayu.view.controller.ViewController;
	
	import flash.display.Sprite;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.core.Application;
	import mx.events.CloseEvent;
	import mx.rpc.IResponder;
	
	public class AddPanchkarmaCommand implements ICommand,IResponder
	{
		
		public function execute( event : CairngormEvent ) : void
		{
			trace("Came in AddPanchkarmaCommand");
			var delegate:PatientMgmtDelegate = new PatientMgmtDelegate( this ); 
			var arr:ArrayCollection =  new ArrayCollection();
			var panchkarma:Panchkarma = ShatayuEvent(event).dataLoad as Panchkarma
			arr.addItem(panchkarma);
			delegate.savePanchkarma(arr);			
		}
		   
		public function result( event : Object ) : void
		{		
			var arrList:ArrayCollection = event.result as ArrayCollection;
			for(var i:uint = 0;i<arrList.length;i++){
				if(arrList[i] ==  null)continue;
				var panchkarmaObj:Panchkarma = arrList[i] as Panchkarma;
				for(var j:int =0;j<ModelLocatorImp.getInstance().panchkarmaList.length;j++){
					if(panchkarmaObj.panchkarmaId == Panchkarma(ModelLocatorImp.getInstance().panchkarmaList[j]).panchkarmaId){
						ModelLocatorImp.getInstance().panchkarmaList[j] = panchkarmaObj;
					}
				}
				if(!ModelLocatorImp.getInstance().panchkarmaList.contains(panchkarmaObj)){
					ModelLocatorImp.getInstance().panchkarmaList.addItem(panchkarmaObj);
				}
			}
			Alert.show("Do you want to add a new Panchkarma?", "", 3, Sprite(Application.application), alertClickHandler);
			
			trace("result lebgth "+arrList.length);
			
		}
		
		private function alertClickHandler(event:CloseEvent):void {
            if (event.detail==Alert.YES){
                var viewDataHolder:ViewDataHolder = new ViewDataHolder();
				viewDataHolder.viewType = ViewController.ADD_PANCHKARMA_VIEW;
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