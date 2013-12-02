package com.shatayu.model
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.Organiser")]
	public class Organiser
	{
		public var organiserId:Number;
		public var panchkarmaId:Number;
		public var treatmentDetails:String;
		public var startDate:Date;
		public var endDate:Date;
		public var paid:String;
		public var apptType:String;
		public var patient:Patient;
		public var appointment:ArrayCollection;
		public var status:String;
		public var amountPaid:Number;
		public var balance:Number;
	}
}