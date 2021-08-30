package project.expenseTracker.business.abstracts;


import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.entities.dtos.emailDtos.AddEmailMessageDto;

public interface EmailMessageService {

	
	Result sendEmail(AddEmailMessageDto emailMessage);
}
