package com.spring.magazzino.service;

import java.util.List;

import com.spring.magazzino.dto.ProdottoDTO;
import com.spring.magazzino.dto.ProdottoDTONoId;
import com.spring.magazzino.dto.ReportDTO;

public interface ProdottoService {
	public void caricaProdotto(ProdottoDTO dto);
	public List<ProdottoDTONoId> visualizzaProdottiNoId();
	public ProdottoDTO cercaPerId(int id);
	public ReportDTO visualizzaReport(); //
}
