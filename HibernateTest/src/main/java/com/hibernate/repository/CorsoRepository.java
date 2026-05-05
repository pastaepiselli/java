package com.hibernate.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hibernate.entity.Corso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CorsoRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	public List<Corso> getListaCorsi(){
		Query q = entityManager.createQuery("Select c from corso c");
		return q.getResultList();
	}
}
