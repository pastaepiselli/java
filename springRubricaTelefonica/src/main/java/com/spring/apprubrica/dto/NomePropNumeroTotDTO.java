package com.spring.apprubrica.dto;

public class NomePropNumeroTotDTO {
	private String nome;
	private int numeroTotale;
	
	public NomePropNumeroTotDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public NomePropNumeroTotDTO(String nome, int numeroContatti) {
		super();
		this.nome = nome;
		this.numeroTotale = numeroContatti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroTotale() {
		return numeroTotale;
	}

	public void setNumeroContatti(int numeroTotale) {
		this.numeroTotale = numeroTotale;
	}
	
	
	
	
}
