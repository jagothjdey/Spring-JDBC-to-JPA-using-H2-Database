package com.spring.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.database.databasedemo.jdbc.entity.Person;

@Repository
public class PersonJdbcDAO {
	// select * from person

	@Autowired
	JdbcTemplate jbdcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthdate(rs.getTimestamp("birth_date"));
			return person;
		}
	}

	public List<Person> findAll() {
		return jbdcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {
		Person queryForObject = jbdcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
		return queryForObject;
	}

	public Person findByName(String name) {
		Person queryForObject = jbdcTemplate.queryForObject("select * from person where name=?", new Object[] { name },
				new BeanPropertyRowMapper<Person>(Person.class));
		return queryForObject;
	}

	public Person findByIDandName(int id, String name) {
		Person queryForObject = jbdcTemplate.queryForObject("select * from person where id=? and name=?",
				new Object[] { id, name }, new BeanPropertyRowMapper<Person>(Person.class));
		return queryForObject;
	}

	public int daleteById(int id) {
		return jbdcTemplate.update("delete from person where id=?", new Object[] { id });
	}

	public int insert(Person person) {
		return jbdcTemplate.update("insert into person(id,name,location,birth_date) values(?, ?, ?, ?)",
				new Object[] { 
						person.getId(), person.getName(), 
						person.getLocation(),
						new Timestamp(person.getBirthdate().getTime()) });
	}
	
	public int update(Person person) {
		return jbdcTemplate.update("update person set name=?, location=?, birth_date=? where id=?",
				new Object[] { 
						person.getName(), 
						person.getLocation(),
						new Timestamp(person.getBirthdate().getTime()),
						person.getId()});
	}

}
