package eserciziStringhe;

import java.util.Scanner;

public class Esercizio1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire testo: ");
		String text = sc.nextLine();
		boolean flag = true;
		
		char[] textArray = text.toCharArray();
		
		for (char c : textArray) {
			if (Character.isLetter(c)) {
				System.out.println("testo NON numerico");
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("Testo numerico");
		}
		sc.close();
	}
}
		

