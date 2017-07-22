/**
 * 
 */
package com.naren.rest.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naren.rest.dto.Person;
import com.naren.rest.exception.GenericException;
import com.naren.rest.exception.NotFoundException;
import com.naren.rest.repositories.PersonRepository;

/**
 * @author ntanwa
 *
 */

@RestController
@RequestMapping("/api/v1")
public final class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonRepository personRepo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void home(HttpServletResponse response) throws IOException {
		response.sendRedirect("/person");
	}

	/**
	 * Get
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(value = "person", method = RequestMethod.GET)
	public Collection<Person> findAll() throws NotFoundException {
		if (personRepo.findAll().isEmpty()) {
			throw new NotFoundException("No record found in DB. ");
		} else
			return personRepo.findAll();
	}

	/**
	 * Get
	 * 
	 * @return
	 * @throws GenericException
	 */
	@RequestMapping(value = "person/{id}", method = RequestMethod.GET)
	public Person find(@PathVariable("id") String id) throws GenericException {
		return personRepo.findOne(parseId(id));
	}

	/**
	 * Add Person
	 * 
	 * @param req
	 * @param person
	 * @return {person}
	 */
	@RequestMapping(value = "person", method = RequestMethod.POST)
	public Person add(HttpServletRequest req, @RequestBody Person person) {
		return personRepo.saveAndFlush(person);
	}

	/**
	 * Add Person
	 * 
	 * @param req
	 * @param person
	 * @return {person}
	 * @throws Exception
	 */
	@RequestMapping(value = "person/{id}", method = RequestMethod.PUT)
	public Person add(@PathVariable("id") String id, @RequestBody Person person) throws GenericException {
		// String credentials = req.getHeader("Authorization");
		Person exist = personRepo.findOne(parseId(id));
		BeanUtils.copyProperties(person, exist);
		return personRepo.saveAndFlush(person);
	}

	/**
	 * Get
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "person/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) throws GenericException {
		personRepo.delete(parseId(id));
	}

	/**
	 * Parse String Id to long or throw Generic Exception if id is not proper.
	 * @param id
	 * @return
	 * @throws GenericException
	 */
	private Long parseId(String id) throws GenericException {
		LOGGER.info("Parsing Id " + id);
		try {
			return Long.parseLong(id);
		} catch (NumberFormatException e) {
			LOGGER.info("Error : " + e.getMessage());
			throw new GenericException("Record with Id  " + id + " not found");
		}
	}
}