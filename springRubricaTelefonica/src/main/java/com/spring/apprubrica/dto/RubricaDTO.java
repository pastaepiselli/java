package com.spring.apprubrica.dto;


import java.util.HashSet;
import java.util.Set;

import com.spring.apprubrica.entity.ContattoTelefonico;

public class RubricaDTO {
	private int id;
	private String proprietario; // nome
	private int annoCreazione;
	private Set<ContattoTelefonico> contatti = new HashSet<ContattoTelefonico>();
	

	
	public RubricaDTO() {
		// TODO Auto-generated constructor stub
	}

	public RubricaDTO( String proprietario, int annoCreazione) {
		super();
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
		
		
	}
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
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
