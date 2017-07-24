/**
 * 
 */
package com.naren.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naren.rest.Application;
import com.naren.rest.dto.User;

/**
 * Integration test class
 * 
 * @author ntanwa
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class PersonCtrlIntegrationTest {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(PersonCtrlIntegrationTest.class);

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getPersonTest() {
		LOGGER.info("Start Get prson test");
		ResponseEntity<User> responseEntity = restTemplate.getForEntity("/api/v1/person/34", User.class);
		User client = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(34l, client.getId());
	}

}
