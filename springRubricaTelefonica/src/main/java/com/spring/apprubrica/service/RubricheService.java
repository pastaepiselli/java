package com.spring.apprubrica.service;

import java.time.LocalDate;
import java.util.List;

import com.spring.apprubrica.dto.NomePropNumeroTotDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.dto.RubricaPropAnnoCDTO;

public interface RubricheService {
	public void inserisci(RubricaDTO dto);
	public RubricaDTO cercaPerId(int id);
	public List<RubricaDTO> visualizzaRubriche();
	public void eliminaRubrica(int id);
	public RubricaPropAnnoCDTO visualizzaPropietarioEAnnoCreazione();
	public RubricaDTO modificaNome(int id, String nuovoNome);
	public RubricaDTO modificaAnnoCreazione(int id, LocalDate nuovoAnnoCreazione);
	public List<NomePropNumeroTotDTO> visualizzaNomiProprietariENumTot();
	public RubricaPropAnnoCDTO visualizzaRubricaVecchia();
	public List<LocalDate> 
	
	
}
