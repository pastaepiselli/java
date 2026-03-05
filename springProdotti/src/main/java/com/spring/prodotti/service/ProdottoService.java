package com.spring.prodotti.service;

import com.spring.prodotti.dto.ProdottoDTO;

public interface ProdottoService {
	public void carica(ProdottoDTO dto); // la service comunica con il mondo esterno quindi dto!!
	public ProdottoDTO cercaPerId(int id);
}
