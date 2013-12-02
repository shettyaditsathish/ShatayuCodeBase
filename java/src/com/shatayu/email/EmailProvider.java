package com.shatayu.email;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.Flags.Flag;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

import com.shatayu.model.Mail;

public abstract class EmailProvider {
	
	Folder inbox;
	
	abstract public String 	getFromAddresss();
	abstract public String getUserName();
	abstract public String getPassword();
	abstract public String getDomain();
	abstract public String getRecieveProtocol();
	abstract public String getRecieveProtocolUrl();
	abstract public Properties getSendProperties();
	
	public String sendMail(List<String> toAddressP,String subjectP,String mailContentP){
		try {
			
		    Session sendSession = Session.getDefaultInstance(getSendProperties(),
					 new javax.mail.Authenticator() {

					 protected PasswordAuthentication getPasswordAuthentication() {
					 return new PasswordAuthentication(getUserName()+"@"+getDomain(), getPassword());
					 }
					 });
		    sendSession.setDebug(true);
			
		    // create a message
		    Message msg = new MimeMessage(sendSession);
	
		    // set the from and to address
		    InternetAddress addressFrom;
			
			addressFrom = new InternetAddress(getFromAddresss());
			
		    msg.setFrom(addressFrom);		   
		    			
		    // Optional : You can also set your custom headers in the Email if you Want
		    msg.addHeader("MyHeaderName", "myHeaderValue");
		   
		    String subject = subjectP;
		    
		    Object[] fromAddressArr = toAddressP.toArray();
		    InternetAddress[] addressTo = new InternetAddress[fromAddressArr.length]; 
		    //System.out.println(fromAddressArr[1]);
		    for (int i = 0; i < fromAddressArr.length; i++)
		    {
		        addressTo[i] = new InternetAddress((String)fromAddressArr[i]);
		    }
		    msg.setRecipients(Message.RecipientType.TO, addressTo);
		    
		    // Setting the Subject and Content Type
		    msg.setSubject(subject);
		    msg.setContent(mailContentP, "text/plain");
		  
		    Transport.send(msg);
	
		    return "success";
		} catch (AddressException e) {
			e.printStackTrace();
			return "fail";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	public List<Mail> recieveMail(){
		 try
		 {
			
			 Session session = Session.getInstance(new Properties());
			     
				 
			 Store recieveStore = session.getStore(getRecieveProtocol());
		     recieveStore.connect(getRecieveProtocolUrl(),getUserName(), getPassword());
			 
			 
			 /*  Mention the folder name which you want to read. */
			 inbox = recieveStore.getFolder("Inbox");
			 System.out.println("No of Unread Messages : " + inbox.getNewMessageCount());
	
			 /*Open the inbox using store.*/
			 inbox.open(Folder.READ_ONLY);
	
			 /*  Get the messages which is unread in the Inbox*/
			 Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
	
			 /* Use a suitable FetchProfile    */
			 FetchProfile fp = new FetchProfile();
			 fp.add(FetchProfile.Item.ENVELOPE);
			 fp.add(FetchProfile.Item.CONTENT_INFO);
			 inbox.fetch(messages, fp);
	
			 
			 System.out.println(" Mesage length  "+messages.length);
			 List<Mail> msgList = printAllMessages(messages);
			 inbox.close(true);
			 recieveStore.close();
			 return msgList;
			
		 }catch (NoSuchProviderException e){
			 e.printStackTrace();
			 return null;
		 }catch (MessagingException e){
			 e.printStackTrace();
			 return null;
		 }catch (Exception ex){
			 System.out.println("Exception arise at the time of read mail");
			 return null;
		 }
	}

	protected List<Mail> printAllMessages(Message[] msgs) throws Exception
	{
		List<Mail> msgList = new ArrayList<Mail>();
		for (int i = 0; i < msgs.length; i++)
		{
			System.out.println("MESSAGE #" + (i + 1) + ":");
			msgList.add(printEnvelope(msgs[i]));
		}
		
		return msgList;
	}
	
	/*  Print the envelope(FromAddress,ReceivedDate,Subject)  */
	protected Mail printEnvelope(Message message) throws Exception
	{
		Address[] a;
		// FROM
		String fromAddress = "";
		if ((a = message.getFrom()) != null)
		{
			for (int j = 0; j < a.length; j++)
			{
				System.out.println("FROM: " + ((Address)(a[j])).toString());
				if(a.length == (j -1))
					fromAddress = fromAddress + ((Address)(a[j])).toString();
				else{
					fromAddress = fromAddress + ((Address)(a[j])).toString() + ";";
				}
			}
		}
		// TO
		if ((a = message.getRecipients(Message.RecipientType.TO)) != null)
		{
			for (int j = 0; j < a.length; j++)
			{
				System.out.println("TO: " + a[j].toString());
			}
		}
		String subject = message.getSubject();
		//Date receivedDate = message.getReceivedDate();
		String content = message.getContent().toString();
		System.out.println("Subject : " + subject);
		System.out.println("Received Date : " + message.getSentDate());
		System.out.println("Content : " + content);
		if(content.indexOf("javax.mail.internet.MimeMultipart") == 0)
			content = getContent(message);
		Mail mail = new Mail();
		mail.setMailContent(content);
		mail.setRecievedDate(message.getSentDate());
		mail.setSubject(subject);
		mail.setFromAddress(fromAddress);
		return mail;
	}
	
	protected String getContent(Message msg)
	{
		try
		{
			String contentType = msg.getContentType();
			System.out.println("Content Type : " + contentType);
			Multipart mp = (Multipart) msg.getContent();
			int count = mp.getCount();
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < count; i++)
			{
				buff.append(dumpPart(mp.getBodyPart(i)));
			}
			return buff.toString();
		}catch (Exception ex){
			System.out.println("Exception arise at get Content");
			ex.printStackTrace();
			return null;
		}
	}
	
	protected String dumpPart(Part p) throws Exception
	{
	// Dump input stream ..
		InputStream is = p.getInputStream();
		// If "is" is not already buffered, wrap a BufferedInputStream
		// around it.
		if (!(is instanceof BufferedInputStream)){
			is = new BufferedInputStream(is);
		}
		
		int c;
		System.out.println("Message : ");
		StringBuffer buf = new StringBuffer();
		while ((c = is.read()) != -1){
			System.out.write(c);
			buf.append((char)c);
		}
		
		return buf.toString();
	}
	
	
	
}
