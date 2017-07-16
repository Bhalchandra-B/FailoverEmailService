package org.smacc.smaccit.factory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * This class configures email service providers related details.
 * 
 * Configuration are mentioned in resource/email.properties
 * 
 * @author Bhalchandra
 *
 */
@Configuration
@PropertySource("classpath:/email.properties")
public class EmailServiceFactory {

	/**
	 * This method configures mail sender object for MailGun service providers.
	 * Configutation are based on denoted prefix
	 * 
	 * @param None
	 * @return JavaMailSender object
	 * @see email.properties
	 */
	@Bean("mailgunService")
	@ConfigurationProperties(prefix = "mailgun.mail")
	public JavaMailSenderImpl mailGunService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		return javaMailSender;
	}

	/**
	 * This method configures mail sender object for MailGun service providers.
	 * Configutation are based on denoted prefix
	 * 
	 * @param None
	 * @return JavaMailSender object
	 * @see email.properties
	 */
	@Bean("sendgridService")
	@ConfigurationProperties(prefix = "sendgrid.mail")
	public JavaMailSenderImpl sendGridService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		return javaMailSender;
	}
}