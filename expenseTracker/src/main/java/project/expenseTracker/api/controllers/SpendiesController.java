package project.expenseTracker.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import project.expenseTracker.business.abstracts.SpendService;

@RestController
@CrossOrigin
@RequestMapping("/api/spends/")
public class SpendiesController {

	
	private SpendService spendService;

	@Autowired
	public SpendiesController(SpendService spendService) {
		super();
		this.spendService = spendService;
	}
}
