package com.spring.universita.entity;

public class Professore extends Persona {
	private int id; // univoco
	private String materiaInsegnamento;

	public Professore(String nome, String cognome, String materiaInsegnamento, int id) {
		super(nome, cognome);
		this.id = id;
		this.materiaInsegnamento = materiaInsegnamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMateriaInsegnamento() {
		return materiaInsegnamento;
	}

	public void setMateriaInsegnamento(String materiaInsegnamento) {
		this.materiaInsegnamento = materiaInsegnamento;
	}
	
	

	

}
