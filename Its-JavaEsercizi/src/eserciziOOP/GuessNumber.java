package eserciziOOP;

import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		int casualNumber = (int)(Math.random() * 10) + 1;
		int tentativi = 0;
		
		Scanner sc = new Scanner(System.in);
		int guess = -1;
		while (guess != casualNumber) {
			System.out.print("Inserisci un numero: ");
			guess = sc.nextInt();
			if (guess > casualNumber) {
				System.out.println("Troppo grande, riprova con un numero minore.");
				tentativi++;
			} else if (guess < casualNumber) {
				System.out.println("Troppo piccolo, riprova con un numero maggiore.");
				tentativi++;
			}
		}
		tentativi++;
		System.out.printf("Esatto! Hai indovinato con %d tentativi.", tentativi);
	}
}
