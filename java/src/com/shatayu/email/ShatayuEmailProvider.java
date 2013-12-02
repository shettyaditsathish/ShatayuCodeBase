package com.shatayu.email;

import java.util.Properties;

public class ShatayuEmailProvider extends EmailProvider{
	private static final String SMTP_HOST_NAME = "mail.shatayurved.com";
	private static final String SMTP_PORT = "25";
	//private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	
	public String getFromAddresss() {
		return "drbhagyashree-shatayurved@shatayu.com";
	}

	
	public String getPassword() {
		return "a1d1i1t1";
	}
	
	
	public String getUserName() {
		return "drbhagyashree-shatayurved";
	}

	
	public String getDomain() {
		return "shatayurved.com";
	}

	
	public Properties getSendProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		return props;
	}

	
	public String getRecieveProtocol() {
		return "pop3";
	}

	
	public String getRecieveProtocolUrl() {
		return "mail.shatayurved.com";
	}

	
}
