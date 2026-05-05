package com.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Trainer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_trainer")
	Long id; // primary key
	String nome;
	String cognome;
	
	@OneToMany(mappedBy = "trainer") // nome della variabile di 
	Set<Persona> listaAllievi;
	
	public Trainer() {
	 
		
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

	public Set<Persona> getListaAllievi() {
		return listaAllievi;
	}

	public void setListaAllievi(Set<Persona> listaAllievi) {
		this.listaAllievi = listaAllievi;
	}
	
	
		
}
