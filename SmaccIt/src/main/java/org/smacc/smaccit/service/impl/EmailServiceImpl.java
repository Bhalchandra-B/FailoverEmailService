package org.smacc.smaccit.service.impl;

import javax.mail.internet.MimeMessage;

import org.smacc.smaccit.domain.EmailModel;
import org.smacc.smaccit.exception.EmailException;
import org.smacc.smaccit.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendMails(EmailModel emailModel) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public MimeMessage createMimeMessage(EmailModel emailmodel, MimeMessage message) throws EmailException {
		// TODO Auto-generated method stub
		return null;
	}

}
