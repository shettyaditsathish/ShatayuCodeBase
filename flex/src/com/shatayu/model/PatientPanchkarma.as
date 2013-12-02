package com.shatayu.model
{
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.PatientPanchkarma")]
	public class PatientPanchkarma
	{
		public var patientPanchId:Number;
		public var panchkarmaId:Number;
		public var patient:Patient;
		public var startDate:Date;
		public var endDate:Date;
		public var results:String;
		public var paid:String;
		public var paymentType:String;
		public var amountPaid:Number;
		public var balance:Number;
		//public var cost:Number;
	}
}