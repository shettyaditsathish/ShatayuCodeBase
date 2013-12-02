package com.shatayu.model
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.Treatment")]
	public class Treatment
	{
		public var treatmentId:Number;
		public var patient:Patient;
		public var treatmnetDate:Date;
		public var signsSymptons:String;
		public var results:String;
		public var tongue:String;
		public var pulse:String;
		public var treatmentDrug:ArrayCollection;
		public var paid:String;
		//public var cost:Number;
		public var paymentType:String;
		public var amountPaid:Number;
		public var balance:Number;
	

	}
}