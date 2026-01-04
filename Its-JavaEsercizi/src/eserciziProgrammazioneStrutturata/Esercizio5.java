package eserciziProgrammazioneStrutturata;

import java.util.Scanner;

public class Esercizio5 {
	static double radiceQuadrata(double n) {
		if (n == 0) return 0.0;
		double x = n;
		double y = 1;
		double precisione = 0.000001;
		while ((x - y) > precisione) {
			x  = (x + y) / 2;
			y = n / x;
			
		}
		return x;
	}
	
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
		
		// ottenere la lunghezza di tutti i lati 
		double ab = ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		
		// ora per calcolare la radice quadrata
		ab = radiceQuadrata(ab);
		
		double ac = x2 - x1;
		
		double bc = y2 - y1;
		
		// perimetro e area 
		double perimetro = ab + ac + bc;
		double area = (bc * ac) / 2;
		
		System.out.println("Perimetro triangolo " + perimetro);
		System.out.printf("Area triangolo = %f", area);
		
		
		
		
		s.close();
	}
}
