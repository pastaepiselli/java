package com.spring.utenti.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.spring.utenti.entity.Utente;


public class DAOUtenteMappa {

	private Map<Integer, Utente> mappa = new HashMap<>();
	
	public DAOUtenteMappa() {
		mappa.put(1, new Utente(1, "Marco", "PierLeoni", "marcoP@gmail.com", "1321321321"));
		mappa.put(2, new Utente(2, "Pier", "Damien", "pierD@gmail.com", "12332131"));
		mappa.put(3, new Utente(3, "Ale", "Cole", "aleC@libero.it", "11233121"));
		mappa.put(4, new Utente(3, "Barbara", "Cole", "barbraraC@gmail.com", "11233121"));
		
		
		
	}

	public boolean insert(Utente utente) {
		if(mappa.containsKey(utente.getIdUtente()))
			return false;
		
		mappa.put(utente.getIdUtente(), utente);
		return true;

	}
	public List<Utente> selectAll(){
		return new ArrayList<>(mappa.values());
	}

	public Utente selectById(Integer idUtente) {
		return mappa.get(idUtente);
	}
	
	public Utente delete(Integer idUtente) {
		Utente utente = mappa.remove(idUtente);
		return utente;
	}
	
	public Utente updateEmail(int id, String newEmail) {
		Utente ut = mappa.get(id);
		ut.setEmail(newEmail);
		return ut;
	}
	
	
	
	

} 
