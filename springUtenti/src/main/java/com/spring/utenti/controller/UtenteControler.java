package com.spring.utenti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.utenti.entity.Utente;
import com.spring.utenti.service.UtenteService;

@RestController
@RequestMapping(path="/utenti")
public class UtenteControler {
	



    private UtenteService service = new UtenteService();
	
	@PostMapping(path="/registra", consumes="application/json")
	public boolean registra(@RequestBody Utente utente) {
		return service.registra(utente);
	}
	
	@GetMapping(path="/cercaPerId/{idUtente}", produces = "application/json")
	public Utente cercaPerId(@PathVariable int idUtente) {
		return service.cercaPerId(idUtente);
	}
	
	@GetMapping(path="", produces = "application/json")
	public List<Utente> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping(path="/cercaPerId/{idUtente}", produces = "application/json")
	public Utente deleteById(@PathVariable int idUtente) {
		return service.delete(idUtente);
	}
	
	@PatchMapping(path="/modificaEmail/{idUtente}", produces = "application/json")
	public Utente updateEmail(@PathVariable int idUtente, String newEmail) {
		return service.updateEmail(idUtente, newEmail);
	}
	
	@GetMapping(path="/ordinatiPerNome", produces = "application/json")
	public List<Utente> ordinaPerNome(){
		return service.sortUtentiNome();
	}
	
	@GetMapping(path="/listaNomi", produces = "application/json")
	public List<String> listaNomi(){
		return service.listaNomi();
	}
	
	// TODO visulizza tutte le mail di "gmail.com"
	@GetMapping(path="/listaGmail", produces = "application/json")
	public List<String> listaGmail(){
		return service.emailConGmail();
	}
	
	
}
