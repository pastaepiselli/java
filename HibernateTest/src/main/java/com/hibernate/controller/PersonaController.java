package com.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.hibernate.dto.PersonaDTO;
import com.hibernate.entity.Persona;
import com.hibernate.service.PersonaService;

// Esporra dei servizi rest
@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping("")
	public ResponseEntity<List<PersonaDTO>> getPersonaList(){
		return new ResponseEntity<List<PersonaDTO>>(personaService.getPersonaList(), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<PersonaDTO> insertPersona(@RequestBody PersonaDTO p){
		PersonaDTO personaResult = personaService.insertPersona(p);
		return new ResponseEntity<PersonaDTO>(personaResult, HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<PersonaDTO> updatePersona(@RequestBody PersonaDTO dto){
		PersonaDTO persona = personaService.updatePersona(dto);
		return new ResponseEntity<PersonaDTO>(persona, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PersonaDTO> deletePersona(@RequestBody Long id){
		PersonaDTO persona  = personaService.deletePersona(id);
		return new ResponseEntity<PersonaDTO>(persona, HttpStatus.OK);
				
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<PersonaDTO>> getPersonaByName(@PathVariable String nome){
		List<PersonaDTO> listaPersone = personaService.findPersonaByName(nome);
		return new ResponseEntity<List<PersonaDTO>>(listaPersone, HttpStatus.OK);
	}
	
	
	
}
