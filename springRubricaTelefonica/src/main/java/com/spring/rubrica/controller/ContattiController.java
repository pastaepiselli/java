package com.spring.rubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.ContattoNoIdDTO;
import com.spring.rubrica.dto.ErroreDTO;
import com.spring.rubrica.dto.NomeCognomeDTO;
import com.spring.rubrica.errori.IdNonEsisteException;
import com.spring.rubrica.service.RubricheService;

@RestController
@RequestMapping(path="/rubriche/{idRubrica}/contatti")
public class ContattiController {
	
	@Autowired
	private RubricheService service;
	
	@PostMapping(path="", consumes="application/json", produces="application/json")
	public ContattoDTO inserisciContatto(@PathVariable int idRubrica,@RequestBody ContattoDTO dto) {
		return service.inserisciContatto(idRubrica, dto);
	}
	
	@GetMapping(path="/{idContatto}", produces="application/json")
	public ContattoDTO cercaContatto(@PathVariable int idContatto, @PathVariable int idRubrica) {
		return service.cercaPerId(idRubrica, idContatto);
	}
	
	@PutMapping(path="/{idContatto}", produces="application/json", consumes="application/json")
	public ContattoDTO modificaContatto(@PathVariable int idRubrica, @RequestBody ContattoNoIdDTO dto) {
		return service.modificaContatto(idRubrica, dto);
	}
	
	@DeleteMapping(path="/{idContatto}", produces="application/json")
	public ContattoDTO eliminaContatto(@PathVariable int idRubrica, @PathVariable int idContatto) {
		return service.eliminaContatto(idRubrica, idContatto);
	}
	
	@GetMapping(path="", produces="application/json")
	public List<ContattoDTO> visualizzaContatti(@PathVariable int idRubrica){
		return service.visualizzaContatti(idRubrica);
	}
	
	@GetMapping(path="/numeroContatti", produces="application/json")
	public int numeroContatti(@PathVariable int idRubrica) {
		return service.visualizzaNumeroContatti(idRubrica);
	}
	
	@GetMapping(path="/numero/{numero}", produces="application/json")
	public ContattoDTO contattoDaNumero(@PathVariable int idRubrica,@PathVariable String numero) {
		return service.contattoConNumero(idRubrica, numero);
	}
	
	@GetMapping(path="/{gruppo}/nomiECognomi", produces="application/json")
	public List<NomeCognomeDTO> nomiCognomi(@PathVariable int idRubrica, @PathVariable String gruppo ){
		return service.nomeCognomeContattiGruppo(idRubrica, gruppo);
	}
	
	@GetMapping(path="/{gruppo}/numeroContatti", produces="application/json")
	public int numeroContattiGruppo(@PathVariable int idRubrica, @PathVariable String gruppo) {
		return service.numeroContattiGruppo(idRubrica, gruppo);
	}
	
	@DeleteMapping(path="/{gruppo}", produces="application/json")
	public List<ContattoDTO> eliminaGruppo(@PathVariable int idRubrica, @PathVariable String gruppo){
		return service.eliminaGruppo(idRubrica, gruppo);
	}
	
	@PatchMapping(path="/{idContatto}/impostaPreferito", produces="application/json")
	public ContattoDTO impostaPreferito(@PathVariable int idRubrica, @PathVariable int idContatto) {
		return service.impostaPreferito(idRubrica, idContatto);
	}
	
	@GetMapping(path="/preferiti", produces="application/json")
	public List<ContattoDTO> visualizzaPreferiti(@PathVariable int idRubrica){
		return service.visualizzaPreferiti(idRubrica);
	}
	
	
	
	
	
	
	
	
	
	
}
