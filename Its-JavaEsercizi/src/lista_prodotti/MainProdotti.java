
package lista_prodotti;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainProdotti {
	public static void main(String[] args) {
		ArrayList<Prodotto> catalogo = new ArrayList<Prodotto>();
		catalogo.add(new Prodotto(133, "latte", Categoria.alimentare, 100, true, 2.5, 0));
		catalogo.add(new Prodotto(134, "latte UHT", Categoria.alimentare, 0, false, 2.5, 0));
		catalogo.add(new Prodotto(113, "pomodori", Categoria.alimentare, 50, true, 1.5, 5));
		catalogo.add(new Prodotto(123, "libro", Categoria.media, 10, true, 10, 5));
		catalogo.add(new Prodotto(155, "maglietta", Categoria.abbigliamento, 20, true, 25, 10));
		catalogo.add(new Prodotto(184, "cd musicale", Categoria.media, 0, false, 12.5, 0));
		catalogo.add(new Prodotto(143, "smartphone", Categoria.elettronica, 80, true, 250, 10));
		catalogo.add(new Prodotto(144, "cuffie", Categoria.elettronica, 0, false, 250, 10));


		Stream<Prodotto> a = catalogo.stream();
		// 1 numero di categorie
		long numeroCategorie = a.map((p) -> p.getCategoria()).distinct().count();

		System.out.println("Numero totale di categorie: " + numeroCategorie);

		Stream<Prodotto> b = catalogo.stream();

		// 2 categorie in ordine alfabetico no doppie
		List<Categoria> categorie = b.map((p) -> p.getCategoria())
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Tutte le categorie in ordine alfabetico" + categorie);

		// 3 nomi prodotti per prezzo crescente
		List<String> nomiProdottiPrezzoCrescente = catalogo.stream()
				.sorted(Comparator.comparingDouble((p) -> p.getPrezzo() ))
				.map((p) -> p.getDescrizione())
				.collect(Collectors.toList());
		System.out.println("Nomi prodotti per prezzo crescente: " + nomiProdottiPrezzoCrescente);

		// 4 prodotti ordinati in base allo sconto
		List<Prodotto> prodottiOrdinatiSconto = catalogo.stream()
				.sorted(Comparator.comparingInt((p) -> p.getPercentuale()))
				.collect(Collectors.toList());

		System.out.println("Prodotti ordinati per sconto: " + prodottiOrdinatiSconto);
		
		// 5 prodotto con lo sconto maggiore
		Prodotto prodottoMaggioreSconto = catalogo.stream()
				.max(Comparator.comparingInt((p) -> p.getPercentuale())).get();
		
		System.out.println("Prodotto con maggiore sconto: " + prodottoMaggioreSconto.getDescrizione());
			
		// 6 somma dei prezzi dei prodotti alimentari
		Optional<Double> sommaPrezziProdottiAlimentari = catalogo.stream()
				.filter((p) -> p.getCategoria().equals(Categoria.alimentare))
				.map((p) -> p.getPrezzo())
				.reduce((p1, p2) -> (p1 + p2));
		
		System.out.println("Somma prezzi prodotti alimentari: " + sommaPrezziProdottiAlimentari.get());
		
		// 7 optionla vuoto a seguito di ricerca prodotto categoria inesistente
		Optional<Prodotto> categoriaInesistente = catalogo.stream()
				.filter((p) -> p.getCategoria().equals(Categoria.nonEsiste))
				.findFirst();
		
		System.out.println(categoriaInesistente);
		
		// 8 il prodotto con il prezzo piu alto nella categoria media
		Prodotto prodottoPrezzoPiuAltoCategoriaMedia = catalogo.stream()
				.filter((p) -> p.getCategoria().equals(Categoria.media))
				.max(Comparator.comparingDouble((p) -> p.getPrezzo())).get();
		
		System.out.println("Prodotto prezzo piu alto: " + prodottoPrezzoPiuAltoCategoriaMedia);
		
		// 9 nomi dei prodotti non disponibili
		List<String> nomiProdottiNonDisponibili = catalogo.stream()
				.filter((p) -> !p.isDisponibilita())
				.map((p) -> p.getDescrizione())
				.collect(Collectors.toList());
		
		System.out.println(nomiProdottiNonDisponibili);
		
			




	}
}