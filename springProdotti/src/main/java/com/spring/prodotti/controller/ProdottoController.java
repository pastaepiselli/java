package com.spring.prodotti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.prodotti.dto.ErroreDTO;
import com.spring.prodotti.dto.ProdottoDTO;
import com.spring.prodotti.service.ProdottoServiceImpl;

@RestController // rende questa classe un punto di ingresso in cui si definiscono endpoint
@RequestMapping(path="/prodotti")
public class ProdottoController {
	@Autowired // crea la dipendenza con questo servizio :P
	private ProdottoServiceImpl service;
	
	@PostMapping(path="/carica", consumes = "application/json") // riceve il json per costruire il prodotto
	public void carica(@RequestBody ProdottoDTO dto) {
		service.carica(dto);
	}
	
	@GetMapping(path="/{id}", produces = "application/json") // ritorna il json del prodotto
	public ProdottoDTO cercaPerId(@PathVariable int id) {// id viene inserito nella path url, per questo va specificato
		return service.cercaPerId(id);
	}
	
	// ------------ gestione degli errori --------------
	
	// response entity deve contenere lo status code della risposta (400, 404, 200, ecc...)
	@ExceptionHandler // necessarioo per gestire queste eccezioni
	public ResponseEntity<ErroreDTO> gestoreErrori(RuntimeException ex){ // come se fosse un grande catch
		// creo errore dto
		ErroreDTO dto = new ErroreDTO(ex.getMessage()); // inserisco il messaggio dell'eccezione catchata
		
		// per ritonare lo status code ce la variabile enumerativa HttpStatus
		// notare che spedisco DTO!!
		return new ResponseEntity<ErroreDTO>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
