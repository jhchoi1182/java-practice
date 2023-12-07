package com.in28minutes.springboot.learnspringboot;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")	// URL을 http://localhost:8080/courses로 설정
	public List<Course> retrieveAllCourses() {	// Course[] - 배열이기에 크기가 정해져있음. List<Course> - 객체들의 리스트를 의미하며, 리스트의 크기는 동적으로 변할 수 있음
		return Arrays.asList(	// 인자로 받는 객체들을 포함하는 리스트를 생성
				new Course(1, "Learn AWS", "in28minutes"),
				new Course(2, "Learn DevOps", "in28minutes"),
				new Course(3, "Learn Azure", "in28minutes"),
				new Course(4, "Learn GCP", "in28minutes")
				
				);
	}
}
