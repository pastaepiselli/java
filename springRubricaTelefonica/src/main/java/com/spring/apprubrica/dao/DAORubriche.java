package com.spring.apprubrica.dao;

import java.util.List;

import com.spring.apprubrica.entity.Rubrica;

public interface DAORubriche {
	public void inserisci(Rubrica rubrica);
	public Rubrica cercaPerId(int id);
	public List<Rubrica> visualizzaRubriche();
	public void eliminaRubrica(int id);

	
}
