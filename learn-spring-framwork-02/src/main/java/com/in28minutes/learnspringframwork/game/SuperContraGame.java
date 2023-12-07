package com.in28minutes.learnspringframwork.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {
	public void up() {
		System.out.println("점프");
	}
	
	public void down() {
		System.out.println("앉기");
	}
	
	public void left() {
		System.out.println("왼쪽으로 가기");
	}
	
	public void right() {
		System.out.println("오른쪽으로 가기");
	}
}
