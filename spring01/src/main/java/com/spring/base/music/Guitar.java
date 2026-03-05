package com.spring.base.music;

import org.springframework.stereotype.Component;

@Component // deve iniettarla 
public class Guitar implements Instrument {

	@Override
	public void play() {
		System.out.println("I'm playing guitar");
		
	}

}
