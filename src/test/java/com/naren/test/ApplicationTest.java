/**
 * 
 */
package com.naren.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naren.rest.Application;

/**
 * @author narender
 *
 */
public class ApplicationTest {

	/**
	 * 
	 */
	public ApplicationTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	//@Test
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Application.class);
		EntityManagerFactory emf=context.getBean(EntityManagerFactory.class);
		EntityManager em=emf.createEntityManager();
		Query query=em.createNativeQuery("SELECT * FROM Person");
		System.out.println(query.getResultList());
		
	}

}
