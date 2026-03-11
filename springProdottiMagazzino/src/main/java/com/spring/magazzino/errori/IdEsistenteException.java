package com.spring.magazzino.errori;

@SuppressWarnings("serial") // questo sopprime quell'avviso del serial id che richiede la jvm 
// lo ha messo eclipse non io
public class IdEsistenteException extends RuntimeException {
	public IdEsistenteException(String message) {
		super(message);
	}
}
