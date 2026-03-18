package com.spring.rubrica.errori;

public class IdNonEsisteException extends RuntimeException {
	public IdNonEsisteException(String message) {
		super(message);
	}
}
