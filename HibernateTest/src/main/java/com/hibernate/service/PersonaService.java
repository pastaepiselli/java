package com.hibernate.service;

import java.util.List;

import com.hibernate.dto.PersonaDTO;
import com.hibernate.entity.Persona;

public interface PersonaService {
	
	List<PersonaDTO> getPersonaList();
	PersonaDTO insertPersona(PersonaDTO dto);
	PersonaDTO updatePersona(PersonaDTO dto);
	PersonaDTO deletePersona(Long id);
	List<PersonaDTO> findPersonaByName(String nome);
}
