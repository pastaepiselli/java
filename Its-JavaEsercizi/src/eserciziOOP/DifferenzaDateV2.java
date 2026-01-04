package eserciziOOP;

import java.util.Date;
import java.util.Scanner;

public class DifferenzaDateV2 {
	public static void main(String[] args) {
		Date adesso = new Date();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserire ore: ");
		int ore = sc.nextInt();
		
		System.out.printf("Inserire minuti: ");
		int minuti = sc.nextInt();
		
		Date fine = new Date(adesso.getYear(), adesso.getMonth(), adesso.getDate(), ore, minuti);
		
		long difference_total = fine.getTime() - adesso.getTime();
		
		long difference_in_sec = (difference_total / 1000) % 60;
		long difference_in_min = (difference_total / (1000 * 60) % 60);
		long difference_in_hr = (difference_total / (1000 * 60 * 60));
		
		System.out.println("Alla fine della lezione mancano: ");
		System.out.println("- " + difference_in_hr);
		System.out.println("- " + difference_in_min);
		System.out.println("- " + difference_in_sec);
		
	}
}
