package com.spring.apprubrica.dto;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.spring.apprubrica.entity.ContattoTelefonico;

public class RubricaDTO {
	private int id;
	private String proprietario; // nome
	private int annoCreazione;
	private Map<Integer, ContattoTelefonico> contatti = new HashMap<Integer, ContattoTelefonico>();
	

	
	public RubricaDTO() {
		// TODO Auto-generated constructor stub
	}

	public RubricaDTO( String proprietario, int annoCreazione, Map<Integer, ContattoTelefonico> contatti) {
		super();
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
		this.contatti = contatti;
		
		
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

	public Map<Integer, ContattoTelefonico> getContatti() {
		return contatti;
	}

	public void setContatti(Map<Integer, ContattoTelefonico> contatti) {
		this.contatti = contatti;
	}

	
	
	
}
