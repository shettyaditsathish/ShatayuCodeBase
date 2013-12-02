package com.shatayu.event
{
	
	
	import flash.events.Event;
	
	public class ViewEvent extends Event
	{
		public var viewDataHolder:ViewDataHolder
		public function ViewEvent(type:String, dataHolder:ViewDataHolder,bubbles:Boolean = false, cancelable:Boolean = false){
			super(type, bubbles, cancelable);
			viewDataHolder = dataHolder;
		}
		
		

	}
}