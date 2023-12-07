package com.in28minutes.learnspringframwork.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 1. 스프링 context 실행
		// JVM 내에 스프링 context 생성
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			// 2. 스프링이 관리하도록 설정 (설정 클래스 세팅)
			//	HelloWorldConfiguration 클래스 생성
			//	name 이라는 Bean 생성
			
			// 3. 스프링의 name Bean 꺼내기
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2"));
			System.out.println(context.getBean("person3"));
			System.out.println(context.getBean("person4"));
			System.out.println(context.getBean("person5"));
			System.out.println(context.getBean("address2"));
			System.out.println(context.getBean(Address.class));
			System.out.println(context.getBean(Person.class));
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
}