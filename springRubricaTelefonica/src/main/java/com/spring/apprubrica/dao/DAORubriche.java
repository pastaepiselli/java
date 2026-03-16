package com.spring.apprubrica.dao;

import java.util.List;

import com.spring.apprubrica.entity.ContattoTelefonico;
import com.spring.apprubrica.entity.Rubrica;

public interface DAORubriche {
	
	// metodi crud per le rubriche
	public void inserisci(Rubrica rubrica);
	public Rubrica cercaPerId(int id);
	public List<Rubrica> visualizzaRubriche();
	public void eliminaRubrica(int id);
	
	// metodi crud per i contatti
	public void inserisciContatto(int rubricaId, ContattoTelefonico contatto);
	public ContattoTelefonico cercaContatto(int rubricaId,int id);
	public ContattoTelefonico modificaContatto(int rubricaId, ContattoTelefonico nuovoContatto);
	public void eliminaContatto(int rubricaId, int id);
	public List<ContattoTelefonico> visualizzaContatti(int rubricaId);
	
	
	

	
}
