package project.expenseTracker.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.expenseTracker.business.abstracts.EmailMessageService;
import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.entities.dtos.emailDtos.AddEmailMessageDto;

@RestController
@RequestMapping("/api/mails/")
public class EmailMessagesController {

	
	private EmailMessageService emailMessageService;

	@Autowired
	public EmailMessagesController(EmailMessageService emailMessageService) {
		super();
		this.emailMessageService = emailMessageService;
	}
	
	
	@PostMapping("send")
	public Result sendEmail(@RequestBody AddEmailMessageDto emailMessage) {
		
		return this.emailMessageService.sendEmail(emailMessage);
	}
}
