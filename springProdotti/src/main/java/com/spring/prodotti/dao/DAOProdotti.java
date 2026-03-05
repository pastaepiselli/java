package com.spring.prodotti.dao;

import com.spring.prodotti.entity.Prodotto;

public interface DAOProdotti {
	
	public void inserisci(Prodotto prodotto);
	
	public Prodotto selectById(int id);
	
}
