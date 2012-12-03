package com.lazcano.alokairu.core.util.mail;


import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.InternetAddress;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.MessagingException;
import javax.activation.FileDataSource;
import javax.activation.DataHandler;

import com.lazcano.alokairu.core.model.EmailConfig;

public class EmailSender{




	public static void send(EmailConfig emailConfig, String to, String subject,String text,String file) throws MessagingException{	

	// create a message

	Session session=GmailSession.getInstance(emailConfig);	
     
        MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(emailConfig.getSender()));
      InternetAddress[] address = {new InternetAddress(to)};
      msg.setRecipients(Message.RecipientType.TO, address);
      msg.setSubject(subject);
      
      // create and fill the first message part
      MimeBodyPart mbp1 = new MimeBodyPart();
      mbp1.setText(text);
      
      Multipart mp = new MimeMultipart();
      mp.addBodyPart(mbp1);

      // attach the file to the message
      if (file!=null){
      	MimeBodyPart mbp2 = new MimeBodyPart();
      	FileDataSource fds = new FileDataSource(file);
     	mbp2.setDataHandler(new DataHandler(fds));
      	mbp2.setFileName(fds.getName());
      	mp.addBodyPart(mbp2);
      }

      // add the Multipart to the message
      msg.setContent(mp);

      // set the Date: header
      msg.setSentDate(new Date());
      
      // send the message
      Transport.send(msg);
	
	}
}
