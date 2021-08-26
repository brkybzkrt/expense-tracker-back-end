package project.expenseTracker.core.utilities.modelMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperConverterManager implements ModelMapperConverterService {

	private ModelMapper modelMapper;
	
	
	public ModelMapperConverterManager(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	public <S, T> List<T> converterFromClassToDto(List<S> s, Class<T> targetClass) {
		return s.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}

	@Override
	public <T> Object converterFromDtoToClass(Object source, Class<T> baseClass) {
		return modelMapper.map(source,baseClass);
	}

}
