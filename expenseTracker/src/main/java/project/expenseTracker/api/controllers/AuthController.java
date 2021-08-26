package project.expenseTracker.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.expenseTracker.business.abstracts.AuthService;
import project.expenseTracker.entities.auth.AuthResponse;
import project.expenseTracker.entities.auth.Credentials;

@RestController
@CrossOrigin
@RequestMapping("/api/auth/")
public class AuthController {


	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	
	@PostMapping("auth")
	public AuthResponse  handleAuthenticate(@RequestBody Credentials credentials) {
		return this.authService.authenticate(credentials);
	
	}
	
}
