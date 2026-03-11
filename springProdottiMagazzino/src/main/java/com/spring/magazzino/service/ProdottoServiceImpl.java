package com.spring.magazzino.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.magazzino.dao.DAOProdotti;
import com.spring.magazzino.dto.ProdottoDTO;
import com.spring.magazzino.dto.ProdottoDTONoId;
import com.spring.magazzino.dto.ReportDTO;
import com.spring.magazzino.entity.Prodotto;
import com.spring.magazzino.mapper.Mapper;
/*
 * service e sempre un figlio di componet ma indica che questo componente
 * contiene la business logich
 */
@Service
public class ProdottoServiceImpl implements ProdottoService {
	/*
	 * Autowired dice a spring di iniettare un componente (BEAN) 
	 * senza doverlo istanziare a mano
	 */
	@Autowired
	private DAOProdotti dao;

	@Override
	public void caricaProdotto(ProdottoDTO dto) {
		// nel service come sempre convertiamo le classi con i metodi statici di mapper
		Prodotto prodotto = Mapper.daProdottoDTOAProdotto(dto);
		dao.carica(prodotto);
		
	}

	@Override
	public List<ProdottoDTONoId> visualizzaProdottiNoId() {
		List<Prodotto> listaProdotti = dao.visualizzaProdotti();
		List<ProdottoDTONoId> listaProdottiNoId = listaProdotti.stream()
				.map(p -> Mapper.daProdottoAProdottoDTONoId(p))
				.collect(Collectors.toList());
		return listaProdottiNoId;
	}
	
	@Override
	public ProdottoDTO cercaPerId(int id) {
		Prodotto prodotto = dao.cercaPerId(id);
		ProdottoDTO dto = Mapper.daProdottoAProdottoDTO(prodotto);
		return dto;
	}

	@Override
	public ReportDTO visualizzaReport() {
		return Mapper.generaReportDaProdotti(dao.visualizzaProdotti());
	}

}
