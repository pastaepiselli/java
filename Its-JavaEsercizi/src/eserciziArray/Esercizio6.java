package eserciziArray;

public class Esercizio6 {
	static void printList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	public static void main(String[] args) {
		int [] a = {10, 27, 13, 4, 6};
		
		System.out.println("Lista a vers 1");
		printList(a);
		
		for (int i = 0; i < a.length / 2; i++) {
			int temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}
		
		printList(a);
	}
}
