package com.spring.universita.mapper;

import com.spring.universita.dto.ProfessoreDTO;
import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.entity.Professore;
import com.spring.universita.entity.Studente;

public class Mapper {

	public static StudenteDTO daStudenteAStudenteDTO(Studente studente){
		return new StudenteDTO(studente.getNome(), studente.getCognome(), studente.getMatricola(),
				studente.getIndirizzo(), studente.getAnnoNascita(), studente.getAnnoImmatricolazione());
	}
	
	public static Studente daStudenteDTOAStudente(StudenteDTO dto) {
		return new Studente(dto.getNome(), dto.getCognome(), 
				dto.getMatricola(), dto.getIndirizzo(), dto.getAnnoNascita(), dto.getAnnoImmatricolazione());
	}
	
	public static ProfessoreDTO daProfessoreAProfessoreDTO(Professore professore) {
		return new ProfessoreDTO(professore.getNome(), professore.getCognome(), 
				professore.getMateriaInsegnamento(), professore.getId());
	}
	
	public static Professore daProfessoreDTOAProfessore(ProfessoreDTO dto) {
		return new Professore(dto.getNome(), dto.getCognome(), dto.getMateriaInsegnamento(), dto.getId());
	}
}

