package com.spring.base.music;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Drums implements Instrument {

	@Override
	public void play() {
		System.out.println("I'm playing drums");

	}

}
