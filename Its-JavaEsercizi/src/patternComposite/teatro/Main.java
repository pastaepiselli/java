package patternComposite.teatro;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * La struttura ricreata e la seguente
		 * 
		 * 		S1
		 * 		|
		 * 		V
		 * S1-1	 S1-2  S1-3	Z1
		 * 	|	  |`	|	 
		 * 	V	  V		V	 
		 *Z2-Z3	Z4 S2-1 Z6
		 *
		 * NO AI TUTTO A MANO infatti non faccio i posti
		 *
		 *	output ho provato a indentare bene ma nn funziona molto bene
		 * 
		 */
		
		// creo settore principale
		SottoSettoreComposite sc = new SottoSettoreComposite("S1");
		
		// creo sottosettori
		SottoSettoreComposite sc1 = new SottoSettoreComposite("S1-1");
		SottoSettoreComposite sc2 = new SottoSettoreComposite("S1-2");
		SottoSettoreComposite sc3 = new SottoSettoreComposite("S1-3");
		SottoSettoreComposite sc4 = new SottoSettoreComposite("S2-1");
		
		// creo zone
		Zona z1 = new Zona("Z1");
		Zona z2 = new Zona("Z2");
		Zona z3 = new Zona("Z3");
		Zona z4 = new Zona("Z4");
		Zona z5 = new Zona("Z5");
		Zona z6 = new Zona("Z6");
		Zona z7= new Zona("Z7");
		
		// creo posti
		Posto p1 = new Posto('A', 1);
		Posto p2 = new Posto('A', 2);
		Posto p3 = new Posto('A', 3);
		Posto p4 = new Posto('A', 4);
		
		// aggiungo posti alle zone
		z1.addPosto(p1);
		z1.addPosto(p2);
		
		z2.addPosto(p3);
		
		z3.addPosto(p4);
		
		// aggiugo zone ai settori
		sc.add(z1);
		
		sc1.add(z2);
		sc1.add(z3);
		
		sc2.add(z4);
		
		sc3.add(z5);
		
		sc4.add(z6);
		sc4.add(z7);
		
		
		// aggiungo settori a settori
		sc.add(sc1);
		sc.add(sc2);
		sc.add(sc3);
		
		sc2.add(sc4);
		
		System.out.println(sc);
	}

}
