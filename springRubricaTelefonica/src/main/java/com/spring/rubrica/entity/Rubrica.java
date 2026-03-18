package com.spring.rubrica.entity;

import java.util.HashMap;
import java.util.Map;


public class Rubrica {
	private int id;
	private String proprietario;
	private int annoCreazione;
	private Map<Integer, Contatto> contatti = new HashMap<Integer, Contatto>();
	
	public Rubrica(int id, String proprietario, int annoCreazione) {
		super();
		this.id = id;
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

	public Map<Integer, Contatto> getContatti() {
		return contatti;
	}

	public void setContatti(Map<Integer, Contatto> contatti) {
		this.contatti = contatti;
	}
	
	
	
	
	
	
}
