package com.spring.rubrica.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.rubrica.dto.ErroreDTO;
import com.spring.rubrica.errori.ContattoEsistenteException;
import com.spring.rubrica.errori.IdEsisteException;
import com.spring.rubrica.errori.IdNonEsisteException;


@ControllerAdvice
public class GestioneErrori {
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> idNonTrovato(IdNonEsisteException e){
		ErroreDTO errore = new ErroreDTO(e.getMessage());
		return new ResponseEntity<ErroreDTO>(errore, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> idEsistente(IdEsisteException e){
		ErroreDTO errore = new ErroreDTO(e.getMessage());
		return new ResponseEntity<ErroreDTO>(errore, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> ContattoEsistente(ContattoEsistenteException e){
		ErroreDTO errore = new ErroreDTO(e.getMessage());
		return new ResponseEntity<ErroreDTO>(errore, HttpStatus.CONFLICT);
	}
	
}
