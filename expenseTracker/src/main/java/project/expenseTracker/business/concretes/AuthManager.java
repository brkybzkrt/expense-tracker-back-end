package project.expenseTracker.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import project.expenseTracker.business.abstracts.AuthService;
import project.expenseTracker.business.abstracts.UserService;
import project.expenseTracker.entities.User;
import project.expenseTracker.entities.auth.AuthResponse;
import project.expenseTracker.entities.auth.Credentials;
import project.expenseTracker.entities.auth.GetUser;


@Service
public class AuthManager implements AuthService{
	private static final int time=5*60*1000;
	
	private UserService userService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
		this.passwordEncoder= new BCryptPasswordEncoder();
	}

	
	
	@Override
	public AuthResponse authenticate(Credentials credentials) {
		User inDB = this.userService.getByEmail(credentials.getEmail());
		boolean matches= this.passwordEncoder.matches(credentials.getPassword(),inDB.getPassword());
		
		if(matches) {
			GetUser user = new GetUser(inDB);
			String token = Jwts.builder().setSubject(" "+inDB.getId()).signWith(SignatureAlgorithm.HS512, "top-secret-key").compact();
			
			 AuthResponse response=  new AuthResponse(token,user);
			 return response;
		}
		return null;
		
	}

}
//.setExpiration(new Date(System.currentTimeMillis()+time))