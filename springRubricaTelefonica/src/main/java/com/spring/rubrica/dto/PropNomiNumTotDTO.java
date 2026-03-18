package com.spring.rubrica.dto;

import java.util.List;

public class PropNomiNumTotDTO {
	private List<String> proprietari;
	private int numero;
	public PropNomiNumTotDTO(List<String> proprietari) {
		super();
		this.proprietari = proprietari;
		this.numero = proprietari.size();
	}
	public List<String> getProprietari() {
		return proprietari;
	}
	public void setProprietari(List<String> proprietari) {
		this.proprietari = proprietari;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	
	
}
