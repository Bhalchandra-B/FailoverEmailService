package org.smacc.smaccit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.smacc.smaccit.domain.EmailModel;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceImplTest {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSendMails() throws Exception {
		EmailModel emailModel = new EmailModel();
		emailModel.setSendTo("scotttiger000@gmail.com");
		emailModel.setFrom("abc@gmail.com");
		emailModel.setSubject("Unit test subject");
		emailModel.setEmailBody("Hello Unit Test");

		// emailService.sendMails(emailModel);

	}
}
