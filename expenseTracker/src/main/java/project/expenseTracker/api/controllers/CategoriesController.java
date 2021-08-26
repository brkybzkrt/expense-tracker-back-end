package project.expenseTracker.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.expenseTracker.business.abstracts.CategoryService;
import project.expenseTracker.core.utilities.results.DataResult;
import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.entities.Category;
import project.expenseTracker.entities.dtos.categoryDtos.AddCategoryDto;
import project.expenseTracker.entities.dtos.categoryDtos.UpdateCategoryDto;

@RestController
@CrossOrigin
@RequestMapping("/api/categories/")
public class CategoriesController {

	
	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Category>> getAll() {
		return this.categoryService.getAll();
	}
	
	@PostMapping("addCategory")
	public Result add(@RequestBody AddCategoryDto addCategory) {
		return this.categoryService.add(addCategory);
	}
	
	@DeleteMapping("deleteCategory")
	public Result delete(@RequestBody Category category) {
		return this.categoryService.delete(category);
	}
	
	
	@PutMapping("updateCategory")
	public Result update(@RequestBody UpdateCategoryDto updateCategory) {
		return this.categoryService.update(updateCategory);
	}
}
