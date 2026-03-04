package com.spring.universita.dto;

import com.spring.universita.entity.Persona;

public class StudenteDTO extends Persona {
	private String matricola; // univoco
	private String indirizzo;
	private int annoNascita;
	private int annoImmatricolazione;

	public StudenteDTO(String nome, String cognome, String matricola, 
			String indirizzo, int annoNascita, int annoImmatricolazione) {
		super(nome, cognome);
		this.matricola = matricola;
		this.indirizzo = indirizzo;
		this.annoNascita = annoNascita;
		this.annoImmatricolazione = annoImmatricolazione;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}

	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}
	
	

}
