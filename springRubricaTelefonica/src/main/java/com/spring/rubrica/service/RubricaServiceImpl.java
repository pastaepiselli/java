package com.spring.rubrica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rubrica.dao.RubricaDAO;
import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.ContattoNoIdDTO;
import com.spring.rubrica.dto.NomeCognomeDTO;
import com.spring.rubrica.dto.PropAnnoDTO;
import com.spring.rubrica.dto.PropNomiNumTotDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;
import com.spring.rubrica.errori.ContattoEsistenteException;
import com.spring.rubrica.errori.ContattoNonEsiste;
import com.spring.rubrica.mapper.Mapper;

@Service
public class RubricaServiceImpl implements RubricheService {
	
	// rubriche
	@Autowired
	private RubricaDAO dao;

	@Override
	public RubricaDTO inserisciRubrica(RubricaDTO dto) {
		Rubrica rubrica = Mapper.daRubricaDTOaRubrica(dto);
		return Mapper.daRubricaaRubricaDTO(dao.inserisci(rubrica));
	}

	@Override
	public RubricaDTO cercaPerId(int idRubrica) {
		Rubrica rubrica = dao.cercaPerId(idRubrica);
		return Mapper.daRubricaaRubricaDTO(rubrica);
	}

	@Override
	public List<RubricaDTO> visualizzaRubriche() {
		return dao.visualizzaRubriche()
				.stream()
				.map(r -> Mapper.daRubricaaRubricaDTO(r))
				.toList();
	}

	@Override
	public RubricaDTO cancellaRubrica(int idRubrica) {
		return Mapper.daRubricaaRubricaDTO(dao.eliminaRubrica(idRubrica));
	}

	@Override
	public PropAnnoDTO visualizzaPropAnno(int rubricaId) {
		Rubrica rubrica = dao.cercaPerId(rubricaId);
		return new PropAnnoDTO(rubrica.getProprietario(), rubrica.getAnnoCreazione());
	}

	@Override
	public RubricaDTO modificaNome(int rubricaId, String nuovoNome) {
		Rubrica rubrica = dao.cercaPerId(rubricaId);
		rubrica.setProprietario(nuovoNome);
		return Mapper.daRubricaaRubricaDTO(rubrica);
		
	}

	@Override
	public RubricaDTO modificaAnno(int rubricaId, int nuovoAnno) {
		Rubrica rubrica = dao.cercaPerId(rubricaId);
		rubrica.setAnnoCreazione(nuovoAnno);
		return Mapper.daRubricaaRubricaDTO(rubrica);
	}

	@Override
	public PropNomiNumTotDTO visualizzaPropNumTot() {
		List<String> proprietari = dao.visualizzaRubriche()
				.stream()
				.map(r -> r.getProprietario())
				.toList();
		// automaticamente inserito lunghezza (num prop) :P
		return Mapper.daRubricheAPropNomiNumTotDTO(proprietari);
	} 

	@Override
	public PropAnnoDTO rubricaPiuVecchia() {
		Rubrica rubrica = dao.visualizzaRubriche()
				.stream()
				.min((r1, r2) -> Integer.compare(r1.getAnnoCreazione(), r2.getAnnoCreazione()))
				.get();
		return Mapper.daRubricaAPropAnnoDTO(rubrica);
				
	}

	@Override
	public List<Integer> anniCreazioneAsc() {
		return dao.visualizzaRubriche()
				.stream()
				.map(r -> r.getAnnoCreazione())
				.sorted()
				.toList();
	}

	@Override
	public PropAnnoDTO nomeNumeroContatti(int idRubrica) {
		Rubrica rubrica = dao.cercaPerId(idRubrica);
		return new PropAnnoDTO(rubrica.getProprietario(), rubrica.getContatti().size());
	}
	
	// contatti
	@Override
	public ContattoDTO inserisciContatto(int idRubrica, ContattoDTO dto) {
		return Mapper.daContattoaContattoDTO(dao.inserisci(idRubrica, null));
	}

	@Override
	public ContattoDTO cercaPerId(int idRubrica, int idContatto) {
		Contatto contatto = dao.cercaContatto(idRubrica, idContatto);
		return Mapper.daContattoaContattoDTO(contatto);
	}

	@Override
	public ContattoDTO modificaContatto(int idRubrica, ContattoNoIdDTO dto) {
		Contatto contatto = dao.cercaContatto(idRubrica, idRubrica);
		contatto.updateContatto(dto);
		return Mapper.daContattoaContattoDTO(contatto);
	}

	@Override
	public ContattoDTO eliminaContatto(int idRubrica, int idContatto) {
		Contatto contatto = dao.eliminaContatto(idRubrica, idContatto);
		return Mapper.daContattoaContattoDTO(contatto);
	}

	@Override
	public List<ContattoDTO> visualizzaContatti(int idRubrica) {
		return dao.visualizzaContatti(idRubrica)
				.stream()
				.map(c -> Mapper.daContattoaContattoDTO(c))
				.toList();
	}

	@Override
	public int visualizzaNumeroContatti(int idRubrica) {
		return dao.visualizzaContatti(idRubrica).size();
	}

	@Override
	public ContattoDTO contattoConNumero(int idRubrica, String numero) {
		Contatto contatto = dao.visualizzaContatti(idRubrica)
				.stream()
				.filter(c -> c.getNumero().equals(numero))
				.findFirst()
				.orElseThrow(() -> new ContattoNonEsiste("Contatto con numero: " + numero + " non esistente."));
		return Mapper.daContattoaContattoDTO(contatto);

	}

	@Override
	public List<NomeCognomeDTO> nomeCognomeContattiGruppo(int idRubrica, String gruppo) {
		return dao.visualizzaContatti(idRubrica)
				.stream()
				.filter(c -> c.getGruppo().equals(gruppo))
				.map(c -> Mapper.daContattoaNomeCognomeDTO(c))
				.toList();
	}

	@Override
	public int numeroContattiGruppo(int idRubrica, String nomeGruppo) {
		return (int) dao.visualizzaContatti(idRubrica)
				.stream()
				.filter(c -> c.getGruppo().equals(nomeGruppo))
				.count();
	}

	// elimina tutti i contatti che hanno quel gruppo
	@Override
	public List<ContattoDTO> eliminaGruppo(int idRubrica, String nomeGruppo) {
		List<Contatto> contatti = dao.visualizzaContatti(idRubrica);
		List<Contatto> contattiDaEliminare = contatti
		
				.stream()
				.filter(c -> c.getGruppo().equals(nomeGruppo))
				.toList();
		contatti.removeAll(contattiDaEliminare);
		return contattiDaEliminare.stream().map(c -> Mapper.daContattoaContattoDTO(c)).toList();
	}

	@Override
	public ContattoDTO impostaPreferito(int idRubrica, int idContatto) {
		Contatto contatto = dao.cercaContatto(idRubrica, idContatto);
		contatto.setPreferito(true);
		return Mapper.daContattoaContattoDTO(contatto);
	}

	@Override
	public List<ContattoDTO> visualizzaPreferiti(int idRubrica) {
		return dao.visualizzaContatti(idRubrica)
				.stream()
				.filter(c -> c.isPreferito())
				.map(c -> Mapper.daContattoaContattoDTO(c))
				.toList();
	}
	
	

}
