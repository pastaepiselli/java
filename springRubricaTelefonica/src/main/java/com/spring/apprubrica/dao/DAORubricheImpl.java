package com.spring.apprubrica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.apprubrica.entity.Rubrica;
import com.spring.apprubrica.errors.IdGiaEsistente;
import com.spring.apprubrica.errors.IdNonEsistente;


@Repository
public class DAORubricheImpl implements DAORubriche {
	// dove simulo la persistenza delle rubriche
	Map<Integer, Rubrica> mappa = new HashMap<Integer, Rubrica>();

	@Override
	public void inserisci(Rubrica rubrica) {
		if (mappa.containsKey(rubrica.getId())) {
			throw new IdGiaEsistente("Rubrica con id: " + rubrica.getId() + " gia esistente.");
		}
		mappa.put(rubrica.getId(), rubrica);
	}

	@Override
	public Rubrica cercaPerId(int id) {
		return mappa.get(id);
	}

	@Override
	public List<Rubrica> visualizzaRubriche() {
		return new ArrayList<Rubrica>(mappa.values());
	}

	@Override
	public void eliminaRubrica(int id) {
		if (mappa.containsKey(id)) {
			mappa.remove(id);
		} else {
			throw new IdNonEsistente("Rubrica con id: " + id + " non esistente.");
		}
		
	}
	
	// TODO: metodi crud per i contatti

	
	
	

}
