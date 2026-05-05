package com.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
public class Corso implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nome;
	Integer numeroIscritti;
	
	
	@ManyToMany()
	@JoinTable(
			name = "persone_corsi",
			joinColumns = @JoinColumn(name = "id_corso"),
			inverseJoinColumns = @JoinColumn(name = "id_persona")) // crea una tabella con 2 colonne chiamate in questo modo 
	Set<Persona> listaPersone; 
	
	public Corso() {
		
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

	public Integer getNumeroIscritti() {
		return numeroIscritti;
	}

	public void setNumeroIscritti(Integer numeroIscritti) {
		this.numeroIscritti = numeroIscritti;
	}

	public Set<Persona> getListaPersone() {
		return listaPersone;
	}

	public void setListaPersone(Set<Persona> listaPersone) {
		this.listaPersone = listaPersone;
	}
	
	
	
	
	
}
