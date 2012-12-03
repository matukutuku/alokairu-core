package com.lazcano.alokairu.core.util.mail;

import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import com.lazcano.alokairu.core.model.EmailConfig;


public class GmailSession{

	private GmailSession(){
	
	}

	public static Session getInstance(final EmailConfig emailConfig){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailConfig.getSender(), emailConfig.getPasswd());
			}
		  });
		return session;
		
	}
}
