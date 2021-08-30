package project.expenseTracker.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.expenseTracker.business.abstracts.TypeService;
import project.expenseTracker.core.utilities.results.DataResult;
import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.entities.dtos.typeDtos.AddTypeDto;
import project.expenseTracker.entities.dtos.typeDtos.GetTypeDto;

@RestController
@CrossOrigin
@RequestMapping("/api/types/")
public class TypesController {

	
	private TypeService typeService;

	@Autowired
	public TypesController(TypeService typeService) {
		super();
		this.typeService = typeService;
	}
	
	
	@GetMapping("getAll")
	public DataResult<List<GetTypeDto>> getAll(){
		
		return this.typeService.getAll();
	}
	
	
	@PostMapping("add")
	public Result add(@RequestBody AddTypeDto type) {
		
		return this.typeService.add(type);
	}
}
