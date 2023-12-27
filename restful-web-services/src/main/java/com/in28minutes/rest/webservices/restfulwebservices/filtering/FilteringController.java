package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FilteringController {

	// field1, field2만 반환
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {

		SomeBean someBean = new SomeBean("value1","value2", "value3");
		
		// JSON으로 직렬화할 때 적용될 필터를 설정할 수 있게 해줌
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		// 필터링 로직
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		// 필터링 로직을 직렬화 과정에 설정
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	
	// field2, field3만 반환
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {

		List<SomeBean> list = Arrays.asList(
				new SomeBean("value1","value2", "value3"), new SomeBean("value4","value5", "value6"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	
}
