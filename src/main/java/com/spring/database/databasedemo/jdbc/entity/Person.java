package com.spring.database.databasedemo.jdbc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="birth_date")
	private Date birthdate;
	
	
	public Person() {
		
	}
	
	public Person(int id, String name, String location, java.util.Date date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthdate = date;
	}
	
	public Person(String name, String location, java.util.Date date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthdate = date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return String.format("\n"+id+" "+name+" "+location+" "+birthdate);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
