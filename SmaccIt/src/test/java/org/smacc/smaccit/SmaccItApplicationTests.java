package org.smacc.smaccit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.net.ServerSocket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.subethamail.wiser.Wiser;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SmaccItApplication.class)
@WebAppConfiguration
public class SmaccItApplicationTests {

	private Wiser wiser;

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		wiser = new Wiser();
		wiser.setPort(findAvailablePort(1025, 65536));
		wiser.start();
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@After
	public void tearDown() throws Exception {
		wiser.stop();
	}

	@Test
	public void testSendMails() throws Exception {

		mockMvc.perform(get("/")).andExpect(status().is2xxSuccessful());

		// assertRe
	}

	private static int findAvailablePort(int min, int max) {
		for (int port = min; port < max; port++) {
			try {
				new ServerSocket(port).close();
				return port;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		throw new IllegalStateException("Could not find available port in range " + min + " to " + max);
	}
}
