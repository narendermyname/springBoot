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

import com.naren.rest.dto.User;
import com.naren.rest.exception.GenericException;
import com.naren.rest.exception.NotFoundException;
import com.naren.rest.repositories.UserJpaRepository;
import com.naren.rest.repositories.UserRepository;

/**
 * @author ntanwa
 *
 */

@RestController
@RequestMapping("/api/v1")
public final class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserJpaRepository userRepo;

	/**
	 * Get
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public Collection<User> findAll() throws NotFoundException {
		if (userRepo.findAll().isEmpty()) {
			throw new NotFoundException("No record found in DB. ");
		} else
			return userRepo.findAll();
	}

	/**
	 * Get
	 * 
	 * @return
	 * @throws GenericException
	 */
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public User find(@PathVariable("id") Long id) throws GenericException {
		return userRepo.findOne(id);
	}

	/**
	 * Add user
	 * 
	 * @param req
	 * @param user
	 * @return {user}
	 */
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public User add(HttpServletRequest req, @RequestBody User user) {
		return userRepo.saveAndFlush(user);
	}

	/**
	 * Add user
	 * 
	 * @param req
	 * @param user
	 * @return {user}
	 * @throws Exception
	 */
	@RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
	public User add(@PathVariable("id") Long id, @RequestBody User user) throws GenericException {
		User exist = userRepo.findOne(id);
		BeanUtils.copyProperties(user, exist);
		return userRepo.saveAndFlush(user);
	}

	/**
	 * Get
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) throws GenericException {
		userRepo.delete(id);
	}
}