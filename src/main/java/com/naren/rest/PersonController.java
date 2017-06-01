/**
 * 
 */
package com.naren.rest;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ntanwa
 *
 */

@RestController
public final class PersonController{
	
	@Autowired
	private PersonRepository personRepo;
	
	@RequestMapping("/")
	public void home(HttpServletResponse response) throws IOException{
		response.sendRedirect("/person");
	}
	/**
	 * Get 
	 * @return
	 */
	@RequestMapping(value = "person", method = RequestMethod.GET)
	public Collection<Person> get(){
		return personRepo.findAll();
	}
	/**
	 * Add Person
	 * @param req
	 * @param person
	 * @return {person}
	 */
	@RequestMapping(value = "person", method = RequestMethod.POST)
	public Person add(HttpServletRequest req, @RequestBody Person person){
		//String credentials = req.getHeader("Authorization");
		Person pResponse = personRepo.save(person);
		return pResponse;
	}
}