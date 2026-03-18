package com.spring.rubrica.dto;

import java.util.HashMap;
import java.util.Map;

public class RubricaDTO {
	private int id;
	private String proprietario;
	private int annoCreazione;
	private Map<Integer, ContattoDTO> contatti = new HashMap<Integer, ContattoDTO>();
	
	public RubricaDTO(int id, String proprietario, int annoCreazione) {
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

	public Map<Integer, ContattoDTO> getContatti() {
		return contatti;
	}

	public void setContatti(Map<Integer, ContattoDTO> contatti) {
		this.contatti = contatti;
	}
	
	
	
	
	
	
}
