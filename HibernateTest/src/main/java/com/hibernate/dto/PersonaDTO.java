package com.hibernate.dto;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.hibernate.entity.Corso;
import com.hibernate.entity.Persona;
import com.hibernate.entity.Tessera;
import com.hibernate.entity.Trainer;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PersonaDTO {
	/* questa persona sara la copia di una tabella su un database
	 * un record deve essere identificato da una chive univoca (primary key)
	 */
	
	Long id; // primary key, opportuno lavorare con classi wrapper
	String nome;
	String cognome;
	Integer eta;
	Tessera tesseraIscrizione;
	Trainer trainer;
	Set<Corso> listaCorsi;
	
	public PersonaDTO() {
		
	}
	
	public PersonaDTO(Long id, String nome, String cognome, Integer eta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}
	
	public PersonaDTO(Persona entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cognome = entity.getCognome();
		this.eta = entity.getEta();
		this.tesseraIscrizione = new Tessera();
		tesseraIscrizione.setAttivita(entity.getTesseraIscrizione().getAttivita());	
		tesseraIscrizione.setPromozione(entity.getTesseraIscrizione().getPromozione());	
		this.trainer = new Trainer();
		trainer.setCognome(entity.getTrainer().getCognome());
		trainer.setNome(entity.getTrainer().getNome());
		trainer.setId(entity.getTrainer().getId());
		this.listaCorsi = new HashSet<Corso>();
		this.listaCorsi = entity.getListaCorsi();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public Tessera getTesseraIscrizione() {
		return tesseraIscrizione;
	}

	public void setTesseraIscrizione(Tessera tesseraIscrizione) {
		this.tesseraIscrizione = tesseraIscrizione;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;}
	
	public Set<Corso> getListaCorsi() {
		return listaCorsi;
	}

	public void setListaCorsi(Set<Corso> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}
}
		
		


		

	
