package com.naren.rest;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableJpaRepositories
///@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/nstanwar");
		dataSource.setUsername( "root" );
		dataSource.setPassword( "root" );
		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.naren");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		factory.setJpaProperties(additionalProperties());

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}
}

@RestController
class RestPersonResource{
	@Autowired
	private PersonRepository personRepo;
	@RequestMapping("personList")
	public Collection<Person> getPersonList(){
		Person p=new Person();
		p.setId(1001);
		personRepo.delete(p);
		return personRepo.findAll();
	}
	@RequestMapping("add")
	public String add(){
		Person p=new Person();
		p.setId(100000);
		p.setName("sddd");
		return "SUCCESS";
	}
}
@Component
class PersonComponent implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepo;
	@Override
	public void run(String... arg0) throws Exception {
		Person p=new Person();
		p.setId(1001);
		personRepo.delete(p);
		for(Person person :personRepo.findAll()){
			System.out.println(person.toString());
		}
		
	}
	
}

@Repository
interface PersonRepository extends JpaRepository<Person, Long> {
	
	
	List<Person> findAll();
	

}


@Entity
class Person{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;	
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Person() {
		super();
	}

}