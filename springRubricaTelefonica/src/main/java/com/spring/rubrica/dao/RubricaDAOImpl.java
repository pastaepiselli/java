package com.spring.rubrica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;
import com.spring.rubrica.errori.ContattoEsistenteException;
import com.spring.rubrica.errori.IdEsisteException;
import com.spring.rubrica.errori.IdNonEsisteException;

@Repository
public class RubricaDAOImpl implements RubricaDAO {
	private Map<Integer, Rubrica> mappa = new HashMap<Integer, Rubrica>();

	@Override
	public Rubrica inserisci(Rubrica rubrica) {
		if (mappa.containsKey(rubrica.getId())) {
			throw new IdEsisteException("Rubrica con id: " + rubrica.getId() + " gia esiste.");
		}
		mappa.put(rubrica.getId(), rubrica);
		return rubrica;
	}

	@Override
	public Rubrica cercaPerId(int idRubrica) {
		Rubrica rubrica = mappa.get(idRubrica);
		
		if (rubrica == null) {
			throw new IdNonEsisteException("Rubrica con id: " + idRubrica + " non esiste.");
		}
		return rubrica;
	}

	@Override
	public List<Rubrica> visualizzaRubriche() {
		return new ArrayList<Rubrica>(mappa.values());
	}

	@Override
	public Rubrica eliminaRubrica(int id) {
		if (mappa.containsKey(id)) {
			return mappa.remove(id);
			
		}
		throw new IdNonEsisteException("Rubrica con id: " + id + " non esiste.");
	}

	@Override
	public Contatto inserisci(int idRubrica, Contatto contatto) {
		Rubrica rubrica = cercaPerId(idRubrica);
		if (rubrica.getContatti().containsKey(contatto.getId())) {
			throw new IdEsisteException("Contatto con id: " + contatto.getId() + " gia presente nella rubrica");
		}
		boolean duplicato = rubrica.getContatti()
				.values()
				.stream()
				.anyMatch(c -> c.equals(contatto));
		if (duplicato) {
			throw new ContattoEsistenteException(contatto.getNome() + " " + contatto.getCognome() + " gia e presente in questa rubrica");
		}
		
		rubrica.getContatti().put(contatto.getId(), contatto);
		return contatto;
		
		
	}

	@Override
	public Contatto cercaContatto(int idRubrica, int idContatto) {
		Rubrica rubrica = cercaPerId(idRubrica);
		
		Contatto contatto = rubrica.getContatti().get(idContatto);
		if (contatto == null) {
			throw new IdNonEsisteException("Contatto con id: " + idContatto +  " non esiste.");
		}
		return contatto;
	}

	@Override
	public List<Contatto> visualizzaContatti(int idRubrica) {
		Rubrica rubrica = cercaPerId(idRubrica);
		return new ArrayList<Contatto>(rubrica.getContatti().values());
	}

	@Override
	public Contatto eliminaContatto(int idRubrica, int idContatto) {
		Rubrica rubrica = cercaPerId(idRubrica);
		
		Contatto eliminato = rubrica.getContatti().remove(idContatto);
		if (eliminato == null) {
			throw new IdNonEsisteException("Contatto con id: " + idContatto + " non esiste.");
		}
		
		return eliminato;
	}
	
	

}
