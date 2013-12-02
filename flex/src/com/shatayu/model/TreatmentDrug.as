package com.shatayu.model
{
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.TreatmentDrug")]
	public class TreatmentDrug
	{
		public var treatmentDrugId:Number;
		public var treatment:Treatment;
		public var drugId:Number;
		public var duration:String;
		public var noOfDays:Number;
	}
}