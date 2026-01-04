package eserciziArray;

import java.util.Scanner;

public class Esercizio3 {
	static void printList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	public static void main(String[] args) {
		// definisco input 
		Scanner sc = new Scanner(System.in);
		
		// definisco array lungo 10
		int[] array1 = new int[10];
		
		// inserisco solo meta numeri
		for (int i = 0; i < array1.length / 2; i++) {
			
			// in input
			System.out.print("Inserire un numero intero: ");
			array1[i] = sc.nextInt();
		}
		
		System.out.println("Array dimezzato");
		printList(array1);
		
		// itero per partendo dalla meta della lista
		for (int i = array1.length / 2; i < array1.length; i++) {
			// elem a index 5 = array1[5 - 5] ricordati che i sale quindi
			// prima iterazione 5 - 5 = 0
			// seconda iterazione 6 - 5 = 0
			// terza iterazione 7 - 5 = 0
			array1[i] = array1[i - array1.length / 2];
		}
		
		
		System.out.println("Array completo");
		printList(array1);
		
		
		sc.close();
		
	}
}
