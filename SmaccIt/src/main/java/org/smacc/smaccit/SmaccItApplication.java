package org.smacc.smaccit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This spring boot application is email service that has failover capability.
 * It uses two email service provider, MailGun and SendGrid.
 * 
 * @author Bhalchandra Bingewar (brbingewar@gmail.com)
 *
 */
@SpringBootApplication
public class SmaccItApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmaccItApplication.class, args);
	}
}
