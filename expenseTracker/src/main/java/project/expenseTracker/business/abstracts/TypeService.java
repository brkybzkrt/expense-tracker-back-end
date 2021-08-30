package project.expenseTracker.business.abstracts;

import java.util.List;

import project.expenseTracker.core.utilities.results.DataResult;
import project.expenseTracker.core.utilities.results.Result;

import project.expenseTracker.entities.dtos.typeDtos.AddTypeDto;
import project.expenseTracker.entities.dtos.typeDtos.GetTypeDto;

public interface TypeService {

	
	Result add(AddTypeDto type);
	
	DataResult<List<GetTypeDto>> getAll();
}
