/**
 * 
 */
package com.naren.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ntanwa
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findAll();
}
