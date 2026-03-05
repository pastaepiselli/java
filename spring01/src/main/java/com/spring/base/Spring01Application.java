package com.spring.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.base.music.Player;

@SpringBootApplication
public class Spring01Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Spring01Application.class, args);
		// Bean  = semplice oggetto con get e set
		Player p = context.getBean(Player.class); // chiama il costruttore 0-args
		p.playInstrument();
	}

}
