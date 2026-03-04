package com.spring.universita.dto;
import com.spring.universita.entity.Persona;

public class ProfessoreDTO extends Persona {
	private int id; // univoco
	private String materiaInsegnamento;

	public ProfessoreDTO(String nome, String cognome, String materiaInsegnamento, int id) {
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
