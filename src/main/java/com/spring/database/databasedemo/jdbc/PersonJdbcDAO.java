package com.spring.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.database.databasedemo.jdbc.entity.Person;

@Repository
public class PersonJdbcDAO {
	// select * from person

	@Autowired
	JdbcTemplate jbdcTemplate;

	public List<Person> findAll() {
		return jbdcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
}
