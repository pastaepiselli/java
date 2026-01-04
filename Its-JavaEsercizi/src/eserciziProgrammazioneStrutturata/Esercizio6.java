package eserciziProgrammazioneStrutturata;

import java.util.Scanner;
import java.util.ArrayList;

public class Esercizio6 {
	public static void main(String[] args) {
		
		// imposto scanner
		Scanner s = new Scanner(System.in);
		
		// input
		System.out.print("Inserire numero intero: ");
		int n = s.nextInt();
		
		// n deve essere maggiore di zero 
		if (n < 0) {
			System.out.println("Inserire un numero positivo!");
			// return per bloccare il programma
			s.close();
			return ;
			
		} 
	
			
		// in java gli array non possono essere modificati dopo la creazione 
		// devo importare arraylist
		// ok 
		// devo leggere documentazione
//		int[] divisori = new int [100];
		int div = 2;
		int x = n;
		while (x > 1) {
			if (x % div == 0) {
				x = x / div;
				// come si aggiunge ad una lista?
//				divisori.add(div);
		
			} else {
				div ++;
			}
		}
		s.close();
	}	
	
}
