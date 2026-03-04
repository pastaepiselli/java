package com.spring.universita.services;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.universita.dao.ProfessoriDAO;
import com.spring.universita.dto.ProfessoreDTO;
import com.spring.universita.entity.Professore;
import com.spring.universita.mapper.Mapper;

public class ProfessoriServices {
	private ProfessoriDAO dao = new ProfessoriDAO();
	
	public boolean inserisci(ProfessoreDTO dto) {
		Professore professore = Mapper.daProfessoreDTOAProfessore(dto);
		return dao.inserisciProfessore(professore);
	}
	
	public ProfessoreDTO cercaPerId(int id) {
		Professore professore = dao.cercaPerId(id);
		if (professore != null) { // magari nn esiste evito nullPointer
			return Mapper.daProfessoreAProfessoreDTO(professore);
		} else {
			return null;
		}
	}
	
	public List<ProfessoreDTO> visualizzaProfessori(){
		return dao.visualizzaProfessori()
				.stream() // trasfomo in stream
				.map(p -> Mapper.daProfessoreAProfessoreDTO(p)) // ogni prof lo trasformo in DTO
				.collect(Collectors.toList()); // ricreo la lista
	}
	
	public boolean cancella(int id) {
		return dao.cancella(id); // ritorna true o false
	}
	
	public ProfessoreDTO cambiaMateria(int id, String nuovaMateria) {
		return Mapper.daProfessoreAProfessoreDTO(dao.modificaMateria(id, nuovaMateria));
	}
	
	// avanzate
	
	public List<ProfessoreDTO> insegnaMateria(String materia){
		return dao.visualizzaProfessori()
				.stream()
				.filter(p -> p.getMateriaInsegnamento().equalsIgnoreCase(materia)) // prende solo quelli con materia specificata
				.map(p -> Mapper.daProfessoreAProfessoreDTO(p)) // converte in DTO
				.collect(Collectors.toList());
	}
	
	public List<String> ordinamentoCognome(){
		return dao.visualizzaProfessori()
				.stream()
				.map(p -> p.getCognome()) // prendo solo i cognomi
				.sorted( (p1, p2) -> p1.compareTo(p2)) // ordino per alfabetico ascendente
				.collect(Collectors.toList());
	}
	
	public List<String> visualizzaMaterie(){
		return dao.visualizzaProfessori()
				.stream()
				.map(p -> p.getMateriaInsegnamento())
				.collect(Collectors.toList());
	}
	
	
}
