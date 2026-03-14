package com.spring.apprubrica.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.apprubrica.dao.DAORubriche;
import com.spring.apprubrica.dto.NomePropNumeroCDTO;
import com.spring.apprubrica.dto.NomePropNumeroTotDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.dto.RubricaPropAnnoCDTO;
import com.spring.apprubrica.entity.Rubrica;
import com.spring.apprubrica.mapper.Mapper;

@Service
public class RubricheServiceImpl implements RubricheService {
	
	@Autowired
	private DAORubriche dao;

	@Override
	public void inserisci(RubricaDTO dto) {
		Rubrica rubrica = Mapper.daRubricaDTOARubrica(dto);
		dao.inserisci(rubrica);
	}

	@Override
	public RubricaDTO cercaPerId(int id) {
		Rubrica rubrica = dao.cercaPerId(id);
		return Mapper.daRubricaARubricaDTO(rubrica);
	}

	@Override
	public List<RubricaDTO> visualizzaRubriche() {
		return dao.visualizzaRubriche()
				.stream() // trasformo in stream
				.map(r -> Mapper.daRubricaARubricaDTO(r)) // mappo entity -> dto
				.collect(Collectors.toList()); // ricreo una lista
	}

	@Override
	public void eliminaRubrica(int id) {
		dao.eliminaRubrica(id);

	}

	@Override
	public RubricaPropAnnoCDTO visualizzaPropietarioEAnnoCreazione(int id) {
		Rubrica rubrica = dao.cercaPerId(id);
		return new RubricaPropAnnoCDTO(rubrica.getProprietario(), rubrica.getAnnoCreazione());
	}

	@Override
	public RubricaDTO modificaNome(int id, String nuovoNome) {
		Rubrica rubrica = dao.cercaPerId(id);
		rubrica.setProprietario(nuovoNome);
		return Mapper.daRubricaARubricaDTO(rubrica);
	}

	@Override
	public RubricaDTO modificaAnnoCreazione(int id, int nuovoAnnoCreazione) {
		Rubrica rubrica = dao.cercaPerId(id);
		rubrica.setAnnoCreazione(nuovoAnnoCreazione);
		return Mapper.daRubricaARubricaDTO(rubrica);
	}

	@Override
	public NomePropNumeroTotDTO visualizzaNomiProprietariENumTot() {
		List<Rubrica> listaRubriche  = dao.visualizzaRubriche();
		return Mapper.daRubricaARubricaPropTot(listaRubriche);
	}

	@Override
	public RubricaPropAnnoCDTO visualizzaRubricaVecchia() {
		Rubrica rubrica = dao.visualizzaRubriche()
				.stream()
				.min((r1, r2) -> Integer.compare(r1.getAnnoCreazione(), r2.getAnnoCreazione()))
				.orElseThrow();
		return Mapper.daRubricaANomeAnno(rubrica);
	}

	@Override
	public List<Integer> visualizzaAnniCreazioneCrescente() {
		return dao.visualizzaRubriche()
				.stream()
				.map(r -> r.getAnnoCreazione())
				.sorted()
				.collect(Collectors.toList());
		
	}
	

	@Override
	public NomePropNumeroCDTO visualizzaNomeNumeroContatti(int id) {
		Rubrica rubrica = dao.cercaPerId(id);
		return new NomePropNumeroCDTO(rubrica.getProprietario(),rubrica.getContatti().size());
				
	}

}
