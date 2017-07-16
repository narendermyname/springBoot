/**
 * 
 */
package com.naren.test;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.naren.rest.Person;

/**
 * @author narender
 *
 */
@Configuration
public class ApplicationTest {

	private static final RestTemplate templet =  new RestTemplate();
	private static final String PERSON_RESOURCE = "http://localhost:8080/person";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*ApplicationContext context=new AnnotationConfigApplicationContext(Application.class);
		EntityManagerFactory emf=context.getBean(EntityManagerFactory.class);
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("SELECT p FROM Person p");
		query.getResultList().stream().forEach(e -> System.out.println(e));*/
		//getPersons();
		postPerson();
	}
	
	private static void getPersons(){
		List<Person> p1 = templet.getForObject(PERSON_RESOURCE, List.class);
		//p1.stream().forEach(p -> System.out.println(p1));
	}
	
	private static void postPerson(){
		ResponseEntity<Person> response = templet.postForEntity(PERSON_RESOURCE, new Person("Laxmi Shekhawat"), Person.class);
		System.out.println(response.getBody().toString());
	}

}
