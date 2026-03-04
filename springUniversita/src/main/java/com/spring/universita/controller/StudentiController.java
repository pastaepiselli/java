package com.spring.universita.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.services.StudentiServices;

@RestController
@RequestMapping(path="/studenti")
public class StudentiController {
	
	private final StudentiServices services = new StudentiServices();
	
	@PostMapping(path="/registra", consumes = "application/json")
	public boolean registra(@RequestBody StudenteDTO dto) {
		return services.inserisci(dto);
	}
	
	@GetMapping(path="/{matricola}", produces = "application/json")
	public StudenteDTO cercaPerMatricola(@PathVariable String matricola) {
		return services.cercaPerMatricola(matricola);
	}
	
	@GetMapping(path="", produces = "application/json")
	public List<StudenteDTO> visualizzaStudenti(){
		return services.visualizzaStudenti();
	}
	
	@DeleteMapping(path="/{matricola}") // questo ritorna solo true o false
	public boolean eliminaStudente(@PathVariable String matricola) {
		return services.eliminaStudente(matricola);
	}
	
	@PatchMapping(path="/{matricola}/modificaIndirizzo", produces = "application/json")
	public StudenteDTO modificaIndirizzo(@PathVariable String matricola, String nuovoIndirizzo) {
		return services.modificaIndirizzo(matricola, nuovoIndirizzo);
	}
	
	
	
	
	
	
}
