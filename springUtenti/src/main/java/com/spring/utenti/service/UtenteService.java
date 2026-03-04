package com.spring.utenti.service;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.utenti.dao.DAOUtenteMappa;
import com.spring.utenti.entity.Utente;

public class UtenteService {
	private DAOUtenteMappa dao = new DAOUtenteMappa();
	
	public boolean registra(Utente utente) {
		return dao.insert(utente);
		
	}
	
	public Utente cercaPerId(int idUtente) {
		return dao.selectById(idUtente);
	}
	
	public List<Utente> listAll(){
		return dao.selectAll();
	}
	
	public Utente delete(int idUtente) {
		return dao.delete(idUtente);
	}
	
	public Utente updateEmail(int id, String newEmail) {
		return dao.updateEmail(id, newEmail);
	}
	
	public List<Utente> sortUtentiNome(){
		List<Utente> ls = dao.selectAll();
		ls.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
		return ls;
				
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
}
