package rubrica;

import java.util.ArrayList;

public class Rubrica {
	private ArrayList<Contatto> contatti;
	private final int capacity = 20;
	
	public Rubrica() {
		this.contatti = new ArrayList<Contatto>(capacity);
	}
	
	public void aggiungiContatto(Contatto contatto) {
		this.contatti.add(contatto);
	}
	
	public void mostraContattoPosizioneSpecificata(int pos) {
		try {
			System.out.println(this.contatti.get(pos));
		} catch (Exception err ) {
			System.out.println("Nessun contatto presente in posizione: " + pos);
		}
	}
	
	public void stampaContatti() {
		for (int i = 0; i < this.contatti.size(); i++) {
			System.out.println(contatti.get(i));
		}
	}
	
	public int numeroContattiRegistrati() {
		return this.contatti.size();
	}
	
	public int numeroPostiLiberi() {
		return this.capacity - this.contatti.size();
		
	}
	
	public String cercaContattoPerNome(String nomeContatto) {
		for (Contatto contatto : this.contatti) {
			if (contatto.getNome().equalsIgnoreCase(nomeContatto)) {
				return contatto.getNome() + contatto.getCognome();
			}
		}
		return "Nessun contatto con il nome" + nomeContatto;
	}
	
	public String cercaContattoPerNumero(String numero) {
		for (Contatto contatto : this.contatti) {
			if (contatto.getNumeroTelefonico().equals(numero)) {
				return contatto.getNome() + contatto.getCognome();
			}
		}
		return "Nessun contatto con il numero " + numero;
	}
	
	
}
