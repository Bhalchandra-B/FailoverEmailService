package org.smacc.smaccit.exception;

/**
 * This class is exception class for handling exceptions
 * 
 * @author Bhalchandra Bingewar (brbingewar@gmail.com)
 *
 */
@SuppressWarnings("serial")
public class EmailException extends Exception {
	private String exceptionMessage;
	private String httpCode;

	public EmailException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}

	public EmailException(String exceptionMessage, String httpCode) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.httpCode = httpCode;
	}

	@Override
	public String toString() {
		return httpCode == null ? this.exceptionMessage : this.exceptionMessage + " with http code " + this.httpCode;
	}
}
