package com.spring.prodotti.mapper;

import com.spring.prodotti.dto.ProdottoDTO;
import com.spring.prodotti.entity.Prodotto;

public class Mapper { // classe con metodi statici che eseguono conversione
	public static Prodotto daProdottoDTOaProdotto(ProdottoDTO dto) {
		return new Prodotto(dto.getId(), dto.getDescrizione());
	}
	public static ProdottoDTO daProdottoaProdottoDTO(Prodotto prodotto) {
		return new ProdottoDTO(prodotto.getId(), prodotto.getDescrizione());
	}
}
