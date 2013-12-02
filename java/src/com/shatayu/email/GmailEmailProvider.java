package com.shatayu.email;

import java.util.Properties;

public class GmailEmailProvider extends EmailProvider{
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	
	public String getPassword() {
		return "a1d1i1t1";
	}

	
	public String getUserName() {
		return "patilbbhagyashree";
	}
	
	
	public String getFromAddresss() {
		return "patilbbhagyashree@gmail.com";
	}

	
	public Properties getSendProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");
		
	    return props;
	}

	
	public String getDomain() {
		return "gmail.com";
	}

	
	public String getRecieveProtocol() {
		return "imaps";
	}

	
	public String getRecieveProtocolUrl() {
		return "imap.gmail.com";
	}

	
	
}
