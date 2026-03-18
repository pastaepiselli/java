package com.spring.rubrica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rubrica.dao.RubricaDAO;
import com.spring.rubrica.dto.PropAnnoDTO;
import com.spring.rubrica.dto.PropNomiNumTotDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Rubrica;
import com.spring.rubrica.mapper.Mapper;

@Service
public class RubricaServiceImpl implements RubricheService {
	
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

}
