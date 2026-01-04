package eserciziArray;

public class Esercizio4 {
	public static void main(String[] args) {
		int[] a = {7, 8, 3, 0, 2};
		
		int somma = 0;
		for (int num : a) {
			somma += num;
		}
		
		int sommaPari = 0;
		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				sommaPari += a[i];
			}
		}
		
		int sommaDispari = 0;
		for (int i = 0; i < a.length; i++) {
			if (i % 2 != 0) {
				sommaDispari += a[i];
			}
		}
		
		double mediaAritmetica = somma / a.length;
		
		System.out.println("Somma = " + somma);
		System.out.println("Somma pari = " + sommaPari);
		System.out.println("Somma dispari = " + sommaDispari);
		System.out.println("Media artimetica = " + mediaAritmetica);
		
	}
}
