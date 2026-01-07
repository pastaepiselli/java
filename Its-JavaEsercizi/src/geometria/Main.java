package geometria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String figura;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Quale figura vuoi creare? (1: rettangolo, 2: cerchio, (default=cerchio)): ");

			int scelta = sc.nextInt();

			if (scelta == 1) {
				System.out.print("Inserire base: ");
				int base = sc.nextInt();


				System.out.println();

				System.out.print("Inserire altezza: ");
				int altezza = sc.nextInt();

				Rettangolo ret = new Rettangolo(base, altezza);
				figura = "Rettangolo";

				System.out.println("Vuoi calcolare area o perimetro?: ");

				String calcolo = sc.next();

				while (true) {
					if (calcolo.equalsIgnoreCase("area")) {

						System.out.printf("L'area del rettagolo e di %d m2", ret.calcolaArea());
						break;

					} else if (calcolo.equalsIgnoreCase("perimetro")) {

						System.out.printf("Il perimetro del rettangolo e di %d", ret.calcolaPerimetro());
						break;
					} else {
						System.out.println("Inserire un'operazione valida!");
					}
				}

			} else  {
				System.out.print("Inserire raggio del cerchio: ");
				int raggio = sc.nextInt();

				Cerchio cer = new Cerchio(raggio);
				figura = "Cerchio";
			}
		}
	}
}


