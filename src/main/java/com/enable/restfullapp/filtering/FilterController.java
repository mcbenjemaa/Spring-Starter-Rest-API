package com.enable.restfullapp.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	
	/*
	 * 
	 *   Dynamic Filtering fileds in Beans
	 * 
	 */
	
	
	
	// get Bean with only filed1,filed2
	@GetMapping("/filtering")
	public MappingJacksonValue getBean() {
		
		SomeBean bean = new SomeBean("val1","val2","val3");
		
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
				.filterOutAllExcept("filed1","filed2");
		
		FilterProvider provider=new SimpleFilterProvider()
				.addFilter("filterSomeBean", filter);
		
		
		MappingJacksonValue mapping=new MappingJacksonValue(bean);
		mapping.setFilters(provider);
		
		return mapping;
		
	}
}
