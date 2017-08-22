/**
 * 
 */
package com.naren.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.naren.rest.dto.Role;
import com.naren.rest.dto.User;

/**
 * @author narender
 *
 */
@Configuration
public class ApplicationTest {

	private static final RestTemplate templet = new RestTemplate();
	private static final String PERSON_RESOURCE = "http://localhost:8080/person";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ApplicationContext context=new
		 * AnnotationConfigApplicationContext(Application.class);
		 * EntityManagerFactory emf=context.getBean(EntityManagerFactory.class);
		 * EntityManager em=emf.createEntityManager(); Query
		 * query=em.createQuery("SELECT p FROM Person p");
		 * query.getResultList().stream().forEach(e -> System.out.println(e));
		 */
		// getUsers();
		postUser();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private static void getUsers() {
		List<User> p1 = templet.getForObject(PERSON_RESOURCE, List.class);
		// p1.stream().forEach(p -> System.out.println(p1));
	}

	private static void postUser() {
		Set<Role> roles = new HashSet<>();

		roles.add(new Role(1, "ROLE_USER"));

		ResponseEntity<User> response = templet.postForEntity(PERSON_RESOURCE,
				new User(1, "slaxmi@gmail.com", "password", "Laxmi", "Shekhawat", 1, roles), User.class);
		System.out.println(response.getBody().toString());
	}
}
