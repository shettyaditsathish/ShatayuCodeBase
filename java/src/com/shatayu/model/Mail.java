package com.shatayu.model;

import java.util.Date;

public class Mail {
	public String subject;
	public String mailContent;
	public Date recievedDate;
	public String fromAddress;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMailContent() {
		return mailContent;
	}
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	public Date getRecievedDate() {
		return recievedDate;
	}
	public void setRecievedDate(Date recievedDate) {
		this.recievedDate = recievedDate;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
}