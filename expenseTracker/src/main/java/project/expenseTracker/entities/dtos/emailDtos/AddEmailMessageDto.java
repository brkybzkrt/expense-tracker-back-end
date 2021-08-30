package project.expenseTracker.entities.dtos.emailDtos;





import lombok.Data;

@Data
public class AddEmailMessageDto {

	
	private int id;
	
	private int userId;
	
	private String userEmail;
	
	private String text;
	
	private String header;
	
	
}
