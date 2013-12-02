package com.shatayu.model
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.Panchkarma")]
	public class Panchkarma
	{
		public var panchkarmaId:Number=0;
		public var panchkarmaName:String;
		public var cost:Number;
		public var procedure:String;
		public var diseases:String;
		public var details:String;
		public var noOfDays:Number;
		public var panchkarmaCost:ArrayCollection;
	}
}