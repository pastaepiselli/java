package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GestoreMele {

	public static void main(String[] args) {
		// creo una lista di mele
		ArrayList<Mela> cassetta = new ArrayList<Mela>();
		cassetta.add(new Mela("Rossa", 100));
		cassetta.add(new Mela("Verde", 150));
		cassetta.add(new Mela("Gialla", 120));
		cassetta.add(new Mela("Gialla", 140));
		cassetta.add(new Mela("Verde", 150));
		cassetta.add(new Mela("Rossa", 150));
		cassetta.add(new Mela("Gialla", 100));

		// filtro x colore verde
		List<Mela> risultato = filtraPerColore(cassetta);
		System.out.println(risultato.size());
		System.out.println("solo mele verdi");
		for (Mela mela : risultato) {
			System.out.println(mela);
		}

		// filtro x peso >= 150
		risultato = filtraPerColore(cassetta);
		System.out.println(risultato.size());
		System.out.println("solo mele con peso >= 150");
		for (Mela mela : risultato) {
			System.out.println(mela);
		}
		
		
		
//		risultato = filtraMele(cassetta, new CriterioPeso());
//		System.out.println("nuovo metodo");
//		for (Mela mela : risultato) {
//			System.out.println(mela);
//		}
//		
//		risultato = filtraMele(cassetta, (mela) -> mela.getColore().equals("Gialla") && mela.getPeso() == 100);
//		for (Mela mela : risultato) {
//			System.out.println(mela);
//		}
			
			
		
	}

	public static List<Mela> filtraPerColore(List<Mela> cassetta){
		ArrayList<Mela> listaFiltrata = new ArrayList<Mela>();

		for (Mela mela : cassetta) {
			if (mela.getColore().equals("Verde")) {
				listaFiltrata.add(mela);
			}
		}

		return listaFiltrata;
	}

	public static List<Mela> filtraPerPeso(List<Mela> cassetta){
		ArrayList<Mela> listaFiltrata = new ArrayList<Mela>();

		for (Mela mela : cassetta) {
			if (mela.getPeso() >= 150) {
				listaFiltrata.add(mela);
			}
		}

		return listaFiltrata;
	}
	
//	public static List<Mela> filtraMele(List<Mela> cassetta, Predicate criterio) {
//		ArrayList<Mela> filtrata = new ArrayList<Mela>();
//		for (Mela mela : cassetta) {
//			if (criterio.test(mela)) { // se il criterio da true
//				filtrata.add(mela);
//			}
//		}
//		return filtrata;
//	}

}
