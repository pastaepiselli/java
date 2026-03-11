package com.spring.magazzino.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Repository;

import com.spring.magazzino.entity.Prodotto;
import com.spring.magazzino.errori.IdEsistenteException;
import com.spring.magazzino.errori.ProdottoNonEsisteException;


@Repository
/*
 * repository e una specializzazione di componente serve ad indicare a spring la registrera come BEAN
 * e cosi potra essere iniettata nei componenti con autowired, in questo caso dao va iniettata in 
 * prodottoServiceImpl
 * 
 * repository implica anche il ruolo nella persistenza dei dati
 */
public class DAOProdottiImpl implements DAOProdotti {
	

	HashMap<Integer, Prodotto> mappa  = new HashMap<Integer, Prodotto>();
	@Override
	public void carica(Prodotto prodotto) { // torna void per permettere la gestione dell'errore
		if (mappa.containsKey(prodotto.getId())) { // chiave gia presente
			throw new IdEsistenteException("Prodotto con id: " + prodotto.getId() + " gia presente.");
		}
		mappa.put(prodotto.getId(), prodotto); // aggiungo

	}

	@Override
	public List<Prodotto> visualizzaProdotti() {
		// TODO Auto-generated method stub
		return new ArrayList<Prodotto>(mappa.values());
	}

	@Override
	public Prodotto cercaPerId(int id) {
		Prodotto prodotto = mappa.get(id);
		if (prodotto != null) {
			return prodotto;
		}
		throw new ProdottoNonEsisteException("Prodotto con id: " + id + " non esistente");
		
	}

}
