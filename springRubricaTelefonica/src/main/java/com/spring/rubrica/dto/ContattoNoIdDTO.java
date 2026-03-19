package com.spring.rubrica.dto;

import java.time.LocalDate;

/* dto che viene ricevuto per la modifica del contatto */
public class ContattoNoIdDTO {
	private String nome;
	private String cognome;
	private String numero;
	private String gruppo;
	private LocalDate dataNascita;
	private boolean preferito;
	
	public ContattoNoIdDTO() {
		super();
	}

	public ContattoNoIdDTO(String nome, String cognome, String numero, String gruppo, LocalDate dataNascita,
			boolean preferito) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppo = gruppo;
		this.dataNascita = dataNascita;
		this.preferito = preferito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String congnome) {
		this.cognome = congnome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public boolean isPreferito() {
		return preferito;
	}

	public void setPreferito(boolean preferito) {
		this.preferito = preferito;
	}
		
}
