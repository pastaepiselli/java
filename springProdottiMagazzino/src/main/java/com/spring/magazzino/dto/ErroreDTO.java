package com.spring.magazzino.dto;
/*
 * classe per l'invio del messaggio di errore
 */
public class ErroreDTO {
	private String messaggio;
	
	public ErroreDTO(String messaggio) {
		this.messaggio = messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	
}
