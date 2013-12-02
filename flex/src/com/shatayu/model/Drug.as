package com.shatayu.model
{
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.Drug")]
	public class Drug
	{
		
		
		public var drugId:Number;
		public var drugName:String;
		public var drugCost:Number;
		public var drugContent:String;
		public var quantity:Number;
		public var details:String;

	}
}