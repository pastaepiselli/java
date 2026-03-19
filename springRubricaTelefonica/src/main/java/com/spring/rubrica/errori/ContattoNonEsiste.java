package com.spring.rubrica.errori;

public class ContattoNonEsiste extends RuntimeException {
	public ContattoNonEsiste(String message) {
		super(message);
	}
}
