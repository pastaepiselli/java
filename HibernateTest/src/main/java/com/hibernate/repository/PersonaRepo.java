package com.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.dto.PersonaDTO;
import com.hibernate.entity.Persona;

public interface PersonaRepo {
	
	List<Persona> getPersonaList();
	
	Persona insertPersona(Persona p);
	
	Persona updatePersona(Persona p);
	
	Persona deletePersona(Long id);
	
	List<Persona> findPersonaByName(String nome);
}
