package strategy;

import java.util.ArrayList;


public class Carrello {
	private ArrayList<Prodotto> carrello = new ArrayList<Prodotto>();
	
	public void add(Prodotto p) {
		// prendo index
		int i = carrello.indexOf(p);
		if (i == -1) {
			carrello.add(p);
		} else {
			// se gia esiste aggiungo solo la quantita
			carrello.get(i).addQuantitaOrdinata(p.getQuantitaOrdinata());;
		}
	}
	
	private double calcoloTotale() {
		double sum = 0;
		for (Prodotto p : carrello) {
			sum += p.getPrezzoUnitario() * p.getQuantitaOrdinata();
		}
		return sum;
	}
	
	public double calcoloTotale(Sconto s) {
		if (s == null) {
			// nessuno sconto
			return this.calcoloTotale();
		}
		return s.applica(this.calcoloTotale());
	}
}
