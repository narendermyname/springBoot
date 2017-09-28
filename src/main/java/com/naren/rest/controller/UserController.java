/**
 * 
 */
package com.naren.rest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naren.rest.dto.User;
import com.naren.rest.exception.GenericException;
import com.naren.rest.exception.NotFoundException;
import com.naren.rest.repositories.UserJpaRepository;

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

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Get
	 * 
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public Collection<User> findAll(
			@RequestParam(name = "activeUser", required = false, defaultValue = "1") int activeUser,
			@RequestParam(name = "startPage", required = false, defaultValue = "0") int startPage,
			@RequestParam(name = "endPage", required = false, defaultValue = "25") int endPage,
			@RequestParam(name = "sortByColumn", required = false, defaultValue = "id") String sortByColumn,
			@RequestParam(name = "orderBy", required = false, defaultValue = "ASC") String orderBy)
					throws NotFoundException {

		Sort sort = Sort.Direction.ASC.name().equalsIgnoreCase(orderBy) ? new Sort(Sort.Direction.ASC, sortByColumn)
				: new Sort(Sort.Direction.DESC, sortByColumn);
		;
		if (userRepo.findAll().isEmpty()) {
			throw new NotFoundException("No record found in DB. ");
		} else
			return userRepo.queryByActiveUser(activeUser, new PageRequest(startPage, endPage, sort)).getContent();
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
	@PostMapping(value = "user")
	public User add(HttpServletRequest req, @RequestBody User user) {
		LOGGER.debug("Saving user "+user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
	@PutMapping(value = "user/{id}")
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
	@DeleteMapping(value = "user/{id}")
	public void delete(@PathVariable("id") Long id) throws GenericException {
		userRepo.delete(id);
	}
}