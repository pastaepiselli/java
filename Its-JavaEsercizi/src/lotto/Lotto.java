package lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	Random r = new Random();
	Scanner sc = new Scanner(System.in);
	private HashSet<Integer> vincenti = new HashSet<Integer>();
	
	public Lotto() {
		vincenti = this.estraiNumeri(); // alla creazione vengono estratti i numeri
		
	}
	
	// metodo che estrae i numeri vincenti
	public HashSet<Integer> estraiNumeri() {
		if (vincenti.size() == 5) {
			vincenti.clear();
		}
		while (vincenti.size() < 5) {
			vincenti.add(r.nextInt(1, 91));
		}
		return vincenti;
	}
	
	// metodo che ti permette di giocare
	public HashSet<Integer> giocata() {
		HashSet<Integer> giocata = new HashSet<Integer>();
		
		while (giocata.size() < 5) {
			System.out.print("Inserire numero da giocare (no doppioni): ");
			int n = sc.nextInt();
			if (n < 1 || n > 91) { // esculde il numero massimo
				System.out.println("Numeri validi solo da 1 a 90!");
				continue; // ritorna su nel ciclo e richiede il numero
			}
			if (!giocata.add(n)) {
				System.out.println("Numero non valido! Gia presente nella giocata");
			}
		}
		return giocata;
	}
	
	// controllo vittoria
	public void controlloGiocata(HashSet<Integer> giocata) {
		if (vincenti.equals(giocata)){
			System.out.println("Hai vinto!");
		} else {
			System.out.println("Hai perso...");
		}
			
	}
	
	// solo per controllare se funzionasse il controlloGiocata... non si vince mai a lotto
	
//	public HashSet<Integer> getVincenti() {
//		return vincenti;
//	}

	
	
	
}
