package org.smacc.smaccit.service;

import javax.mail.internet.MimeMessage;

import org.smacc.smaccit.domain.EmailModel;
import org.smacc.smaccit.exception.EmailException;
import org.springframework.stereotype.Service;

/**
 * This is interface for . It prepares email as perinput given by front end and
 * send.
 * 
 * @author Bhalchandra
 *
 */
@Service
public interface EmailService {

	/**
	 * This method sends email though selected email service provider
	 * 
	 * @param emailModel
	 *            -
	 * @throws Exception
	 */
	public void sendMails(EmailModel emailModel) throws Exception;

	/**
	 * This method prepares email model object based on the input given by front
	 * end
	 * 
	 * @param emailmodel
	 * @param message
	 * @return
	 * @throws EmailException
	 */
	public MimeMessage createMimeMessage(EmailModel emailmodel, MimeMessage message) throws EmailException;

}
