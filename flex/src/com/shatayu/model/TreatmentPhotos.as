package com.shatayu.model
{
	import flash.utils.ByteArray;
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.TreatmentPhotos")]
	public class TreatmentPhotos
	{
		public var treatmentPhotosId:Number;
		public var description:String;
		public var imageData:ByteArray;
		public var treatment:Treatment;
	}
}