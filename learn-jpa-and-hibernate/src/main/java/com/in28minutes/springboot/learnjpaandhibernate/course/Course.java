package com.in28minutes.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity	// @Entity(name="바꾸고 싶은 이름으로 테이블 이름 변경")도 가능
public class Course {

	@Id
	private long id;
//	@Column(name="name") 이처럼 이름이 테이블에 있는 것과 동일하다면 @Column 생략 가능
	private String name;
//	@Column(name="author")
	private String author;
	
	// 생성자
	public Course() {
	}
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	// 게터, 세터
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
