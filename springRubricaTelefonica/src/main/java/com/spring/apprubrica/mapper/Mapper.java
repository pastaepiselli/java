package com.spring.apprubrica.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.apprubrica.dto.ContattoTelefonicoDTO;
import com.spring.apprubrica.dto.NomePropNumeroTotDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.dto.RubricaPropAnnoCDTO;
import com.spring.apprubrica.entity.ContattoTelefonico;
import com.spring.apprubrica.entity.Rubrica;

public class Mapper {
	// rubriche
	public static RubricaDTO daRubricaARubricaDTO(Rubrica rubrica) {
		RubricaDTO dto =  new RubricaDTO(rubrica.getProprietario(), rubrica.getAnnoCreazione(), rubrica.getContatti());
		dto.setId(rubrica.getId());
		return dto;
	}
	
	public static Rubrica daRubricaDTOARubrica(RubricaDTO dto) {
		return new Rubrica(dto.getProprietario(), dto.getAnnoCreazione());
	}
	
	public static NomePropNumeroTotDTO daRubricaARubricaPropTot(List<Rubrica> lista) {
		List<String> listaNomi = lista.stream()
				.map(r -> r.getProprietario())
				.collect(Collectors.toList());
		return new NomePropNumeroTotDTO(listaNomi, lista.size());
	}
	
	public static RubricaPropAnnoCDTO daRubricaANomeAnno(Rubrica rubrica) {
		return new RubricaPropAnnoCDTO(rubrica.getProprietario(), rubrica.getAnnoCreazione());
	}
	
	// contatti
	public static ContattoTelefonicoDTO daContattoAContattoDTO(ContattoTelefonico contatto) {
		return new ContattoTelefonicoDTO(contatto.getNome(),
				contatto.getCognome(), 
				contatto.getNumero(),
				contatto.getGruppo(),
				contatto.getDataNascita(), 
				contatto.isPreferito());
	}
	
	public static ContattoTelefonico daContattoDTOAContatto(ContattoTelefonicoDTO contatto) {
		return new ContattoTelefonico(contatto.getNome(),
				contatto.getCognome(), 
				contatto.getNumero(),
				contatto.getGruppo(),
				contatto.getDataNascita(), 
				contatto.isPreferito());
	}
}
