package org.smacc.smaccit.service.impl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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
 * This is concrete implementation of EmailService interface. It prepares and
 * send email message as per input given by front end.
 * 
 * @author Bhalchandra Bingewar (brbingewar@gmail.com)
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);
	private boolean isEmailSent = false;

	@Autowired
	private JavaMailSenderImpl mailgunService;

	@Autowired
	private JavaMailSender sendgridService;

	@Override
	public boolean sendMails(EmailModel emailmodel) throws EmailException {

		MimeMessage message = mailgunService.createMimeMessage();
		message = createEmail(emailmodel, message);
		if (message != null) {
			try {
				mailgunService.send(message);
				// isEmailSent = true;
				LOG.info("Email sent via MailGun");
				return true;
			} catch (MailException e) {
				LOG.info("Unable to send email using MailGun service. Recepints address is not found in mailing list"
						+ e.getMessage());
			}

			if (!isEmailSent) {
				try {
					sendgridService.send(message);
					isEmailSent = true;
					LOG.info("Email sent via SendGrid");
					return true;
				} catch (MailException e) {
					LOG.info("Unable to send email using SendGrid service" + e.getMessage());
					throw new EmailException("Unable to send email...");
				}
			}
		} else {
			LOG.debug("Message failed to send");
		}
		return false;
	}

	@Override
	public MimeMessage createEmail(EmailModel emailmodel, MimeMessage message) throws EmailException {

		if (isValidEmailAddress(emailmodel.getSendTo()) && isValidEmailAddress(emailmodel.getFrom())) {
			try {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailmodel.getSendTo()));
				message.setText(emailmodel.getEmailBody());
				message.setSubject(emailmodel.getSubject());
				message.setFrom(emailmodel.getFrom());
				LOG.info("Email header and content are inserted");
				return message;
			} catch (MessagingException e) {
				LOG.info("Unable to set details of message " + e.getMessage());
				throw new EmailException("Unable to set message details");
			}
		} else {
			LOG.info("Email address are not in format");
			return null;
		}
	}

	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}
}