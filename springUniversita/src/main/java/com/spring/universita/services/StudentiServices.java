package com.spring.universita.services;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.universita.dao.StudentiDAO;
import com.spring.universita.dto.CognomeAnnoNascitaDTO;
import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.dto.cognomeAnnoNascitaDTO;
import com.spring.universita.entity.Studente;
import com.spring.universita.mapper.Mapper;

public class StudentiServices {
	private StudentiDAO dao = new StudentiDAO();
	
	public boolean inserisci(StudenteDTO dto) {
		// qua avviene la conversione StudenteDTO -> Studente
		
		Studente studente = Mapper.daStudenteDTOAStudente(dto);
		return dao.inserisciStudente(studente);
	}
	public StudenteDTO cercaPerMatricola(String matricola) {
		Studente studente = dao.cercaPerMatricola(matricola);
		if (studente != null) {
			return Mapper.daStudenteAStudenteDTO(studente);
		} else {
			return null; // evitiamo nullPointer
		}
	}
	
	public List<StudenteDTO> visualizzaStudenti(){
		return dao.visualizzaStudenti()
				.stream()
				.map(s -> Mapper.daStudenteAStudenteDTO(s)) 
				.collect(Collectors.toList());
	}
	
	public boolean eliminaStudente(String matricola) {
		return dao.cancella(matricola);
	}
	
	public StudenteDTO modificaIndirizzo(String matricola, String indirizzo) {
		Studente studente = dao.modificaIndirizzo(matricola, indirizzo);
		return Mapper.daStudenteAStudenteDTO(studente);
	}
	
	// funzionalita avanzate
	
	public List<String> visualizzaElencoNomi(){
		return dao.visualizzaStudenti()
				.stream()
				.map(s -> s.getNome())
				.collect(Collectors.toList());
	}
	// TODO finisci metodo
	public CognomeAnnoNascitaDTO cognomeAnnoNascitaStudentePiuGiovane() {
		return dao.visualizzaStudenti()
				.stream()
				.map(s -> new CognomeAnnoNascitaDTO(s.getCognome(), s.getAnnoNascita()))
				
	}
	
}
