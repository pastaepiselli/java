package com.spring.apprubrica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.apprubrica.entity.ContattoTelefonico;
import com.spring.apprubrica.entity.Rubrica;
import com.spring.apprubrica.errors.ContattoEsistente;
import com.spring.apprubrica.errors.ContattoNonEsiste;
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
		Rubrica rubrica = mappa.get(id);
		if (rubrica == null) {
			throw new IdNonEsistente("Rubrica con id: " + id + " non esistente");
		}
		
		return rubrica;
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

	@Override
	public void inserisciContatto(int rubricaId, ContattoTelefonico contatto) {
		Rubrica r = cercaPerId(rubricaId);
		
		
		// controllo che il contatto nome e cognome non sia gia esistente
		boolean contattoEsiste = r.getContatti()
				.values()
				.stream()
				.anyMatch(c -> c.equals(contatto));
		if (contattoEsiste) {
			throw new ContattoEsistente(contatto.getNome() + contatto.getCognome() + " gia esiste in questa rubrica!");
		}
		
		r.getContatti().put(contatto.getId(), contatto);	
	}

	@Override
	public ContattoTelefonico cercaContatto(int rubricaId, int id) {
		Rubrica r = cercaPerId(rubricaId);
		
		ContattoTelefonico c = r.getContatti().get(id);
		if (c == null) {
			throw new IdNonEsistente("Contatto con id: " + id + " non esiste");
		}
		return c;
	}

	@Override
	public ContattoTelefonico modificaContatto(int rubricaId, ContattoTelefonico nuovoContatto) {
		Rubrica r = cercaPerId(rubricaId);
		if (!r.getContatti().containsKey(nuovoContatto.getId())) {
			throw new IdNonEsistente("Contatto con id: " + nuovoContatto.getId() + " non esistente.");
		}
		r.getContatti().put(nuovoContatto.getId(), nuovoContatto);
		return nuovoContatto;
	}

	@Override
	public void eliminaContatto(int rubricaId, int id) {
		Rubrica r = cercaPerId(rubricaId);
		r.getContatti().remove(id);
		
	}

	@Override
	public List<ContattoTelefonico> visualizzaContatti(int rubricaId) {
		Rubrica r = cercaPerId(rubricaId);
		return new ArrayList<ContattoTelefonico>(r.getContatti().values());
	}

	
	
	

	
	
	

}
