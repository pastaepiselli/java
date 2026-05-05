package com.hibernate.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Tessera implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String attivita; // attivita svolta in palestra
	String promozione;
	
	public Tessera() {
		 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttivita() {
		return attivita;
	}

	public void setAttivita(String attivita) {
		this.attivita = attivita;
	}

	public String getPromozione() {
		return promozione;
	}

	public void setPromozione(String promozione) {
		this.promozione = promozione;
	}
	
	
}
