package com.spring.universita.dto;

public class CognomeAnnoNascitaDTO {
	private String cognome;
	private int annoNascita;
	
	public CognomeAnnoNascitaDTO() {
		super();
	}
	
	public CognomeAnnoNascitaDTO(String cognome, int annoNascita) {
		super();
		this.cognome = cognome;
		this.annoNascita = annoNascita;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}
	
}
