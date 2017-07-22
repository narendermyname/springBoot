package com.naren.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.naren.rest.controller.PersonController;
import com.naren.rest.dto.Person;
import com.naren.rest.exception.GenericException;
import com.naren.rest.repositories.PersonRepository;

/**
 * Unit test class
 * @author ntanwa
 *
 */
public class PersonControllerTest {

	@InjectMocks
	private PersonController pc;
	
	@Mock
	private PersonRepository personRepo;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getTest() {
		Person p = null;
		try {
			when(personRepo.findOne(1l)).thenReturn(new Person(1l,"Naren"));
			p = pc.find("1");
			verify(personRepo).findOne(1l);
		} catch (GenericException e) {
			System.out.println("Error : "+e.getMessage());
		}
		
		assertEquals(1l,p.getId());
	}

}
