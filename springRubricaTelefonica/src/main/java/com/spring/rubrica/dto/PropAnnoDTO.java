package com.spring.rubrica.dto;

public class PropAnnoDTO {
	private String propritario;
	private int annoCreazione;
	
	public PropAnnoDTO(String propritario, int annoCreazione) {
		super();
		this.propritario = propritario;
		this.annoCreazione = annoCreazione;
	}

	public String getPropritario() {
		return propritario;
	}

	public void setPropritario(String propritario) {
		this.propritario = propritario;
	}

	public int getAnnoCreazione() {
		return annoCreazione;
	}

	public void setAnnoCreazione(int annoCreazione) {
		this.annoCreazione = annoCreazione;
	}
	
	
}
