package com.epam.lab.buyit.controller.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class EmailSender {

	private static final Logger LOGGER = Logger.getLogger(EmailSender.class);
	private static final String username;
	private static final String password;
	private static final Properties props;
	private static final String emailPropFilePath = "email.properties";

	static {
		props = new Properties();
		try {
			props.load(EmailSender.class.getClassLoader().getResourceAsStream(emailPropFilePath));
		} catch (IOException e) {
			LOGGER.error(e);
		}
		password = props.getProperty("mail.password");
		username = props.getProperty("mail.user");

	}

	public static void sendHtml(String subject, String text, String toEmail) {
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmail));
			message.setSubject(subject);

			message.setContent(text, "text/html");

			Transport.send(message);

			System.out.println("Ok");
		} catch (MessagingException e) {
			LOGGER.warn(e);
		}
	}

}
