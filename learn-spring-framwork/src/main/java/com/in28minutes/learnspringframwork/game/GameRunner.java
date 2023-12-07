package com.in28minutes.learnspringframwork.game;

public class GameRunner {
	private GamingConsole game;
	
	public GameRunner(GamingConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("실행 중인 게임: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
