package com.spring.apprubrica.dto;

import java.util.List;

public class NomePropNumeroTotDTO {
	private List<String> proprietari;
	private int numeroTotale;
	
	public NomePropNumeroTotDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public NomePropNumeroTotDTO(List<String> proprietari, int numeroContatti) {
		super();
		this.proprietari = proprietari;
		this.numeroTotale = numeroContatti;
	}

	public List<String> getProprietari() {
		return proprietari;
	}

	public void setProprietari(List<String> proprietari) {
		this.proprietari = proprietari;
	}

	public int getNumeroTotale() {
		return numeroTotale;
	}

	public void setNumeroContatti(int numeroTotale) {
		this.numeroTotale = numeroTotale;
	}
	
	
	
	
}
