package com.spring.database.databasedemo;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.databasedemo.jdbc.PersonJdbcDAO;
import com.spring.database.databasedemo.jdbc.entity.Person;
import com.spring.database.databasedemo.jpa.PersonJPARepository;

@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJPARepository jpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Find user by id : {}",jpaRepository.findById(1));
	}
}
