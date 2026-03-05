package com.spring.base.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // diciamo a spring di instanziare per noi questa classe
public class Player {
	
	@Autowired // spring deve associare questo attributo ad un valore
	private Instrument instrument;
	
	public void playInstrument() {
		instrument.play();
	}
}
