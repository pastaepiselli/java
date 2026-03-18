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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rubrica.dto.ErroreDTO;
import com.spring.rubrica.dto.PropAnnoDTO;
import com.spring.rubrica.dto.PropNomiNumTotDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.errori.IdEsisteException;
import com.spring.rubrica.errori.IdNonEsisteException;
import com.spring.rubrica.service.RubricheService;

@RestController
@RequestMapping(path="/rubriche")
public class RubricheController {
	
	@Autowired
	private RubricheService service;
	
	// inserisci nuova rubrica (vuota)
	@PostMapping(path="", consumes="application/json")
	public RubricaDTO inserisciRubrica(@RequestBody RubricaDTO dto) {
		return service.inserisciRubrica(dto);
	}
	
	@GetMapping(path="/{idRubrica}", produces="application/json")
	public RubricaDTO cercaPerId(@PathVariable int idRubrica) {
		return service.cercaPerId(idRubrica);
	}
	
	@GetMapping(path="", produces="application/json")
	public List<RubricaDTO> visualizzaRubriche(){
		return service.visualizzaRubriche();
	}
	
	@DeleteMapping(path="/{idRubrica}")
	public RubricaDTO eliminaRubrica(@PathVariable int idRubrica) {
		return service.cancellaRubrica(idRubrica);
	}
	
	@GetMapping(path="/{idRubrica}/nomeEanno", produces="application/json")
	public PropAnnoDTO visualizzaPropAnno(@PathVariable int idRubrica) {
		return service.visualizzaPropAnno(idRubrica);
	}
	
	@PatchMapping(path="/{idRubrica}/modificaNome", produces="application/json")
	public RubricaDTO modificaNome(@PathVariable int idRubrica, String nuovoNome) {
		return service.modificaNome(idRubrica, nuovoNome);
	}
	
	@PatchMapping(path="/{idRubrica}/modificaAnno", produces="application/json")
	public RubricaDTO modificaAnno(@PathVariable int idRubrica, int nuovoAnno) {
		return service.modificaAnno(idRubrica, nuovoAnno);
	}
	
	@GetMapping(path="/nomiEnumeroTot", produces="application/json")
	public PropNomiNumTotDTO visualizzaNomiNumeroTot() {
		return service.visualizzaPropNumTot();
	}
	
	@GetMapping(path="/rubricaVecchia", produces="application/json")
	public PropAnnoDTO rubricaVecchia() {
		return service.rubricaPiuVecchia();
	}
	
	@GetMapping(path="/anniCreazione", produces="application/json")
	public List<Integer> visualizzaAnniCreazione(){
		return service.anniCreazioneAsc();
	}
	
	// gestione errori 
	// 409 conflitto
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> idEsistente(IdEsisteException e){
		ErroreDTO errore = new ErroreDTO(e.getMessage());
		return new ResponseEntity<ErroreDTO>(errore, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler
	// 404 non esistente
	public ResponseEntity<ErroreDTO> idNonEsistente(IdNonEsisteException e){
		ErroreDTO errore = new ErroreDTO(e.getMessage());
		return new ResponseEntity<ErroreDTO>(errore, HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
