package eserciziArray;

public class Esercizio5 {
	public static void main(String[] args) {
		int[] a  = {6, 7, 3, 1, 7, 9,};
		
		for (int i = 0; i < a.length / 2; i++) {
			System.out.println(a[i]);
			System.out.println(a[a.length - 1 - i]);
			
		}
	}
}
