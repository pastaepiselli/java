package com.spring.magazzino.controller;

import java.util.List;

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

import com.spring.magazzino.dto.ErroreDTO;
import com.spring.magazzino.dto.ProdottoDTO;
import com.spring.magazzino.dto.ProdottoDTONoId;
import com.spring.magazzino.dto.ReportDTO;
import com.spring.magazzino.errori.IdEsistenteException;
import com.spring.magazzino.errori.ProdottoNonEsisteException;
import com.spring.magazzino.service.ProdottoService;

@RestController // equivalente a @Controller + @ResponseBody
// @Controller -> dice a spring che questa classe gestrira le richieste in arrivo
// @ResponseBody -> dice a spring che il valore restituito dai metodi deve essere in JSON
// queste bellissime proprieta si applicano automaticamente su tutti i metodi

@RequestMapping("/prodotti")
public class ProdottiController {
	
	@Autowired
	private ProdottoService service;
	
	@PostMapping(path="/carica", consumes = "application/json") // consumes si usa quando si deve ricevere un JSON
	/*
	 * questo requestbody dice a spring di leggere il body della richiesta 
	 * e di usarlo input di questa funzione
	 
	 */
	public void caricaProdotto(@RequestBody ProdottoDTO dto) {
		service.caricaProdotto(dto);
	}
	
	@GetMapping(path ="/listaProdottiNoId", produces = "application/json") // produces per indicare che questo metodo inviera come risposta un JSON
	public List<ProdottoDTONoId> visualizzaProdottiNoId(){
		return service.visualizzaProdottiNoId();
	}
	
	@GetMapping(path="/{id}", produces = "application/json")
	/*
	 * Pathvariable indica a spring di estrarre un valore direttamente
	 * dall'url e di inserirlo nel metodo
	 */
	public ProdottoDTO cercaPerId(@PathVariable int id) {
		return service.cercaPerId(id);
	}
	
	@GetMapping(path="/report", produces = "application/json")
	public ReportDTO visualizzaReportDTO() {
		return service.visualizzaReport();
	}
	
	// =========== gestione degli errori =============
	
	/*
	 * ExceptionHandler permette di intercettare eccezioni lanciate dai metodi della controller
	 * e inviare un risposta http
	 */
	
	// errore con per conflitto di risorse
	
	// TODO: capire perche non entra in questo errore
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> idEsistente(IdEsistenteException e){
		ErroreDTO errore = new ErroreDTO(e.getMessage());
		return new ResponseEntity<ErroreDTO>(errore, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> ricercaErrore(ProdottoNonEsisteException e){
		// creo la mia classe con il messaggio dell'errore ottenuto
		ErroreDTO errore = new ErroreDTO(e.getMessage()); 
		return new ResponseEntity<ErroreDTO>(errore, HttpStatus.NOT_FOUND);
	}
	
	
}
