package org.smacc.smaccit.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * This is model class for Email Entity
 * 
 * @author Bhalchandra
 *
 */
public class EmailModel {

	@NotNull
	@Email
	private String sendTo;

	@NotNull
	@Email
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
