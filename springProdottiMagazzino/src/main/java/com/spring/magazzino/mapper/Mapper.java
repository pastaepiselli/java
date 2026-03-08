package com.spring.magazzino.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.spring.magazzino.dto.ProdottoDTO;
import com.spring.magazzino.dto.ReportDTO;
import com.spring.magazzino.entity.Prodotto;

/*
 * classe in cui avvengono sia le conversioni da Dto -> entity e viceversa
 * in questo caso in questa classe verra anche generato la lista di di elementi
 * da caricare nei metodi statici del reportDTO :P
 */
public class Mapper {
	
	public static ProdottoDTO daProdottoAProdottoDTO(Prodotto prodotto) {
		return new ProdottoDTO(prodotto.getId(), 
				prodotto.getMarca(), 
				prodotto.getModello(), 
				prodotto.getDescrizione(), 
				prodotto.getPrezzo_consigliato(), 
				prodotto.getPrezzo_massimo(), 
				prodotto.getQuantita(),
				prodotto.getCategoria()
				);
	}
	
	public static ProdottoDTO daProdottoDTOAProdotto(ProdottoDTO dto) {
		return new ProdottoDTO(dto.getId(), 
				dto.getMarca(), 
				dto.getModello(), 
				dto.getDescrizione(), 
				dto.getPrezzo_consigliato(), 
				dto.getPrezzo_massimo(), 
				dto.getQuantita(),
				dto.getCategoria()
				);
	}
	
	public static ReportDTO generaReportDaProdotti(Collection<Prodotto> prodotti) {
		// qua creo tutti gli attributi necessari per creare il reportDTO e poi inserisco
		
		// 1) elenco con tutte le descrizioni
		List<String> descrizioneProdotti = prodotti.stream()
				.map(p -> p.getDescrizione())
				.collect(Collectors.toList());
		
		// 2) somma totale delle quantita
		int totaleQuantita = prodotti.stream()
				.map(p -> p.getQuantita())
				/* 
				 * reduce (quantita da dove parte (quello che ritorna nel caso la lista sia vuota), 
				 * 			lambda in cui e definito il calcolo, accumulatore + valore attuale iterato)
				 */
				.reduce(0, (tot , p) -> tot + p);
		
		//3) numero totale dei prodotti non disponibili
		List<Prodotto> listaProdottiNonDisponibili  = prodotti.stream()
				.filter(p -> p.getQuantita() == 0) // prodotto non disponibile
				.collect(Collectors.toList());
		// la lunghezza della lista dei prodotti non disponibili
		int numeroProdottiNonDisponibili = listaProdottiNonDisponibili.size();
		
		// 4) media prezzo consigliato
		double sommaPrezzoConsigliato = prodotti.stream()
				.mapToDouble(p -> p.getPrezzo_consigliato()) // con mapToDouble evito autoBoxing
				.sum();
		
		double mediaPrezzoConsigliato = sommaPrezzoConsigliato / prodotti.size();
		
		// 5) elenco modelli prodotti non disponibili 
		
		List<String> elencoModelliProdottiNonDisponibili = prodotti.stream()
				.filter(p -> p.getQuantita() == 0)
				.map(p -> p.getModello())
				.collect(Collectors.toList());
		
		// TODO: Ultimo medoto e creazione della classe reportDTO
				
				
				
		
	
		


	}
	
	
 
}
