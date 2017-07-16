package org.smacc.smaccit.controllers;

import org.smacc.smaccit.domain.EmailModel;
import org.smacc.smaccit.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class to get access API for sendng mails. 'Thymeleaf' template
 * engine has been used to render the front end.
 * 
 * @author Bhalchandra Bingewar (brbingewar@gmail.com)
 *
 */
@Controller
public class EmailServiceControllers {

	@Autowired
	private EmailService emailService;

	/**
	 * This method initiates a front end on requesting root path of address
	 * 
	 * @param model
	 * @return name of template name to render front end
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("create", new EmailModel());
		return "create";
	}

	/**
	 * 
	 * @param emailModel
	 *            - object of EmailModel class
	 * @return Name of template of mail sent successfully
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public String sendMail(@ModelAttribute EmailModel emailModel) throws Exception {
		if (emailService.sendMails(emailModel))
			return "success";
		else
			return "failure";
	}
}
