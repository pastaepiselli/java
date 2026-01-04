package eserciziArray;

public class Esercizio8 {
	
	public static void main(String[] args) {
		int[] b = {9, 5, 2, 1};
		int[] a = {9, 1, 3, 8, 24, 2};
		
		boolean trovato;
		for (int i = 0; i < b.length; i++) {
			trovato = false;
			for (int j = 0; j < a.length; j++) {
				if (b[i] == a[j]) {
					trovato = true;
					break;}
			}
			
			if (!trovato) {
				System.out.println(b[i]);
			}
		
	}
}
}
