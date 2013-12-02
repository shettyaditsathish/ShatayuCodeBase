package com.shatayu.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	
	public class ShatayuEvent extends CairngormEvent
	{
		private var _dataLoad:Object;
		private var _callBackFunc:Function;
		
		public function get dataLoad():Object{
			return _dataLoad;
		}
		
		public function get callBackFunc():Function{
			return _callBackFunc;
		}
		 
		public function ShatayuEvent(eventName:String,dataLoad:Object,callBackFunc:Function = null)
		{
			super(eventName);
			this._dataLoad = dataLoad;
			_callBackFunc = callBackFunc;
		}
		
		

	}
}