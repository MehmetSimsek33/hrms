package kodlama.io.hrms.core.utilities.mappers;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

import kodlama.io.hrms.core.utilities.result.Result;


public class ModelMapperUtils {
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static <S, T> List<T> toList(List<S> source, Class<T> targetClass){
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		
		return source.stream().map(element -> modelMapper.map(element, targetClass))
				.collect(Collectors.toList());
		
	}

	public static <S, T> T maping(S source, Class<T> targetClass){
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		return	modelMapper.map(source,targetClass);

	}
	public static <S, T> T change(S source, Class<T> targetClass){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(source,targetClass);

	}
	
}