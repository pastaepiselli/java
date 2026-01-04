package eserciziArray;

public class Esercizio7 {
	public static void main(String[] args) {
		int[] a = {3, 8, 4, 1, 6, 9, 2};
		int[] b = {5, 8, 2, 6};
		
		for (int i = 0;  i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) System.out.println(a[i]);
			}
		}
		
		
	}
}
