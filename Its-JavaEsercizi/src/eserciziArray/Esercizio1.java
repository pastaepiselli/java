package eserciziArray;

import java.util.Scanner;

public class Esercizio1 {
	static void printList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	public static void main(String[] args) {
		// creo scanner
		Scanner sc = new Scanner(System.in);
		
		int[] array1 = new int [5];
		
		// popolo il primo array con input
		for (int i = 0; i < array1.length; i++) {
			System.out.print("Inserire numero intero: ");
			array1[i] = sc.nextInt();
		}
		
		// definisco il secondo array con stessa lunghezza di array1
		int[] array2 = new int[array1.length];
		
		for (int i = 0; i < array2.length; i++) {
			array2[i] = array1[i];
		}								
		
		System.out.println("Lista 1");						
		printList(array1);					
		
		// spaziatura
		System.out.println();
		
		System.out.println("Lista 2");
		printList(array2);
		
		// anche array2 = array1; va bene 
		sc.close();
	}
}
