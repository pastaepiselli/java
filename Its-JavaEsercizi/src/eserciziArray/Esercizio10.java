package eserciziArray;

public class Esercizio10 {
	static void printList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
	public static void main(String[] args) {
		int[] a = {15, 6, 4, 10, 11, 2};
		System.out.println("Lista prima del bubble sort");
		printList(a);
		int temp;
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length - i; j++) {
				if (a[j - 1] > a[j]) {
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("Lista dopo il bubble sort");
		printList(a);
	}
}
