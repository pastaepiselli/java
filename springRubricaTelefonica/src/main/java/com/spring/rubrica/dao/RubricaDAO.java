package com.spring.rubrica.dao;

import java.util.List;

import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;

public interface RubricaDAO {
	// crud rubrica
	public Rubrica inserisci(Rubrica rubrica);
	public Rubrica cercaPerId(int idRubrica);
	public List<Rubrica> visualizzaRubriche();
	public Rubrica eliminaRubrica(int id);
	
	// crud contatti
	public Contatto inserisci(int idRubrica, Contatto contatto);
	public Contatto cercaContatto(int idRubrica, int idContatto);
	public List<Contatto> visualizzaContatti(int idRubrica);
	public Contatto eliminaContatto(int idRubrica, int idContatto);
	
	
	
	
}
