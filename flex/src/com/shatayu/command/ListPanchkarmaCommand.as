package com.shatayu.command
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.shatayu.delegate.PatientMgmtDelegate;
	import com.shatayu.model.ModelLocatorImp;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class ListPanchkarmaCommand implements ICommand,IResponder
	{
		public function execute( event : CairngormEvent ) : void
		{
			trace("CAme in ListDrugCommand Drug Command");
			var delegate : PatientMgmtDelegate = new PatientMgmtDelegate( this ); 
			delegate.getPanchkarma();			
		}
		   
		public function result( event : Object ) : void
		{			
			trace("result");
			var panchkarmaList:ArrayCollection = event.result as ArrayCollection;
			trace("result lebgth "+panchkarmaList.length);
			ModelLocatorImp.getInstance().panchkarmaList = panchkarmaList;
		}
				
		public function fault( event : Object ) : void
		{
			Alert.show("A problem has occured on the server side. Please contact the technical person " + event);
			//Need to build a Error Frasmework class
		}

	}
}