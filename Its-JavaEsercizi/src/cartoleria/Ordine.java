package cartoleria;

import java.time.LocalDate;
import java.util.ArrayList;


public class Ordine {
	static int countNum;
	private int numero;
	private LocalDate data;
	private Cliente cliente;
	private ArrayList<Articolo> merci = new ArrayList<>();
	private boolean pagato = false;
	public Ordine(LocalDate data, Cliente cliente) {
		this.data = data;
		this.cliente = cliente;
		
		// assegno
		this.numero = countNum;
		
		// aggiorno
		countNum++;
	}
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Articolo> getMerci() {
		return merci;
	}
	
	public void setMerci(ArrayList<Articolo> merci) {
		this.merci = merci;
	}
	
	public boolean isPagato() {
		return pagato;
	}
	@Override
	public String toString() {
		return "Ordine [numero=" + numero + ", data=" + data + ", cliente=" + cliente + ", merci=" + merci + "]";
	}
	
	public void aggiungiArticolo(Articolo a) {
		this.merci.add(a);
	}
	public double calcolaTotale(){
		double totale = 0;
		for (Articolo articolo : merci) {
			totale+= articolo.getPrezzoVendita();
		}
		
		return totale;
	}
	
	public void chiudi() {
		if (!pagato) {
			this.cliente.paga(this.calcolaTotale()); // chiamata polimorfica
			pagato = true;
		}
	}
	
	
	
	
	
	
	
}
