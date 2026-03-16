package com.spring.apprubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apprubrica.dto.NomePropNumeroCDTO;
import com.spring.apprubrica.dto.NomePropNumeroTotDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.dto.RubricaPropAnnoCDTO;
import com.spring.apprubrica.service.RubricheService;

@RestController
@RequestMapping(path="/rubriche")
public class RubricheController {
	
	@Autowired
	private RubricheService	service;
	
	// inserisci nuova rubrica (vuota)
	@PostMapping(path="/inserisci", consumes="application/json")
	public void inserisci(@RequestBody RubricaDTO dto) {
		service.inserisci(dto);
	}
	
	// visualizza una rubrica per id
	@GetMapping(path="/{id}", produces="application/json")
	public RubricaDTO cercaPerId(@PathVariable int id) {
		return service.cercaPerId(id);
	}
	
	// visualizza tutte le rubriche
	@GetMapping(path="", produces="application/json")
	public List<RubricaDTO> visualizzaRubriche(){
		return service.visualizzaRubriche();
	}
	
	// cancella una rubrica esistente
	@DeleteMapping(path="/{id}")
	public void eliminaRubrica(@PathVariable int id) {
		service.eliminaRubrica(id);
	}
	
	// visualizza solo proprietario e anno creazione di una rubrica (passando l'id)
	@GetMapping(path="/{id}/nomeEcreazione", produces="application/json")
	public RubricaPropAnnoCDTO visualizzaNomeEDataCreazione(@PathVariable int id) {
		return service.visualizzaPropietarioEAnnoCreazione(id);
	}
	
	// modifica il nome proprietario di una rubrica esistente (torna la rubrica esistente)
	// il nuovo nome e passato tramite stringa url
	@PatchMapping(path="/{id}/modificaNome", produces="application/json")
	public RubricaDTO modificaNome(@PathVariable int id, String nuovoNome) {
		return service.modificaNome(id, nuovoNome);
	}
	
	// modifica anno di creazione di una rubrica esitente (torna la rubrica aggiornata)
	@PatchMapping(path="/{id}/modificaAnno", produces="application/json")
	public RubricaDTO modificaAnnoCreazione(@PathVariable int id, int nuovoAnno) {
		return service.modificaAnnoCreazione(id, nuovoAnno);
	}
	
	// visualizza i nomi di tutti i proprietari delle rubriche e il loro numero totale
	@GetMapping(path="/visualizzaNomiENumeroTot", produces="application/json")
	public NomePropNumeroTotDTO visualizzaNomiENumeroTot() {
		return service.visualizzaNomiProprietariENumTot();
	}
	
	// visualizza nome proprietario e anno creazione della rubrica piu vecchia
	@GetMapping(path="/visualizzaProprietarioPiuVecchio", produces="application/json")
	public RubricaPropAnnoCDTO visualizzaProprietarioPiuVecchio() {
		return service.visualizzaRubricaVecchia();
	}
	
	// visualizza tutti gli anni di creazione (delle rubriche) in ordine crescente
	@GetMapping(path="/visualizzaAnniCreazioneRubricheCrescente", produces="application/json")
	public List<Integer> visualizzaAnniCreazione(){
		return service.visualizzaAnniCreazioneCrescente();
	}
	
	// visualizza nome proprietario e numero contatti in una rubrica
	@GetMapping(path="/{id}/nomeProprietarioEnumeroContatti", produces="application/json")
	public NomePropNumeroCDTO visualizzaNomeProprietarioEnumeroContatti(@PathVariable int id) {
		return service.visualizzaNomeNumeroContatti(id);
	}
	
	// TODO: gestione degli errori
	
	
	
	
	
	
	
	
	
	
}
