package com.spring.apprubrica.dto;

public class NomePropNumeroCDTO {
	private String nome;
	private int numeroContatti;
	
	public NomePropNumeroCDTO() {
		// TODO Auto-generated constructor stub
	}

	public NomePropNumeroCDTO(String nome, int numeroContatti) {
		super();
		this.nome = nome;
		this.numeroContatti = numeroContatti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroContatti() {
		return numeroContatti;
	}

	public void setNumeroContatti(int numeroContatti) {
		this.numeroContatti = numeroContatti;
	}
	
	
	
	

}
