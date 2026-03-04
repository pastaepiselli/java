package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.entity.Studente;

public class StudentiDAO {
	Map<String, Studente> mappa = new HashMap<String, Studente>();
	
	// inserisci nuovo studente
	public boolean inserisciStudente(Studente studente) {
		if (mappa.containsKey(studente.getMatricola())) {
			return false;
		}
		mappa.put(studente.getMatricola(), studente);
		return true;
	}
	
	// cerca studente per matricola
	public Studente cercaPerMatricola(String matricola) {
		return mappa.get(matricola);
	}
	
	// visualizza tutti gli studenti
	public List<Studente> visualizzaStudenti(){
		return new ArrayList<Studente>(mappa.values());
	}
	
	// cancella uno studente
	public boolean cancella(String matricola) {
		if (mappa.containsKey(matricola)) {
			mappa.remove(matricola);
			return true;
		}
		return false;
	}
	
	// modifica indirizzo studente
	public Studente modificaIndirizzo(String matricola, String nuovoIndirizzo) {
		Studente studente = mappa.get(matricola);
		studente.setIndirizzo(nuovoIndirizzo);
		return studente;
	}
	
}
