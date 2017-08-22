package com.naren.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.naren.rest.dto.User;
import com.naren.rest.repositories.UserRepository;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableScheduling
@PropertySource({"classpath:db-mysql.properties"})//if this commented it will connect to DB2
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@Component
@Order(value=1)
class UserComponent implements CommandLineRunner{
	@Autowired
	private UserRepository userRepo;
	
	/*@Autowired
	private GenericRepository genericRepo;*/
	@Override
	public void run(String... arg0) throws Exception {
		for(User person :userRepo.findAll()){
			System.out.println(person.toString());
		}
		//System.out.println(repo.getPersons());
		
	}
	
	
}