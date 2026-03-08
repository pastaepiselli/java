package com.spring.magazzino.dao;

import java.util.List;

import com.spring.magazzino.entity.Prodotto;

public interface DAOProdotti {
	
	public void carica(Prodotto prodotto);
	
	public List<Prodotto> visualizzaProdotti();
	
	public Prodotto cercaPerId(int id);
	
	
	
	
}
