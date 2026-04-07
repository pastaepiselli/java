package com.spring.statisticheCalcolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.statisticheCalcolo.dto.ErroreDTO;
import com.spring.statisticheCalcolo.service.OperazioniService;

@RestController
@RequestMapping(path="/calcoli")
public class CalcoliController {
	
	@Autowired 
	private OperazioniService service;
	
	@GetMapping(path="/{a}/{b}/addizione")
	public int addizione(@PathVariable int a, @PathVariable int b) {
		return service.addizione(a, b);
	}
	
	@GetMapping(path="/{a}/{b}/sottrazione")
	public int sottrazione(@PathVariable int a, @PathVariable int b) {
		return service.sottrazione(a, b);
	}
	
	@GetMapping(path="/{a}/{b}/moltiplicazione")
	public int moltiplicazione(@PathVariable int a, @PathVariable int b) {
		return service.moltiplicazione(a, b);
	}
	
	@GetMapping(path="/{a}/{b}/divisione")
	public int divisione(@PathVariable int a, @PathVariable int b) {
		return service.divisione(a, b);
	}
	
	@GetMapping
	
	// gestione errori
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> divisioneConZero(ArithmeticException e){
		ErroreDTO errore = new ErroreDTO(e.getMessage());
		return  new ResponseEntity<ErroreDTO>(errore, HttpStatus.BAD_REQUEST);
	}
}
