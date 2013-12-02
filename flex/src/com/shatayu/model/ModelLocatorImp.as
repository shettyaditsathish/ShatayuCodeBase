package com.shatayu.model
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	public class ModelLocatorImp{
		private static var modelLocator : ModelLocatorImp;
		public var drugList:ArrayCollection;
		public var panchkarmaList:ArrayCollection;
		public static function getInstance() : ModelLocatorImp 
		{
			if ( modelLocator == null )
				modelLocator = new ModelLocatorImp();
				
			return modelLocator;
	   }
	   
	   	public function ModelLocatorImp(){
	   		if ( ModelLocatorImp.modelLocator != null )
					throw new Error( "Only one ModelLocator instance should be instantiated" );	
	   	}
	}
}