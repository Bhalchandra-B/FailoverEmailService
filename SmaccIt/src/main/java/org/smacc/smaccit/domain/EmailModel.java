package org.smacc.smaccit.domain;

import javax.validation.constraints.NotNull;

/**
 * This is model class for Email Entity
 * 
 * @author Bhalchandra Bingewar (brbingewar@gmail.com)
 *
 */
public class EmailModel {

	@NotNull
	private String sendTo;

	@NotNull
	private String from;

	private String emailBody;

	private String subject;

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
