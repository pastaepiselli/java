package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.universita.entity.Professore;

public class ProfessoriDAO {
	Map<Integer, Professore> mappa = new HashMap<Integer, Professore>();
	
	
	public boolean inserisciProfessore(Professore professore) {
		if (mappa.containsKey(professore.getId())) {
			return false;
		}	
		mappa.put(professore.getId(), professore);
		return true;
	}
	
	public Professore cercaPerId(int id) {
		return mappa.get(id);
	}

	public List<Professore> visualizzaProfessori(){
		return new ArrayList<Professore>(mappa.values());
	}
	
	public boolean cancella(int id) {
		if (mappa.containsKey(id)) {
			mappa.remove(id);
			return true;
		}
		return false;
		
	}
	
	public Professore modificaMateria(int id, String nuovaMateria) {
		Professore professore = mappa.get(id);
		professore.setMateriaInsegnamento(nuovaMateria);
		return professore;
	}
}
