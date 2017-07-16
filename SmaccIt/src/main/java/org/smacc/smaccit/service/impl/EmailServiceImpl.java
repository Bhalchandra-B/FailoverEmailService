package org.smacc.smaccit.service.impl;

import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smacc.smaccit.domain.EmailModel;
import org.smacc.smaccit.exception.EmailException;
import org.smacc.smaccit.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * This is concrete implementation of EmailService interface. It prepares email
 * as perinput given by front end and send.
 * 
 * @author Bhalchandra
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);
	public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	private boolean isEmailSent = false;

	@Autowired
	private JavaMailSenderImpl mailgunService;

	@Autowired
	private JavaMailSender sendgridService;

	@Override
	public void sendMails(EmailModel emailmodel) throws EmailException {

		MimeMessage message = mailgunService.createMimeMessage();
		createMimeMessage(emailmodel, message);
		try {
			mailgunService.send(message);
			// isEmailSent = true;
			LOG.info("Email sent via MailGun");
		} catch (MailException e) {
			LOG.debug("Unable to send email using MailGun service" + e.getMessage());
			e.printStackTrace();
		}

		if (!isEmailSent) {
			try {
				sendgridService.send(message);
				isEmailSent = true;
				LOG.info("Email sent via SendGrid");
			} catch (MailException e) {
				LOG.debug("Unable to send email using SendGrid service" + e.getMessage());
				e.printStackTrace();
				throw new EmailException("Unable to send email...");
			}
		}
	}

	@Override
	public MimeMessage createMimeMessage(EmailModel emailmodel, MimeMessage message) throws EmailException {
		try {
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailmodel.getSendTo()));
			message.setText(emailmodel.getEmailBody());
			message.setSubject(emailmodel.getSubject());
			message.setFrom(emailmodel.getFrom());
			LOG.info("Email header and content are inserted");
			return message;
		} catch (MessagingException e) {
			LOG.debug("Unable to set details of message " + e.getMessage());
			throw new EmailException("Unable to set message details");
		}
	}
}