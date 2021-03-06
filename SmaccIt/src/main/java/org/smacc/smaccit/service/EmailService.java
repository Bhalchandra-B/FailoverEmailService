package org.smacc.smaccit.service;

import javax.mail.internet.MimeMessage;

import org.smacc.smaccit.domain.EmailModel;
import org.smacc.smaccit.exception.EmailException;
import org.springframework.stereotype.Service;

/**
 * This is interface for . It prepares email as perinput given by front end and
 * send.
 * 
 * @author Bhalchandra Bingewar (brbingewar@gmail.com)
 *
 */
@Service
public interface EmailService {

	/**
	 * This method sends email though selected email service provider
	 * 
	 * @param emailModel
	 * @return boolean whether email is sent ot not
	 * @throws Exception
	 */
	public boolean sendMails(EmailModel emailModel) throws Exception;

	/**
	 * This method prepares MimeMessage based on the input given by front end
	 * 
	 * @param emailmodel
	 * @param mimeMessage
	 * @return MimeMessage
	 * @throws EmailException
	 */
	public MimeMessage createEmail(EmailModel emailmodel, MimeMessage mimeMessage) throws EmailException;
}