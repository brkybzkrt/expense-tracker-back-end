package project.expenseTracker.business.concretes;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import project.expenseTracker.business.abstracts.EmailMessageService;
import project.expenseTracker.core.utilities.modelMapper.ModelMapperConverterService;
import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.core.utilities.results.SuccessResult;
import project.expenseTracker.dataAccess.abstracts.EmailMessageDao;
import project.expenseTracker.entities.EmailMessage;
import project.expenseTracker.entities.dtos.emailDtos.AddEmailMessageDto;

@Service
public class EmailMessageManager implements EmailMessageService{

	private final String ourMail="myMail";
	
	private JavaMailSender javaMailSender;
	private EmailMessageDao emailMessageDao;
	private ModelMapperConverterService modelMapperConverterService;
	
	@Autowired
	public EmailMessageManager(EmailMessageDao emailMessageDao,JavaMailSender javaMailSender, ModelMapperConverterService modelMapperConverterService) {
		super();
		this.emailMessageDao=emailMessageDao;
		this.javaMailSender = javaMailSender;
		this.modelMapperConverterService= modelMapperConverterService;
	}

	@Override
	public Result sendEmail(AddEmailMessageDto emailMessage) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(emailMessage.getUserEmail());
		message.setTo(ourMail);
		message.setText(emailMessage.getText());
		message.setSubject(emailMessage.getHeader());
		
		javaMailSender.send(message);
		
		EmailMessage sendedEmail= (EmailMessage) this.modelMapperConverterService.converterFromDtoToClass(emailMessage, EmailMessage.class);
		sendedEmail.setAddress(emailMessage.getUserEmail());
		this.emailMessageDao.save(sendedEmail);
		return new SuccessResult("mail başarıyla gönderildi.");
		
	}

}
