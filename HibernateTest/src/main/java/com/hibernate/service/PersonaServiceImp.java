package com.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.dto.PersonaDTO;
import com.hibernate.entity.Persona;
import com.hibernate.repository.PersonaRepo;

@Service
public class PersonaServiceImp implements PersonaService {
	
	@Autowired
	PersonaRepo personaRepo;

	@Override
	public List<PersonaDTO> getPersonaList() {
		List<Persona> listaEntity = personaRepo.getPersonaList();
		List<PersonaDTO> listaDTO = listaEntity.stream()
				.map((p) -> new PersonaDTO(p))
				.toList();
		return listaDTO;
	}

	@Override
	public PersonaDTO insertPersona(PersonaDTO dto) {
		Persona entity = new Persona(dto);
		Persona saved = personaRepo.insertPersona(entity);
		return new PersonaDTO(saved);
	}

	@Override
	public PersonaDTO updatePersona(PersonaDTO dto) {
		Persona entity = new Persona(dto);
		Persona update = personaRepo.updatePersona(entity);
		return new PersonaDTO(update);
	}

	@Override
	public PersonaDTO deletePersona(Long id) {
		
		Persona delete = personaRepo.deletePersona(id);
		return new PersonaDTO(delete);
	
	}

	@Override
	public List<PersonaDTO> findPersonaByName(String nome) {
		List<Persona> listaEntity = personaRepo.findPersonaByName(nome);
		List<PersonaDTO> listaDTO = listaEntity.stream()
				.map((p) -> new PersonaDTO(p))
				.toList();
		return listaDTO;
	}
	
	
}
