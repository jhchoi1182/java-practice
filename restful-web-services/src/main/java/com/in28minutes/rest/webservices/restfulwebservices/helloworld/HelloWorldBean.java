package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

	private Object message;

	public HelloWorldBean(String message) {
		this.message = message;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	// 없어도 되지만 코드 명확성을 높이기 위해 권장 됨
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}
