package eserciziArray;

import java.util.Scanner;

public class Esercizio9 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] ruota = new int [5];
		
		for (int i = 0; i < ruota.length; i++) {
			// assegno 5 numeri random alla lista
			ruota[i] = (int)(Math.random() * 91);
 		}
		
		System.out.print("Inserire numeri da giocare (max 5): ");
		int dim = -1 ;
		// richede l'input per la dimensione della giocata corretto
		while (dim > 5 || dim <= 0 ) {
			dim = sc.nextInt();
			if (dim > 5) {
				System.out.println("Inserire massimo 5 numeri!");
			} else if (dim <= 0) {
				System.out.println("La giocata non puo essere composta da 0 o meno numeri!");
			}
		}
		
		// inizializza l'array con le dimensioni della giocata
		int[] giocata = new int[dim];
		
		// prendo in input i numeri da giocare
		System.out.printf("Inserire %d numeri da giocare: %n", dim);
		for (int i = 0; i < giocata.length; i++) {
			giocata[i]  = sc.nextInt();
			
		}
		
		// controlla i numeri indovinati
		int numeriIndovinati = 0;
		for (int i = 0; i < ruota.length; i++) {
			for (int j = 0; j < giocata.length; j++) {
				if (ruota[i] == giocata[j]) numeriIndovinati++;
			}
		}
		System.out.printf("Hai indovinato %d numeri!", numeriIndovinati);
		
		sc.close();
	}
}
