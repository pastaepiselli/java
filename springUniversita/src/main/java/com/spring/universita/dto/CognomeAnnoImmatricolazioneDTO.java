package com.spring.universita.dto;

public class CognomeAnnoImmatricolazioneDTO {
	private String cognome;
	private int annoImmatricolazione;
	
	public CognomeAnnoImmatricolazioneDTO(String cognome, int annoImmatricolazione) {
		this.cognome = cognome;
		this.annoImmatricolazione = annoImmatricolazione;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}
	
	
}
