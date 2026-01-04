package eserciziStringhe;

import java.util.Scanner;

public class Esercizio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean pal = true;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1  - i)){
				System.out.println("Non palindromo");
				pal = false;
				break;
			}
		}
		
		if (pal) {
			System.out.println("Palindromo");
		}
		
		
		// soluzione con StringBuilder 
		
//		StringBuilder s1 = new StringBuilder(s);
//		s1.reverse();
//		if (s.equals(s1.toString())) {
//			System.out.println("Palindromo");
//		} else {
//			System.out.println("Non palindromo");
//		}
//		sc.close();
//		
		
		
		
	}

}
