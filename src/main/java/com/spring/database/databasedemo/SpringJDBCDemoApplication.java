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

@SpringBootApplication
public class SpringJDBCDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		logger.info("Id users : {}",dao.findById(2));
//		logger.info("Name users : {}",dao.findByName("Jagoth3"));
//		logger.info("ID and Name user : {}",dao.findByIDandName(4, "Jagoth4"));
//		logger.info("Delete person having id 1 : {}",dao.daleteById(1));
		logger.info("inserting 100 -> {}",
				dao.insert(new Person(100,"SHAWON","SYLHET",new Date())));
		logger.info("Update ID = 3 -> {}",
				dao.update(new Person(3,"SHAWON","SYLHET",new Date())));
		logger.info("All users : {}",dao.findAll());
	}
}
