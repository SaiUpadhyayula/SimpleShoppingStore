package com.dota2.store.mails;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;

public class Mailer {

	private static String	fromAddress	= "usssai@gmail.com";
	private static String	subject		= "Dota2Store Registration Confirmation Mail";

	public void setPropsAndSendEmail(String emailRecipient, String emailText) {
		try {

			Properties sessionProperties = new Properties();
			sessionProperties.put("mail.smtp.auth", "true");
			sessionProperties.put("mail.smtp.host", "smtp.gmail.com");
			sessionProperties.put("mail.smtp.port",465);
			sessionProperties.put("mail.smtp.socketFactory.port","465");
			sessionProperties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

			MailAuthenticator authentificatorForMessage = new MailAuthenticator();
			Session session = Session.getInstance(sessionProperties, authentificatorForMessage);

			Message emailMessage = new MimeMessage(session);
			emailMessage.setFrom(new InternetAddress(fromAddress));
			emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailRecipient, false));
			emailMessage.setSubject(subject);
			emailMessage.setSentDate(new Date());
			emailMessage.setText(emailText);
			Transport.send(emailMessage);
			System.out.println("Your email to " + emailRecipient + " has been sent successfully");
		} catch (Exception e) {
			System.out.println("Your email to " + emailRecipient + "  has not been sent: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
