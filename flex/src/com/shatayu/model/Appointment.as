package com.shatayu.model
{
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.Appointment")]
	public class Appointment
	{
		public var appointmentId:Number;
		public var apptStartDate:Date;
		public var apptEndDate:Date;
		public var apptStatus:String;
		public var organiser:Organiser;
	}
}