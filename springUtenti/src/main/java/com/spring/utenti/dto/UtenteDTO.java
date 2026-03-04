package com.spring.utenti.dto;

public class UtenteDTO {
	private int idUtente;
	private String nome, cognome, email, telefono;
	
	
	// di base si fa anche un costruttore vuoto
	public UtenteDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UtenteDTO(int idUtente, String nome, String cognome, String email, String telefono) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
}
