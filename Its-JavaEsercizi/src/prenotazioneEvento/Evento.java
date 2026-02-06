package prenotazioneEvento;

import java.time.LocalDate;
import java.util.ArrayList;

public class Evento {
	private String nome;
	private LocalDate data;
	private ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	private boolean chiuso = false;
	public Evento(String nome, LocalDate data) {
		super();
		this.nome = nome;
		this.data = data;
	}
	public LocalDate getData() {
		return data;
	}
	
	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	public void aggiungiPrenotazione(ArrayList<Posto> pren, String email) {
		// controlli
		if (pren == null || email == null) {
			throw new NullPointerException();
		}
		
		if (email.isEmpty()) {
			// errore personalizzato email vuota
		}
		
		if (pren.size() == 0) {
			// errore personalizzato prenotazione vutoa
		}
		
		// controllo email esista gia nella prenotazione
		for(Prenotazione p : prenotazioni) {
			if (p.getEmail().equals(email)) {
				// errore personalizzato email gia esistente
			}
		}
		// creo prenotazione
		Prenotazione p = new Prenotazione(email, pren);
		prenotazioni.add(p);
	}
	
	public void annullaPrenotazione(String email) throws Exception {
		if (email == null) {
			throw new NullPointerException();
		}
		
		if (email.isEmpty()) {
			throw new IllegalAccessException("Email non puo essere vuota");
		}
		
		Prenotazione pren = null;
		
		for (Prenotazione p : prenotazioni) {
			if (p.getEmail().equals(email)) {
				pren = p;
			}
		}
		
		if (pren == null){
			// errore personalizzato
		}
		
		prenotazioni.remove(pren);
	}
	
	
	
	
	
}
