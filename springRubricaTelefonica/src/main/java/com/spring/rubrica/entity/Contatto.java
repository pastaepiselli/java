package com.spring.rubrica.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Contatto {
	private int id;
	private String nome;
	private String cognome;
	private String numero;
	private String gruppo;
	private LocalDate dataNascita;
	private boolean preferito;
	
	public Contatto() {
		super();
	}

	public Contatto(int id, String nome, String cognome, String numero, String gruppo, LocalDate dataNascita,
			boolean preferito) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppo = gruppo;
		this.dataNascita = dataNascita;
		this.preferito = preferito;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(cognome, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatto other = (Contatto) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(nome, other.nome);
	}
	
	
		
}
