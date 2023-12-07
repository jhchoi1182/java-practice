package com.in28minutes.learnspringframwork.game;

public class PacmanGame implements GamingConsole {
	public void up() {
		System.out.println("위로 가기");
	}
	
	public void down() {
		System.out.println("아래로 가기");
	}
	
	public void left() {
		System.out.println("뒤로 가기");
	}
	
	public void right() {
		System.out.println("앞으로 가기");
	}
}
