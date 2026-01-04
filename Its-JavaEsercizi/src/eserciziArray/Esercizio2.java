package eserciziArray;

public class Esercizio2 {
	static void printList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] array1 = {10, 27, 13, 4};
		
		System.out.println("Array n.1");
		printList(array1);
		
		int[] array2 = new int[array1.length];
		
		for (int i = array2.length - 1; i >= 0; i--) {
			array2[i] = array1[array1.length - 1 - i];
		}
		
		System.out.println("Lista 2");
		printList(array2);
		
		// forse so perche funziona
		
	}
}
