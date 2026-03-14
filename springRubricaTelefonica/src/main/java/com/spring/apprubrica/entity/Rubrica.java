package com.spring.apprubrica.entity;

import java.time.LocalDate;
import java.util.HashSet;

import java.util.Set;

public class Rubrica {
	private int id;
	private String proprietario; // nome
	private int annoCreazione;
	private Set<ContattoTelefonico> contatti = new HashSet<ContattoTelefonico>();
	
	// counter
	private static int counter = 0;
	
	public Rubrica() {
		// TODO Auto-generated constructor stub
	}

	public Rubrica(String proprietario, int annoCreazione) {
		super();
		this.id = counter;
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
		
		 // aggiorno counter
		counter++;
	}
	

	public int getId() {
		return id;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getAnnoCreazione() {
		return annoCreazione;
	}

	public void setAnnoCreazione(int annoCreazione) {
		this.annoCreazione = annoCreazione;
	}

	public Set<ContattoTelefonico> getContatti() {
		return contatti;
	}

	public void setContatti(Set<ContattoTelefonico> contatti) {
		this.contatti = contatti;
	}
	
	
	
	
	
	
	
}
