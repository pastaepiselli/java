package eserciziProgrammazioneStrutturata;

import java.util.Scanner;

public class Esercizio4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// input coordinate
		System.out.print("Inserire x1: ");
		float x1 = s.nextFloat();
		
		System.out.print("Inserire y1: ");
		float y1 = s.nextFloat();
		
		System.out.print("Inserire x2: ");
		float x2 = s.nextFloat();
		
		System.out.print("Inserire y2: ");
		float y2 = s.nextFloat();
		
		// si puo ottenere quadrato?
		
		float base = x2 - x1;
		float altezza = y2 - y1;
		
		// definisco le variabili senno vengono definite solo nell if
		String tipo;
		float perimetro;
		float area;
		
		if (base == altezza) {
			tipo = "Quadrato";
			perimetro = base * 2;
			area = base * base;
		} else {
			tipo = "Rettangolo";
			perimetro = (base + altezza) * 2;
			area = base * altezza;
		}
		
		System.out.printf("Tipo figura = %s%n", tipo);
		System.out.printf("Perimetro figura = %f%n1", perimetro);
		System.out.printf("Area figura = %f", area);
		s.close();
	}

}
