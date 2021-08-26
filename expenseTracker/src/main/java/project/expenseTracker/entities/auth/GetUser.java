package project.expenseTracker.entities.auth;

import lombok.Data;
import project.expenseTracker.entities.User;

@Data
public class GetUser {

	private int id;
	private String FirstName;
	private String LastName;
	private String Email;
	
	
	public GetUser(User user) {
		this.setId(user.getId());
		this.setEmail(user.getEmail());
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
	}
	
}
