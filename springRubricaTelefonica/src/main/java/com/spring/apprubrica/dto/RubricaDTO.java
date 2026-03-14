package com.spring.apprubrica.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.spring.apprubrica.entity.ContattoTelefonico;

public class RubricaDTO {
	private int id;
	private String proprietario; // nome
	private LocalDate annoCreazione;
	private Set<ContattoTelefonico> contatti = new HashSet<ContattoTelefonico>();
	
	// counter
	private static int counter = 0;
	
	public RubricaDTO() {
		// TODO Auto-generated constructor stub
	}

	public RubricaDTO(String proprietario, LocalDate annoCreazione) {
		super();
		this.id = counter;
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
		
		 // aggiorno counter
		counter++;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public LocalDate getAnnoCreazione() {
		return annoCreazione;
	}

	public void setAnnoCreazione(LocalDate annoCreazione) {
		this.annoCreazione = annoCreazione;
	}
}
