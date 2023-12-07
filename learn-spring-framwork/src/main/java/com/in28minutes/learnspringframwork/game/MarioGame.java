package com.in28minutes.learnspringframwork.game;

public class MarioGame implements GamingConsole {
	public void up() {
		System.out.println("점프");
	}
	
	public void down() {
		System.out.println("파이프로 들어가기");
	}
	
	public void left() {
		System.out.println("뒤로 가기");
	}
	
	public void right() {
		System.out.println("앞으로 가기");
	}
}
