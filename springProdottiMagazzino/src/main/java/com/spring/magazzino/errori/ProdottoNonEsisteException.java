package com.spring.magazzino.errori;

@SuppressWarnings("serial")
public class ProdottoNonEsisteException extends RuntimeException {
	
	public ProdottoNonEsisteException(String message) {
		super(message);
	}
}
