/**
 * 
 */
package com.naren.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naren.rest.dto.Person;

/**
 * @author ntanwa
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findAll();
}
