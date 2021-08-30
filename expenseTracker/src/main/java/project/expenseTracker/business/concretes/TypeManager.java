package project.expenseTracker.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.expenseTracker.business.abstracts.TypeService;
import project.expenseTracker.core.utilities.modelMapper.ModelMapperConverterService;
import project.expenseTracker.core.utilities.results.DataResult;
import project.expenseTracker.core.utilities.results.ErrorResult;
import project.expenseTracker.core.utilities.results.Result;
import project.expenseTracker.core.utilities.results.SuccessDataResult;
import project.expenseTracker.core.utilities.results.SuccessResult;
import project.expenseTracker.dataAccess.abstracts.TypeDao;
import project.expenseTracker.entities.Type;
import project.expenseTracker.entities.dtos.typeDtos.AddTypeDto;
import project.expenseTracker.entities.dtos.typeDtos.GetTypeDto;

@Service
public class TypeManager implements TypeService{

	
	
	private TypeDao typeDao;
	private ModelMapperConverterService modelMapperConverterService;
	
	@Autowired
	public TypeManager(TypeDao typeDao,ModelMapperConverterService modelMapperConverterService) {
		super();
		this.typeDao = typeDao;
		this.modelMapperConverterService= modelMapperConverterService;
	}

	@Override
	public Result add(AddTypeDto type) {
		
		if(this.typeDao.existsById(type.getId())) {
			
			return new ErrorResult("Bu tip kaydı mevcut.");
		}
		else {
			Type newType = (Type) this.modelMapperConverterService.converterFromDtoToClass(type,Type.class);
			this.typeDao.save(newType);
			return new SuccessResult("Tip başarıyla eklendi.");
		}
		
	}

	@Override
	public DataResult<List<GetTypeDto>> getAll() {
		return new SuccessDataResult<List<GetTypeDto>>(this.modelMapperConverterService.converterFromClassToDto(this.typeDao.findAll(), GetTypeDto.class));
	}
}
