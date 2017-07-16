package com.naren.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource({"classpath:db.properties"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@Component
@Order(value=1)
class PersonComponent implements CommandLineRunner{
	@Autowired
	private PersonRepository personRepo;
	@Override
	public void run(String... arg0) throws Exception {
		for(Person person :personRepo.findAll()){
			System.out.println(person.toString());
		}
	}
}