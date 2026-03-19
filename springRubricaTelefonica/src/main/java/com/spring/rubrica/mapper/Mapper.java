package com.spring.rubrica.mapper;

import java.util.List;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.NomeCognomeDTO;
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

	
	
	// contatti
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
	
	public static ContattoDTO daContattoaContattoDTO(Contatto contatto) {
		return new ContattoDTO(
				contatto.getId(),
				contatto.getNome(), 
				contatto.getCognome(), 
				contatto.getNumero(), 
				contatto.getGruppo(),
				contatto.getDataNascita(), 
				contatto.isPreferito());
	}
	
	public static NomeCognomeDTO daContattoaNomeCognomeDTO(Contatto contatto) {
		return new NomeCognomeDTO(contatto.getNome(), contatto.getCognome());
	}
	
	
	
	
}
