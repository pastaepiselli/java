package cartoleria;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Magazzino {
	
	private ArrayList<Articolo> articoli;
	
	public Magazzino() {
		this.articoli = new ArrayList<Articolo>();
	}

	public void CaricaArticolo(Articolo art) {
		this.articoli.add(art);
	}
	
	public void StampaArticoli() {
		System.out.println("Ecco tutti gli articoli del magazzino: ");
		for (Articolo articolo : this.articoli ) {
			System.out.println(articolo);
		}
	}
	
	public void StampaCostiTotali() {
		double somma = 0;
		for (Articolo articolo : this.articoli) {
			somma += articolo.getCosto();
		}
		
		System.out.println("Costi totali= " + somma);
	}
	
	public void StampaRicaviTotali() {
		double somma = 0;
		for (Articolo articolo : this.articoli) {
			somma += articolo.getPrezzoVendita();
		}
		
		System.out.println("Ricavi totali= " + somma);
		
	}
	
	public void rimuoviArticolo(Articolo art){
		try {
			this.articoli.remove(art);
		} catch (Exception e) {
			System.out.println("Articolo non presente");
		}
	}
	
	public void cercaPerModello(String modello) {
		System.out.println("Inizio ricerca: ");
		boolean trovato = false;
		for (Articolo articolo : this.articoli) {
			if (articolo.getModello().equalsIgnoreCase(modello)) {
				System.out.println(articolo);
				trovato = true;
			}
		}
		if (!trovato) {
			System.out.println("Nessun articolo trovato con modello " + modello);
		}
	}
	
	public void cercaPerMarca(String marca) {
		System.out.println("Inzio ricerca: ");
		boolean trovato = false;
		for (Articolo articolo : this.articoli) {
			if (articolo.getMarca().equalsIgnoreCase(marca)) {
				System.out.println(articolo);
				trovato = true;
			}
		}
		if (!trovato) {
			System.out.println("Nessuno articolo trovato con marca " + marca);
		}
	}
	
	public void ordinaPerCosto() {

}
