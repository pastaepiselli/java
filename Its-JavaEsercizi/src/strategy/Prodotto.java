package strategy;

import java.util.Objects;

public class Prodotto {
	private String nome;
	private int quantitaOrdinata;
	private int prezzoUnitario;
	public Prodotto(String nome, int quantitaOrdinata, int prezzoUnitario) {
		super();
		this.nome = nome;
		this.quantitaOrdinata = quantitaOrdinata;
		this.prezzoUnitario = prezzoUnitario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantitaOrdinata() {
		return quantitaOrdinata;
	}
	public void setQuantitaOrdinata(int quantitaOrdinata) {
		this.quantitaOrdinata = quantitaOrdinata;
	}
	public void addQuantitaOrdinata(int quantitaOrdinata) {
		this.quantitaOrdinata += quantitaOrdinata;
	}
	
	
	public int getPrezzoUnitario() {
		return prezzoUnitario;
	}
	public void setPrezzoUnitario(int prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		return Objects.equals(nome, other.nome);
	}
	
	
	
	
	
	
}
