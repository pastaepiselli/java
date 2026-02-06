package museo;

import java.util.HashSet;
import java.util.TreeSet;

import javax.management.InstanceAlreadyExistsException;

public class Museo {
	private HashSet<Opera> esposte = new HashSet<Opera>(); // hash set per quelle esposte
	private TreeSet<Opera> magazzino = new TreeSet<Opera>(); // treeset per organizzare per codice quelle in mag
	private int max_opere;
	
	public Museo(int max_opere){
		this.max_opere = max_opere;
	}
	
	public int getMax_opere() {
		return max_opere;
	}

	public void setMax_opere(int max_opere) {
		this.max_opere = max_opere;
	}

	public void carica(Opera o) throws InstanceAlreadyExistsException {
		if (esposte.size() >= max_opere) { // non ce spazio
			o.setStato(StatoOpera.NonEsposta); // non viene esposta
			if (!magazzino.add(o)) {
				throw new InstanceAlreadyExistsException("Opera gia esiste nel magazzino");
			}
		} else {
			o.setStato(StatoOpera.Esposta);
			if (!esposte.add(o)) {
				throw new InstanceAlreadyExistsException("Opera gia esposta");
			}
		}
	}	
	// codice ho creato una stringa per distinguere gra quadri e statue
	public Opera sposta(String codice) { // se non trova ritorna null
		Opera muovere = null;
		for (Opera o : esposte) {
			if (o.getCodice().equals(codice)) { // se la trova
				muovere = o;
				break; // trovata esco dal ciclo
			}
		}
		if (muovere == null) { // se ancora null (non trovato)
			return null;
		}else {
			muovere.setStato(StatoOpera.NonEsposta); // imposta stato a nonEsposta
			esposte.remove(muovere); // rimuovo da esposizione
			magazzino.add(muovere); // aggiungo a magazziono
			return muovere; // ritorno muovere
		}
	}
	
	public Opera cerca(String codice) {
		for (Opera o : esposte) { // controlla prima in esposte
			if (o.getCodice().equals(codice)) {
				return o;
			}
		}
		for (Opera o: magazzino) { // poi in magazzino
			if (o.getCodice().equals(codice)) {
				return o;
			}
		}
		return null; // sen no trova nessuno ritorna null
	}
	
	public String stampaSala() {
		String sala = "";
		for (Opera o : esposte) {
			sala += o.getTitolo() + "\n"; // mando a capo ogni iterazione
		}
		return sala;
	}
	
	public String stampaDeposito() {
		String deposito = "";
		for (Opera o : magazzino) {
			deposito += o.getTitolo() + "\n";
		}
		return deposito;
	}
	
}
