package prenotazioneEvento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

public class GestorePrenotazioni {
	private ArrayList<Posto> location = new ArrayList<Posto>();
	private TreeMap<LocalDate, Evento> eventi = new TreeMap<LocalDate, Evento>();
	
	// nessun costruttore
	
	public void creaEvento(String nome, LocalDate data) {
		// cotrolli
		if (nome == null || data == null) {
			throw new NullPointerException();
		}
		
		if (nome.isEmpty()) {
			throw new IllegalArgumentException("Nome evento non puo essere una stringa vuota");
		}
		
		// creo evento
		Evento e = new Evento(nome, data);
		if (eventi.containsKey(e.getData())) {
			// errore personalizzato data gia occupata da altro evento
		}
		
		eventi.put(e.getData(), e);
	}
	public void aggiungiPrenotazione(LocalDate data, int numPosti, String email) {
		if (email == null || data == null) {
			throw new NullPointerException();
		}
		
		if (numPosti <= 0) {
			// errore personalizzato
		}
		
		if (email.isEmpty()) {
			// errore personalizzato
		}
		
		Evento e = eventi.get(data);
		
		if (e == null) {
			throw new NullPointerException();
		}
		
		// posti trovati
		ArrayList<Posto> postiTrovati = new ArrayList<Posto>();
		
		// controllo per i posti
		for (Posto p : location) {
			
			if (postiTrovati.size() == numPosti) { // tutti posti trovati
				break;
			}
			
			
			if (!p.isOccupato()) { // il posto non e occupto
				postiTrovati.add(p); // aggiungo ai posti
				p.setOccupato(true); // il posto non e disponibile
			}
		}
		
		e.aggiungiPrenotazione(postiTrovati, email);
		
	}
	
	public void annullaPrenotazione(String email, LocalDate data) {
		if (email == null || data == null) {
			throw new NullPointerException();
		}
		
		if (email.isBlank()) {
			throw new IllegalArgumentException();
		}
		
		Evento e = eventi.get(data);
		
		if (e == null) {
			// evento non esistente
		}
		
		// lista di prenotazioni con detro i posti
		ArrayList<Prenotazione> listaPren = e.getPrenotazioni();
		
		// devo prendere la prenotazione corretta grazie all'email
		Prenotazione pren = null;
		for(Prenotazione p : listaPren) {
			if (p.getEmail() == email) { // se trova la prenotazione
				pren = p; // asseggna
			}
		}
		
		// controllo se non trovata
		if (pren == null) {
			// prenotazione non trovata
		}
		
		// devo disattivare is occupato
		for (Posto p1: pren.getPosti()) {
			for (Posto p2 : location) {
				if (p1.equals(p2)) {
					p2.setOccupato(false);
				}
			}
		}
				
		// annullo la prenotazione
		try {
			e.annullaPrenotazione(email);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	// mi serve il diagramma x continuare e non lo ho il diagramma
	public void annullaEvento() {
		
	}
	
}
