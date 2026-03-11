package com.spring.magazzino.dto;


import java.util.List;
import java.util.Map;

/*
 * La classe reportDTO serve solo per scambiare "statistiche"
 * su tutti i prodotti caricati
 */
public class ReportDTO {
	private List<String> elencoDescrizioni;
	private int totalePezzi;
	private int totaleProdottiNonDisponibili;
	private double mediaPrezziConsigliati;
	private List<String> elencoModelliNonDisponibili;

	
	 // opzionale
	private Map<String, List<Integer>> elencoIdPerCategoria;
	public ReportDTO(List<String> elencoDescrizioni, int totalePezzi, int totaleProdottiNonDisponibili,
			double mediaPrezziConsigliati, List<String> elencoModelliNonDisponibili, 
			Map<String, List<Integer>> elencoIdPerCategoria) {
		super();
		this.elencoDescrizioni = elencoDescrizioni;
		this.totalePezzi = totalePezzi;
		this.totaleProdottiNonDisponibili = totaleProdottiNonDisponibili;
		this.mediaPrezziConsigliati = mediaPrezziConsigliati;
		this.elencoModelliNonDisponibili = elencoModelliNonDisponibili;
		this.elencoIdPerCategoria = elencoIdPerCategoria;
	}
	public List<String> getElencoDescrizioni() {
		return elencoDescrizioni;
	}
	public void setElencoDescrizioni(List<String> elencoDescrizioni) {
		this.elencoDescrizioni = elencoDescrizioni;
	}
	public int getTotalePezzi() {
		return totalePezzi;
	}
	public void setTotalePezzi(int totalePezzi) {
		this.totalePezzi = totalePezzi;
	}
	public int getTotaleProdottiNonDisponibili() {
		return totaleProdottiNonDisponibili;
	}
	public void setTotaleProdottiNonDisponibili(int totaleProdottiNonDisponibili) {
		this.totaleProdottiNonDisponibili = totaleProdottiNonDisponibili;
	}
	public double getMediaPrezziConsigliati() {
		return mediaPrezziConsigliati;
	}
	public void setMediaPrezziConsigliati(double mediaPrezziConsigliati) {
		this.mediaPrezziConsigliati = mediaPrezziConsigliati;
	}
	public List<String> getElencoModelliNonDisponibili() {
		return elencoModelliNonDisponibili;
	}
	public void setElencoModelliNonDisponibili(List<String> elencoModelliNonDisponibili) {
		this.elencoModelliNonDisponibili = elencoModelliNonDisponibili;
	}
	public Map<String,List<Integer>> getElencoIdPerCategoria() {
		return elencoIdPerCategoria;
	}
	public void setElencoIdPerCategoria(Map<String, List<Integer>> elencoIdPerCategoria) {
		this.elencoIdPerCategoria = elencoIdPerCategoria;
	}
	
	
	
	
	
	
	
}
