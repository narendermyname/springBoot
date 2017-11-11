package com.naren.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.naren.rest.controller.UserController;
import com.naren.rest.dto.Role;
import com.naren.rest.dto.User;
import com.naren.rest.repositories.UserJpaRepository;

/**
 * Unit test class
 * 
 * @author ntanwa
 *
 */
public class PersonControllerTest {

	@InjectMocks
	private UserController pc;

	@Mock
	private UserJpaRepository personRepo;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getTest() {
		User p = null;
		try {
			// Creating mock data
			Set<Role> roles = new HashSet<>();

			roles.add(new Role(1, "ROLE_USER"));
			User user = new User(1, "slaxmi@gmail.com", "password", "Laxmi", "Shekhawat", 1, roles);
			// Setting when findOne called what to return
			when(personRepo.findOne(1l)).thenReturn(user);

			// Then get
			p = pc.find(1l);
			System.out.println(p);

			// Verify findOne was called or not
			verify(personRepo).findOne(1l);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		// Test
		assertEquals(1l, p.getId());
	}

}
