package project.expenseTracker.entities.auth;

import lombok.Data;


@Data
public class AuthResponse {

	private String token;
	
	private GetUser user;

	public AuthResponse(String token, GetUser user) {
		super();
		this.token = token;
		this.user = user;
	}
	
	
}
