package com.spring.apprubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apprubrica.dto.NomePropNumeroCDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.dto.RubricaPropAnnoCDTO;
import com.spring.apprubrica.service.RubricheService;

@RestController
@RequestMapping(path="/rubriche")
public class RubricheController {
	
	@Autowired
	private RubricheService	service;
	
	@PostMapping(path="/inserisci", consumes="application/json")
	public void inserisci(@RequestBody RubricaDTO dto) {
		service.inserisci(dto);
	}
	
	@GetMapping(path="/{id}", produces="application/json")
	public RubricaDTO cercaPerId(@PathVariable int id) {
		return service.cercaPerId(id);
	}
	
	@GetMapping(path="", produces="application/json")
	public List<RubricaDTO> visualizzaRubriche(){
		return service.visualizzaRubriche();
	}
	
	@DeleteMapping(path="/{id}")
	public void eliminaRubrica(@PathVariable int id) {
		service.eliminaRubrica(id);
	}
	
	@GetMapping(path="/{id}/nomeEcreazione", produces="application/json")
	public RubricaPropAnnoCDTO visualizzaNomeEDataCreazione(@PathVariable int id) {
		return service.visualizzaPropietarioEAnnoCreazione(id);
	}
	
	// TODO finire altri metodi rubrica
	
	
	
	
	
}
