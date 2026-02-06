package lotto;

import java.util.HashSet;
//import java.util.Random;
//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		// versione solo sul main 
//		Random r = new Random();
//		Scanner sc = new Scanner(System.in);
//		HashSet<Integer> vincenti = new HashSet<Integer>();
//		
//		while (vincenti.size() < 5) { // finche non trova 5 numeri diversi
//			vincenti.add(r.nextInt(1, 90));
//		}
//		
//		System.out.println(vincenti);
//		
//		HashSet<Integer> giocata = new HashSet<Integer>();
//		while (giocata.size() < 5) {
//			System.out.print("Inserire numero da giocare (no doppioni): ");
//			int n = sc.nextInt();
//			if (n < 1 || n > 91) { // esculde il numero massimo
//				System.out.println("Numeri validi solo da 1 a 90!");
//				continue; // ritorna su nel ciclo e richiede il numero
//			}
//			if (!giocata.add(n)) {
//				System.out.println("Numero non valido! Gia presente nella giocata");
//			}
//		}
//		
//		if (vincenti.equals(giocata)) {
//			System.out.println("Hai vinto!");
//		} else {
//			System.out.println("Hai perso...");
//		}
		
		// versione con la classe lotto implementata
		Lotto l = new Lotto(); 
//		System.out.println(l.getVincenti());
		l.estraiNumeri(); 
//		System.out.println(l.getVincenti());
		
		HashSet<Integer> giocata2 = l.giocata();
		
		l.controlloGiocata(giocata2);
		
		
		
		
		
//		sc.close();
		
		
		
	}	

}
