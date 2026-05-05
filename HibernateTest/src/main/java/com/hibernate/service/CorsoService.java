package com.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.entity.Corso;
import com.hibernate.repository.CorsoRepository;

@Service
public class CorsoService {
	@Autowired
	CorsoRepository corsoRepository; 
	
	public List<Corso> getListaCorsi(){
		return corsoRepository.getListaCorsi();
	}
}
