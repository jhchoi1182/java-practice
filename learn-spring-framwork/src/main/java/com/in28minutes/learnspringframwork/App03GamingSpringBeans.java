package com.in28minutes.learnspringframwork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframwork.game.GameRunner;
import com.in28minutes.learnspringframwork.game.GamingConsole;
import com.in28minutes.learnspringframwork.game.MarioGame;
import com.in28minutes.learnspringframwork.game.PacmanGame;
import com.in28minutes.learnspringframwork.game.SuperContraGame;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}
}