/**
 * 
 */
package com.naren.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naren.rest.dto.User;

/**
 * @author ntanwa
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAll();

	/**
	 * @param email
	 * @return
	 */
	User findByEmail(String email);
}
