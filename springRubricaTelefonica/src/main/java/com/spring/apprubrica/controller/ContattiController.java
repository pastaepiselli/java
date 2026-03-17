package com.spring.apprubrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// FIX ME: quando si esegue il put si aggiorna l'id pk il mapper chiama il new e assegna automaticamente il contatore
	// modifica un contatto esistente 
	@PutMapping(path="/{id}", produces="application/json", consumes="application/json")
	public ContattoTelefonicoDTO modificaContatto(
			@PathVariable int id,
			@PathVariable int idRubrica,
			@RequestBody ContattoTelefonicoDTO dto) {
		dto.setId(id);
		return service.modificaContatto(idRubrica, dto);
	}
	
	// Cancella un contatto esistente
	@DeleteMapping(path="/{id}")
	public void eliminaContatto(@PathVariable int id, @PathVariable int idRubrica ) {
		service.eliminaContatto(idRubrica, id);
	}
}
