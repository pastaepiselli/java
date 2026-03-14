package com.spring.apprubrica.service;

import java.util.List;

import com.spring.apprubrica.dto.NomePropNumeroCDTO;
import com.spring.apprubrica.dto.NomePropNumeroTotDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.dto.RubricaPropAnnoCDTO;

public interface RubricheService {
	public void inserisci(RubricaDTO dto);
	public RubricaDTO cercaPerId(int id);
	public List<RubricaDTO> visualizzaRubriche();
	public void eliminaRubrica(int id);
	public RubricaPropAnnoCDTO visualizzaPropietarioEAnnoCreazione(int id);
	public RubricaDTO modificaNome(int id, String nuovoNome);
	public RubricaDTO modificaAnnoCreazione(int id, int nuovoAnnoCreazione);
	public NomePropNumeroTotDTO visualizzaNomiProprietariENumTot();
	public RubricaPropAnnoCDTO visualizzaRubricaVecchia();
	public List<Integer> visualizzaAnniCreazioneCrescente();
	public NomePropNumeroCDTO visualizzaNomeNumeroContatti(int id);
	
	
}
