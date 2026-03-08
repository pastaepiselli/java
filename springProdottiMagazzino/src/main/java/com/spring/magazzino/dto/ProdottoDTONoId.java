package com.spring.magazzino.dto;

public class ProdottoDTONoId {
	private int id; // univoco
	private String marca;
	private String modello;
	private String descrizione;
	private double prezzo_consigliato;
	private double prezzo_massimo;
	private int quantita; // pezzi disponibili
	private String categoria;
	
	// boh quello senza argomenti non mi ricordo se serviva a qualcosa
	public ProdottoDTONoId() {
		// TODO Auto-generated constructor stub
	}
	
	public ProdottoDTONoId(String marca, String modello, String descrizione, double prezzo_consigliato,
			double prezzo_massimo, int quantita, String categoria) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		this.prezzo_consigliato = prezzo_consigliato;
		this.prezzo_massimo = prezzo_massimo;
		this.quantita = quantita;
		this.categoria = categoria;
	}


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo_consigliato() {
		return prezzo_consigliato;
	}

	public void setPrezzo_consigliato(double prezzo_consigliato) {
		this.prezzo_consigliato = prezzo_consigliato;
	}

	public double getPrezzo_massimo() {
		return prezzo_massimo;
	}

	public void setPrezzo_massimo(double prezzo_massimo) {
		this.prezzo_massimo = prezzo_massimo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
}
