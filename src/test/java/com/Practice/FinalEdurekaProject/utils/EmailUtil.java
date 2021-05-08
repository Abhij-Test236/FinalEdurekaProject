package com.Practice.FinalEdurekaProject.utils;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

public class EmailUtil {

	@Test
	public void sendEmail() {

		Date date = java.util.Calendar.getInstance().getTime();

		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.starttls.enable", "true");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication("jaiswalabhishek235@gmail.com", "Test@123");

					}

				});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("jaiswalabhishek235@gmail.com"));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse("@mindtree.com,@mindtree.com,@mindtree.com"));

			// Add the subject link
			message.setSubject("Test-report");

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText("Hi,\n" + "The Test scripts written for project were executed on "
					+ date + " and the report was generated.\n" + "PFA: Log file, Extent report\n\n" + "Regards,\n"
					+ "Abhishek\n");

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename2 = "./ExtentReport.html";

			// Create data source and pass the filename
			DataSource source2 = new FileDataSource(filename2);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source2));

			// set the file name
			messageBodyPart2.setFileName("ExtentReport.pdf");

			// Create another object to add another content
			MimeBodyPart messageBodyPart3 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename3 = "./log/TestLogs.html";

			// Create data source and pass the filename
			DataSource source3 = new FileDataSource(filename3);

			// set the handler
			messageBodyPart3.setDataHandler(new DataHandler(source3));

			// set the file name
			messageBodyPart3.setFileName("TestLogs.html");

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart1);

			// add body part 2
			multipart.addBodyPart(messageBodyPart2);

			// add body part 3
			multipart.addBodyPart(messageBodyPart3);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}
}
