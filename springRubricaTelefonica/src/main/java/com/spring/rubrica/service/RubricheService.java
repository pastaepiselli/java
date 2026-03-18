package com.spring.rubrica.service;

import java.util.List;

import com.spring.rubrica.dto.PropAnnoDTO;
import com.spring.rubrica.dto.PropNomiNumTotDTO;
import com.spring.rubrica.dto.RubricaDTO;

public interface RubricheService {
	public RubricaDTO inserisciRubrica(RubricaDTO dto);
	public RubricaDTO cercaPerId(int idRubrica);
	public List<RubricaDTO> visualizzaRubriche();
	public RubricaDTO cancellaRubrica(int idRubrica);
	public PropAnnoDTO visualizzaPropAnno(int rubricaId);
	public RubricaDTO modificaNome(int rubricaId, String nuovoNome);
	public RubricaDTO modificaAnno(int rubricaId, int nuovoAnno);
	public PropNomiNumTotDTO visualizzaPropNumTot();
	public PropAnnoDTO rubricaPiuVecchia();
	public List<Integer> anniCreazioneAsc();
	public PropAnnoDTO nomeNumeroContatti(int idRubrica);
	
	
	
}
