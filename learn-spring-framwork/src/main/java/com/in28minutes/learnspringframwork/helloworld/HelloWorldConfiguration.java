package com.in28minutes.learnspringframwork.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
 
record Person (String name, int age, Address address) {}
record Address (String country, String city) {}

//스프링 컨테이너를 만들기 위한 인풋
@Configuration	// 하나 이상의 Bean(스프링에서 관리하는 것들) 메서드를 선언해야 함
public class HelloWorldConfiguration {
	@Bean	// 빈을 호출
	public String name() {
		return "홍길동";
	}
	
	@Bean
	public int age() {
		return 20;
	}
	
	@Bean
	public Person person() {
		return  new Person("김철수", 12, new Address("대한민국", "서울시"));
	}
	
	@Bean
	public Person person2() {
		return  new Person(name(), age(), address());	// 메소드 호출도 가능
	}
	
	@Bean
	public Person person3(String name, int age, Address address3) {	// 파라미터를 이용한 방식
		return  new Person(name, age, address3);
	}
	
	@Bean
	@Primary
	public Person person4(String name, int age, Address address) {	// address 라는 없는 Bean 을 사용해도 Address 타입 지정으로 인해 Primary Bean 을 사용
		return  new Person(name, age, address);
	}
	
	@Bean
	public Person person5(String name, int age, @Qualifier("address3qualifier") Address address) {
		return  new Person(name, age, address);
	}
	
	@Bean(name = "address2") // Bean 이름을 address2로 변경 (이렇게도 메소드 이름 수정 가능)
	@Primary
	public Address address() {
		return  new Address("대한민국", "서울시");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return  new Address("대한민국", "남양주시");
	}
}
