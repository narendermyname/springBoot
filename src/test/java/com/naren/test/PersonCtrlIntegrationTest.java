/**
 * 
 */
package com.naren.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
	public void getUsersTest() {
		LOGGER.info("List all users");
		//restTemplate.withBasicAuth("naren@gmail.com", "nsecret");
		try{
			HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    headers.add("Authorization", "Basic bmFyZW5AZ21haWwuY29tOm5zZWNyZXQ=");
		    
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		     
		    ResponseEntity<String> responseEntity = restTemplate.exchange("/api/v1/user", HttpMethod.GET, entity, String.class);
		    
			String client = responseEntity.getBody();
			LOGGER.info(client);
			/*assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
			assertTrue(!client.isEmpty());*/
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	

}
