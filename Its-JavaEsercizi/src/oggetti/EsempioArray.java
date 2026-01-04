package oggetti;

import java.util.Scanner;

public class EsempioArray {
	public static void main(String[] args) {
		// crere un array
		int[] nuovoarray;
		
		// creazione e aggiunta spazio
		int[] array = new int [100];
		
		// 100 sta per lo spazio massimo che puo occupare in questo caso 100 array
		// prima dell'assegnazione di numeri l'array e pieno di null (non e vuoto!!)
		
		// una forma abbreviata per la costruzione e inizializzazione
		int[] numeriPrimi = {2, 3, 5, 7};
		
		// gli array non hanno una funzione per essere printati
		// questo ritorna la locazione di memoria
		System.out.println(array);
		
		// per modificare un elemento dell'array
		array[2] = 10;
		
		// per printare un array usiamo un for loop
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		// costrutto for each per migliorare in for nel caso delle liste
		// il for each lavora solo in una modalita
		// il for each scorre SEMPRE TUTTI gli elementi della lista
		for (int primi : numeriPrimi) {
			// si potrebbe fare un if per cambiare l'iterazione come vuoi
			System.err.println(primi);
		}
		
		// se si prova ad accerere ad un elemento fuori dall'array il compilatore nn lo vede 
		// run time error sollevando l'eccezione
		
//		System.out.println(array[101]); 
		
		// si possono anche creare matrici, array di array
		
		int[] [] matrix = new int[4][5];
		
		// input e liste
		
		int[] inputArray = new int [5];
		
		// definisco lo scanner
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print("Inserire un numero: ");
			
			// ogni iterazione prendo un numero in input e lo aggiungo all'index attuale
			inputArray[i] = sc.nextInt();
		}
		
		for (int num : inputArray) {
			System.out.println(num);
		}
		
		
		
		
	}
	
}
