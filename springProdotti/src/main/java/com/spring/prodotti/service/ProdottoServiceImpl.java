package com.spring.prodotti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.prodotti.dao.DAOProdotti;
import com.spring.prodotti.dto.ProdottoDTO;
import com.spring.prodotti.entity.Prodotto;
import com.spring.prodotti.mapper.Mapper;

@Service // come componet quindi viene sempre istanziata da spring
public class ProdottoServiceImpl implements ProdottoService {
	
	@Autowired // con questo viene istanzaito d spring
	private DAOProdotti dao;

	@Override
	public void carica(ProdottoDTO dto) {
		Prodotto prodotto = Mapper.daProdottoDTOaProdotto(dto);
		dao.inserisci(prodotto);
		
	}

	@Override
	public ProdottoDTO cercaPerId(int id) {
		Prodotto prodotto = dao.selectById(id);
		
		// se arriva qui prodotto nn e null, il controllo avviene nel metodo dao.selectbyId
		return Mapper.daProdottoaProdottoDTO(prodotto);
	}
	
}
