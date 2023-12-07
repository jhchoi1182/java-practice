package com.in28minutes.learnspringframwork;

import com.in28minutes.learnspringframwork.game.GameRunner;
import com.in28minutes.learnspringframwork.game.MarioGame;
import com.in28minutes.learnspringframwork.game.PacmanGame;
import com.in28minutes.learnspringframwork.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		var game = new PacmanGame();
		
		var gameRunner = new GameRunner(game);
		gameRunner.run();

	}
}