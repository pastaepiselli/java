package com.hibernate.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hibernate.dto.PersonaDTO;
import com.hibernate.entity.Tessera;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity // questa classe sara mappata su una tabella
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
//@Table(name = "iscritti")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	/* questa persona sara la copia di una tabella su un database
	 * un record deve essere identificato da una chive univoca (primary key)
	 */
	
	@Id // identifica la chiave primaria
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_persona")
	Long id; // primary key, opportuno lavorare con classi wrapper
	@Column(length = 4) // check value in questo caso sulla lunghezza
	String nome;
	String cognome;
	@Transient // proprieta ignorata da hibernate
	Integer eta;
	@CreationTimestamp
	Timestamp dataInserimento;
	
	// tra persona e tessera ora ce una dipendeza
	@OneToOne() // one to one con persona
	@JoinColumn
	Tessera tesseraIscrizione;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // per propagare azione anche ai figli, lazy = nn carica di default il trainer 
	@JoinColumn(name = "id_trainer") // nome colonna a cui referenza 
	Trainer trainer;
	
	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(
			name = "persona_corsi",
			joinColumns = @JoinColumn(name = "id_persona"),
			inverseJoinColumns = @JoinColumn(name = "id_corso"))
	Set<Corso> listaCorsi = new HashSet<Corso>();
	
	public Persona() {
		
	}
	
	public Persona(PersonaDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.cognome = dto.getCognome();
		this.eta = dto.getEta();
		this.tesseraIscrizione = new Tessera();
		tesseraIscrizione.setAttivita(dto.getTesseraIscrizione().getAttivita());
		tesseraIscrizione.setPromozione(dto.getTesseraIscrizione().getPromozione());
		this.trainer = dto.getTrainer();
		trainer.setCognome(dto.getTrainer().getCognome());
		trainer.setNome(dto.getTrainer().getNome());
		trainer.setId(dto.getTrainer().getId());
		this.listaCorsi = new HashSet<Corso>();
		this.listaCorsi = dto.getListaCorsi();
	}
	

	public Persona(Long id, String nome, String cognome, Integer eta) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
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

	public Timestamp getDataInserimento() {
		return dataInserimento;
	}



	public void setDataInserimento(Timestamp dataInserimento) {
		this.dataInserimento = dataInserimento;
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
		this.trainer = trainer;
	}

	public Set<Corso> getListaCorsi() {
		return listaCorsi;
	}

	public void setListaCorsi(Set<Corso> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}
	
	
	
	
	
	
	
	
	
}
