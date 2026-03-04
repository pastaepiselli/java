package com.spring.universita.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.spring.universita.dao.StudentiDAO;
import com.spring.universita.dto.CognomeAnnoImmatricolazioneDTO;
import com.spring.universita.dto.CognomeAnnoNascitaDTO;
import com.spring.universita.dto.StudenteDTO;
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
	
	public CognomeAnnoNascitaDTO cognomeAnnoNascitaStudentePiuGiovane() {
		return dao.visualizzaStudenti()
				.stream()
				.map(s -> new CognomeAnnoNascitaDTO(s.getCognome(), s.getAnnoNascita()))
				.max(Comparator.comparingInt(dto -> dto.getAnnoNascita())) // studente con anno di nascita maggiore
				.orElse(null);
	}
	
	public CognomeAnnoImmatricolazioneDTO cognomeAnnoImmatricolazionePiuVecchio() {
		return dao.visualizzaStudenti()
				.stream()
				.map(s -> new CognomeAnnoImmatricolazioneDTO(s.getCognome(), s.getAnnoImmatricolazione()))
				.min(Comparator.comparingInt(dto -> dto.getAnnoImmatricolazione())) // anno imm minore
				.orElse(null); // se la lista e vuota ritorno null
				
	}
	
	
	
}
