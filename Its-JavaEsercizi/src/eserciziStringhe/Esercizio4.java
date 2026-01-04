package eserciziStringhe;

import java.util.Scanner;

public class Esercizio4 {
	
	public static int find1(String str, char x){
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == x) {
				count++;
			}
		}
		return count;
		
	}
	
	public static int find2(String str, char x) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			int y = str.indexOf(x, i);
			if (y == -1) {
				break;
			}
			count++;
			i = y;
			
		}
		
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserire una stringa: ");
		String text = sc.next();
		
		System.out.print("Inserire un carattere da ricercare: ");
		char c = sc.next().charAt(0);
		
		System.out.println("Conta occorrenze con charAt: ");
		int o1 = find1(text, c);
		System.out.printf("Occorrenze: %d", o1);
		
		System.out.println();
		
		System.out.println("Conta occorrenze con indexOf: ");
		int o2 = find2(text, c);
		System.out.printf("Occorrenze: %d", o2);
	}
}
