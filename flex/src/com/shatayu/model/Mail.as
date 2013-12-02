package com.shatayu.model
{
	[Bindable]
	[RemoteClass(alias="com.shatayu.model.Mail")]
	public class Mail
	{
		public var subject:String;
		public var mailContent:String;
		public var recievedDate:Date;
		public var fromAddress:String;
	}
}