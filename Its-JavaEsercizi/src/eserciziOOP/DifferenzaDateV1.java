package eserciziOOP;

import java.util.Date;

public class DifferenzaDateV1 {
	public static void main(String[] args) {
		
		// ora
		Date adesso = new Date();
		
		// fine, prendendo giono mese anno dalla data di oggi
		Date fine = new Date(adesso.getYear(), adesso.getMonth(), adesso.getDate(), 19, 30);
		
		// differenza totale in millisecondi
		// .getTime ritorna il millisecondi da 1900 fino alla data
		long difference_total = fine.getTime() - adesso.getTime();
		
		// formula che passa da millisecondi ad sec a min e hr cosi via
		long difference_in_sec = (difference_total / 1000) % 60;
		long difference_in_min = (difference_total / (1000 * 60) % 60);
		long difference_in_hr = (difference_total / (1000 * 60 * 60));
		
		// printo tutto
		System.out.println("Alla fine della lezione mancano: ");
		System.out.println("- " + difference_in_hr);
		System.out.println("- " + difference_in_min);
		System.out.println("- " + difference_in_sec);
		
		
		
	}
}
