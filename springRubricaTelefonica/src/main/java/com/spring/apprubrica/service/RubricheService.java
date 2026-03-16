package com.spring.apprubrica.service;

import java.util.List;

import com.spring.apprubrica.dto.ContattoTelefonicoDTO;
import com.spring.apprubrica.dto.NomeCognomeContattoDTO;
import com.spring.apprubrica.dto.NomePropNumeroCDTO;
import com.spring.apprubrica.dto.NomePropNumeroTotDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.dto.RubricaPropAnnoCDTO;

public interface RubricheService {
	// service rubriche
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
	
	// service contatto
	public void inserisciContatto(int rubricaId, ContattoTelefonicoDTO dto);
	public ContattoTelefonicoDTO cercaContatto(int rubricaId, int id);
	public ContattoTelefonicoDTO modificaContatto(int rubricaId, ContattoTelefonicoDTO dto);
	public void eliminaContatto(int rubricaId, int contattoId);
	public List<ContattoTelefonicoDTO> visualizzaContatti(int rubicaId);
	public int visualizzaNumeroContatti(int rubricaId);
	public ContattoTelefonicoDTO visualizzaContattoDalNumero(int rubricaId, String numero);
	public List<NomeCognomeContattoDTO> getContattiNomeCognomeDalGruppo(int rubricaId, String gruppo);
	public int numeroContattiInGruppo(int rubricaId, String gruppo);
	
	// cancella contatti appartenenti a quel gruppo
	public void cancellaGruppo(int rubricaId, String gruppo);
	public ContattoTelefonicoDTO impostaPreferito(int rubricaId, int contattoId);
	public List<ContattoTelefonicoDTO> contattiPreferiti(int rubricaId);
	
	
	
	
	
}
