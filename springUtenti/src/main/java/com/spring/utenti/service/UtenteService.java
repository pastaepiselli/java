package com.spring.utenti.service;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.utenti.dao.DAOUtenteMappa;
import com.spring.utenti.dto.NomeCognomeDTO;
import com.spring.utenti.dto.UtenteDTO;
import com.spring.utenti.entity.Utente;
import com.spring.utenti.mapper.Mapper;

public class UtenteService {
	private DAOUtenteMappa dao = new DAOUtenteMappa();
	
	public boolean registra(UtenteDTO dto) {
		// trasfoma dto in entity
		Utente utente = Mapper.daUtenteDTOAUtente(dto);
		// chiama il dao
		return dao.insert(utente);
		
	}
	
	public UtenteDTO cercaPerId(int idUtente) {
		Utente utente = dao.selectById(idUtente);
		if (utente != null) {
			// trasforma da entity a dto
			return Mapper.daUtenteAUtenteDTO(utente);
		} else {
			return null; // evitiamo nullPointer
		}
		
	}
	
	public List<UtenteDTO> listAll(){
		
		return dao.selectAll()
				.stream()
				.map((u) -> Mapper.daUtenteAUtenteDTO(u))
				.collect(Collectors.toList());
	}
	
	public UtenteDTO delete(int idUtente) {
		Utente utente = dao.delete(idUtente);
		return Mapper.daUtenteAUtenteDTO(utente);
	}
	
	public UtenteDTO updateEmail(int id, String newEmail) {
		Utente utente = dao.updateEmail(id, newEmail);
		return Mapper.daUtenteAUtenteDTO(utente);
	}
	
	public List<UtenteDTO> sortUtentiNome(){
		List<Utente> ls = dao.selectAll();
		ls.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
		return ls.stream()
				.map(u -> Mapper.daUtenteAUtenteDTO(u))
				.collect(Collectors.toList());
				
	}
	
	public List<String> listaNomi(){
		return dao.selectAll()
				.stream() // trasformo in stream
				.map(((u) -> u.getNome())) // rendo una List di nomi
				.collect(Collectors.toList()); // ritrasfomo in una lista
	}
	
	public List<String> emailConGmail(){
		return dao.selectAll()
				.stream()
				.map((u) -> u.getEmail())
				.filter((e) -> e.contains("@gmail.com"))
				.collect(Collectors.toList());
	}
	
	public List<NomeCognomeDTO> getNomiCognomi(){
		return dao.selectAll()
				.stream()
				.map(u -> new NomeCognomeDTO(u.getNome(), u.getCognome()) )
				.collect(Collectors.toList());
	}
	
	
}
