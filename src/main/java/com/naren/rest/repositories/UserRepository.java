/**
 * 
 */
package com.naren.rest.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naren.rest.dto.User;

/**
 * @author ntanwa
 *
 */

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	
	private UserJpaRepository userRepo;
	
	@SuppressWarnings("unchecked")
	public List<User> getPersons(){
		
		return manager.createQuery("from User").getResultList();
	}
	
	public List<User> findAll(){
		return userRepo.findAll();
	}

}
