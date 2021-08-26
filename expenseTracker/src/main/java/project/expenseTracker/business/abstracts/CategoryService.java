package project.expenseTracker.business.abstracts;

import java.util.List;

import project.expenseTracker.core.utilities.results.DataResult;
import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.entities.Category;
import project.expenseTracker.entities.dtos.categoryDtos.AddCategoryDto;
import project.expenseTracker.entities.dtos.categoryDtos.UpdateCategoryDto;

public interface CategoryService {

	DataResult<List<Category>> getAll();
	
	Result add(AddCategoryDto addCategory);
	
	Result delete(Category category);
	
	Result update(UpdateCategoryDto updateCategory);
}
