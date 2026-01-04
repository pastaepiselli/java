package eserciziProgrammazioneStrutturata;

import java.util.Scanner;

public class Esercizio2 {
	public static void main(String[] args) {
		// prendo l'input
		Scanner s = new Scanner(System.in);
		
		System.out.print("Inserert a positive number (n): ");
		int n = s.nextInt();
		
		System.out.print("Inserert a positive number (k): ");
		int k = s.nextInt();
		
		// numeri positivi !!
		if (k < 0 || n < 0) {
			System.out.println("Error: Insert 2 positive numbers");
		} else {
			int sum = 0;
			int pow = 1;
			// MENTRE k e maggiore di i
			for (int i = 1; i <= k; i++) {
				// mi calcolo la potenza di n moltiplicandolo ogni ciclo per se stesso
				// come richiede la sommatoria k**n + k ** n + 1 e cosi via a'nv kl
				pow *= n;
				// e aggiungo alla somma 
				sum += pow;
			}
			System.out.println("Result " + sum);
		}
		s.close();
	}
}
