package com.spring.rubrica.mapper;

import java.util.List;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.PropAnnoDTO;
import com.spring.rubrica.dto.PropNomiNumTotDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;

public class Mapper {
	public static Rubrica daRubricaDTOaRubrica(RubricaDTO dto) {
		return new Rubrica(
				dto.getId(),
				dto.getProprietario(),
				dto.getAnnoCreazione());
				
	}
	
	public static RubricaDTO daRubricaaRubricaDTO(Rubrica rubrica) {
		return new RubricaDTO(
				rubrica.getId(),
				rubrica.getProprietario(),
				rubrica.getAnnoCreazione());
				
	}
	
	public static PropAnnoDTO daRubricaAPropAnnoDTO(Rubrica rubrica) {
		return new PropAnnoDTO(rubrica.getProprietario(), rubrica.getAnnoCreazione());
	}
	
	public static PropNomiNumTotDTO daRubricheAPropNomiNumTotDTO(List<String> rubriche) {
		return new PropNomiNumTotDTO(rubriche);
	}

	
	
	// sadfsdfasdf
	public static Contatto daContattoDTOaContatto(ContattoDTO dto) {
		return new Contatto(
				dto.getId(),
				dto.getNome(), 
				dto.getCognome(), 
				dto.getNumero(), 
				dto.getGruppo(),
				dto.getDataNascita(), 
				dto.isPreferito());
	}
	
	
}
