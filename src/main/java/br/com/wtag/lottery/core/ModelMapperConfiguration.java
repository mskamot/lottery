package br.com.wtag.lottery.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Model mapper configuration.
 *
 * @author  Mario Sakamoto <mskamot@gmail.com>
 * @see     org.springframework.context.annotation.Configuration
 * @since   1.0.0
 * @version 1.0.0, 15 Jan 2021
 */
@Configuration
public class ModelMapperConfiguration {
	
	/**
	 * Model mapper.
	 *
	 * @return ModelMapper
	 * @see    org.springframework.context.annotation.Bean
	 * @see    org.modelmapper.ModelMapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}