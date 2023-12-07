package com.in28minutes.springboot.learnspringboot;

public class Course {
	private long id;	// long 타입 - int 타입보다 더 넓은 범위의 정수 자료형
	private String name;
	private String author;
	
	// 생성자
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	// 게터
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}

	// toString
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
}
