package cartoleria;

public abstract class Articolo {
	private String marca;
	private String modello;
	private double costo;
	private double prezzoVendita;
	public Articolo(String marca, String modello, double costo) {
		this.marca = marca;
		this.modello = modello;
		this.costo = costo;
		this.prezzoVendita = costo * 2;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getMarca() {
		return marca;
	}
	public String getModello() {
		return modello;
	}
	public double getPrezzoVendita() {
		return prezzoVendita;
	}
	@Override
	public String toString() {
		return "Articolo marca=" + marca + ", modello=" + modello + ", costo=" + costo + ", prezzoVendita="
				+ prezzoVendita;
	}
	

}
