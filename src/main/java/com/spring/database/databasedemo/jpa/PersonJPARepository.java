package com.spring.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.database.databasedemo.jdbc.entity.Person;

@Repository
@Transactional
public class PersonJPARepository {
	// connect to the database
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
}
