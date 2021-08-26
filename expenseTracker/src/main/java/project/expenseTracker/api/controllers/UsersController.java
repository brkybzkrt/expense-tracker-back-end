package project.expenseTracker.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.expenseTracker.business.abstracts.UserService;
import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.entities.User;

@RestController
@CrossOrigin
@RequestMapping("/api/users/")
public class UsersController {

	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping("register")
	public Result register(@RequestBody User user) {
		
		return this.userService.register(user);
	}
}
