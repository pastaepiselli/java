package com.spring.utenti.mapper;

import com.spring.utenti.dto.UtenteDTO;
import com.spring.utenti.entity.Utente;

// classe delle conversioni
public class Mapper {
	// metodi statici per dto -> Entity
	public static Utente daUtenteDTOAUtente(UtenteDTO dto) {
		return new Utente(dto.getIdUtente(), dto.getNome(), dto.getCognome(), dto.getEmail(), dto.getTelefono());
	}
	
	public static UtenteDTO daUtenteAUtenteDTO(Utente utente) {
		return new UtenteDTO(utente.getIdUtente(), utente.getNome(), utente.getCognome(), utente.getEmail(), utente.getTelefono());
	}
	
}
