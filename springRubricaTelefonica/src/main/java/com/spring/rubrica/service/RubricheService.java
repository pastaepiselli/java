package com.spring.rubrica.service;

import java.util.List;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.ContattoNoIdDTO;
import com.spring.rubrica.dto.NomeCognomeDTO;
import com.spring.rubrica.dto.PropAnnoDTO;
import com.spring.rubrica.dto.PropNomiNumTotDTO;
import com.spring.rubrica.dto.RubricaDTO;

public interface RubricheService {
	//metodi rubriche
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
	
	// metodi contatti
	public ContattoDTO inserisciContatto(int idRubrica, ContattoDTO dto);
	public ContattoDTO cercaPerId(int idRubrica, int idContatto);
	public ContattoDTO modificaContatto(int idRubrica, ContattoNoIdDTO dto);
	public ContattoDTO eliminaContatto(int idRubrica, int idContatto);
	public List<ContattoDTO> visualizzaContatti(int idRubrica);
	public int visualizzaNumeroContatti(int idRubrica);
	public ContattoDTO contattoConNumero(int idRubrica, String numero);
	public List<NomeCognomeDTO> nomeCognomeContattiGruppo(int idRubrica, String gruppo);
	public int numeroContattiGruppo(int idRubrica, String nomeGruppo);
	public List<ContattoDTO> eliminaGruppo(int idRubrica, String nomeGruppo);
	public ContattoDTO impostaPreferito(int idRubrica, int idContatto);
	public List<ContattoDTO> visualizzaPreferiti(int idRubrica);
	
	
	
	
}
