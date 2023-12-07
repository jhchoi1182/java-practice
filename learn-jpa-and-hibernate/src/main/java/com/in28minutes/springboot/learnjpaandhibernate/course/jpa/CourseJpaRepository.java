package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional	// JPA로 쿼리를 실행하려고 할 때 필요
public class CourseJpaRepository {
	
	@PersistenceContext	// EntityManager에서 @Autowired역할을 하는 보다 구체적인 어노테이션
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);	// merge => 행을 삽입
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
}
