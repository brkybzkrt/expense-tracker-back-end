package project.expenseTracker.core.utilities.modelMapper;

import java.util.List;

public interface ModelMapperConverterService {

	<S, T> List<T> converterFromClassToDto(List<S> s, Class<T> targetClass);
	public <T> Object converterFromDtoToClass(Object source,Class<T> baseClass);
}
