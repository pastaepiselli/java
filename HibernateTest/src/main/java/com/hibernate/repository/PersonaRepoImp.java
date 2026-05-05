package com.hibernate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.dto.PersonaDTO;
import com.hibernate.entity.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

// il repository interroghera in nostro database
@Repository
public class PersonaRepoImp implements PersonaRepo {
	
	// quando inizializzaeremo la nostra applicazione grazie ad esso bean non ho capito dio cane 
	@PersistenceContext
	EntityManager entityManager; 
	
	@Override
	public List<Persona> getPersonaList() {
		Query q = entityManager.createQuery("Select p from Persona p");
		return q.getResultList(); // ritorna come una lista la query ritornata 
	}

	@Override
	@Transactional // se qualcosa va storto durante l'inserimento dei dati fa il rollback
	public Persona insertPersona(Persona p) {
		entityManager.persist(p); // persist() inserisce l'oggetto nel db
		return p;
		
	}

	@Override
	@Transactional
	public Persona updatePersona(Persona p) {
		return entityManager.merge(p); // merge aggiorna l'entity		
		
	}

	@Override
	@Transactional
	public Persona deletePersona(Long id) {
		
		Persona d = entityManager.find(Persona.class, id);
		entityManager.remove(d);
		return d;
	}

	@Override
	public List<Persona> findPersonaByName(String nome) {
		Query q = entityManager.createQuery("Select p from Persona p where p.nome = :nome"); // query che cerca per nome
		q.setParameter("nome", nome); // assegna a :nome il valore nome 
		
		return q.getResultList();
	}
	
}
