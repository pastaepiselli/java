package prenotazioneVoli;

import java.util.HashMap;

public class Assegnatore {
	private int postiDisponibili = 20;
	private HashMap<String,Integer> postiPrenotati = new HashMap<String,Integer>();
	
	// un solo thread alla volta entra in questo metodo con la keyword synchronized
	synchronized void assengnaPosti(String cliente, int numPosti) throws PostiNonDispException {
		if (numPosti <= postiDisponibili) {
			postiPrenotati.put(cliente, numPosti); // prenoto
			postiDisponibili -= numPosti; // scalo da quelli disponibili
		} else {
			throw new PostiNonDispException();
		}
	}
	
	synchronized int getTotalePosti() {
		return postiDisponibili;
	}
}
