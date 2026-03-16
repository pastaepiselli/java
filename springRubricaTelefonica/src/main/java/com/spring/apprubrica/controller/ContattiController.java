package com.spring.apprubrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apprubrica.dto.ContattoTelefonicoDTO;
import com.spring.apprubrica.service.RubricheService;

@RestController
@RequestMapping(path="/rubriche/{idRubrica}/contatti")
public class ContattiController {
	
	@Autowired
	private RubricheService service;
	
	// inserisci un nuovo contatto
	@PostMapping(path="", consumes="application/json")
	public void aggiungiContatto(@PathVariable int idRubrica, @RequestBody ContattoTelefonicoDTO dto) {
		service.inserisciContatto(idRubrica, dto);
	}
	
	// visualizza un contatto per id
	@GetMapping(path="/{id}", produces="application/json")
	public ContattoTelefonicoDTO cercaContatto(@PathVariable int idRubrica,@PathVariable int id) {
		return service.cercaContatto(idRubrica, id);
	}
	
	// TODO: finire metodi + gestione degli errori
	
}
