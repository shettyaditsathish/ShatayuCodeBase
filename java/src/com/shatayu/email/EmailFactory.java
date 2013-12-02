package com.shatayu.email;

public class EmailFactory {
	private EmailFactory(){}
	public static EmailFactory emf ;
	public static String GMAIL_EMAIL_PROVIDER = "gmail";
	public static String SHATAYU_EMAIL_PROVIDER = "shatayu";
	
	public static EmailFactory getInstance(){
		if(emf == null)
			emf = new EmailFactory();
		return emf;
	}
	
	public EmailProvider getEmailProvider(String emailProviderName){
		if(emailProviderName.equals(GMAIL_EMAIL_PROVIDER))
			return new GmailEmailProvider();
		else if(emailProviderName.equals(SHATAYU_EMAIL_PROVIDER)){
			return new ShatayuEmailProvider();
		}else{
			return null;
		}
	}
}
