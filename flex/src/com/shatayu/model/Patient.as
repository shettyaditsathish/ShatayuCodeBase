package com.shatayu.model
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.Patient")]
	public class Patient
	{
		public var patientId:Number;
		public var firstName:String;
		public var lastName:String;
		public var middleName:String;
		public var age:Number;
		public var sex:String;
		public var address:String;
		public var initialDate:Date;
		public var mobile1:String;
		public var mobile2:String;
		public var landline:String;
		public var knownCases:String;
		public var history:String;
		public var treatment:ArrayCollection;
		public var panchkarmaTreatment:ArrayCollection;

	}
}