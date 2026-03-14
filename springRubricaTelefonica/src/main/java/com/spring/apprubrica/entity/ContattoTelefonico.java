package com.spring.apprubrica.entity;

import java.time.LocalDate;

public class ContattoTelefonico {
	private int id;
	private String nome;
	private String cognome;
	private String numero;
	private String gruppo = "default";
	private LocalDate dataNascita;
	private boolean preferito;
	
	// counter per id
	private static int counter = 0;
	
	public ContattoTelefonico() {
		// TODO Auto-generated constructor stub
	}

	public ContattoTelefonico(String nome, String cognome, String numero, String gruppo, LocalDate dataNascita,
			boolean preferito) {
		super();
		this.id = counter;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppo = gruppo;
		this.dataNascita = dataNascita;
		this.preferito = preferito;
		
		// aggiorno counter
		counter++;
		
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

	public void setCognome(String cognome) {
		this.cognome = cognome;
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
	
	// TODO: aggiungere equals + hashcode per hashset controllo 
	
	
}
