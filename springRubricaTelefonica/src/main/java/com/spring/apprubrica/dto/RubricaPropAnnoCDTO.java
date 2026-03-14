package com.spring.apprubrica.dto;


public class RubricaPropAnnoCDTO {
	private String proprietario;
	private int annoCreazione;
	
	public RubricaPropAnnoCDTO() {
		// TODO Auto-generated constructor stub
	}

	public RubricaPropAnnoCDTO(String proprietario, int annoCreazione) {
		super();
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
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
	
	
	
	
}
