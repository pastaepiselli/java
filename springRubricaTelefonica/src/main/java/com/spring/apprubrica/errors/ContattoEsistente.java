package com.spring.apprubrica.errors;

public class ContattoEsistente extends RuntimeException {
	public ContattoEsistente(String message) {
		super(message);
	}
}
