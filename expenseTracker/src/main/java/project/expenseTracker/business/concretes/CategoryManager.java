package project.expenseTracker.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.expenseTracker.business.abstracts.CategoryService;
import project.expenseTracker.core.utilities.modelMapper.ModelMapperConverterService;
import project.expenseTracker.core.utilities.results.DataResult;
import project.expenseTracker.core.utilities.results.ErrorResult;
import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.core.utilities.results.SuccessDataResult;
import project.expenseTracker.core.utilities.results.SuccessResult;
import project.expenseTracker.dataAccess.abstracts.CategoryDao;
import project.expenseTracker.entities.Category;
import project.expenseTracker.entities.dtos.categoryDtos.AddCategoryDto;
import project.expenseTracker.entities.dtos.categoryDtos.UpdateCategoryDto;

@Service
public class CategoryManager implements CategoryService {

	
	private CategoryDao categoryDao;
	private ModelMapperConverterService modelMapperConverterService;

	@Autowired
	public CategoryManager(CategoryDao categoryDao,ModelMapperConverterService modelMapperConverterService) {
		super();
		this.categoryDao = categoryDao;
		this.modelMapperConverterService=modelMapperConverterService;
	}

	@Override
	public DataResult<List<Category>> getAll() {
		return new SuccessDataResult<List<Category>>( this.categoryDao.findAll(),"Kategoriler başarıyla getirildi.");
	}

	@Override
	public Result add(AddCategoryDto addCategory) {
		Category cate= (Category) this.modelMapperConverterService.converterFromDtoToClass(addCategory, Category.class);
		
		if(this.categoryDao.existsByName(cate.getName())) {
			return new ErrorResult("Aynı isimde kategori bulunmaktadır");
		}
		else {
			this.categoryDao.save(cate);
			return new SuccessResult("Kategori başarıyla eklendi.");
		}
	}

	@Override
	public Result delete(Category category) {
		if(!this.categoryDao.existsByName(category.getName())) {
			return new ErrorResult("Kategori bulunamamaktadır");
		}
		else {
			this.categoryDao.delete(category);
			return new SuccessResult("Kategori başarıyla silindi.");
		}
	}

	@Override
	public Result update(UpdateCategoryDto updateCategory) {
		Category updCate= (Category) this.modelMapperConverterService.converterFromDtoToClass(updateCategory, Category.class);
		
		if(this.categoryDao.existsById(updCate.getId())) {
			Optional<Category> inDb = this.categoryDao.findById(updCate.getId());
			Category entityCat = inDb.get();
			entityCat.setName(updCate.getName());
			this.categoryDao.save(entityCat);
			
			return new SuccessResult("Değişiklikler başarıyla yapıldı.");
		}
		else {
			return new ErrorResult("Kategori bulunmamaktadır");}
		}
		
	}

