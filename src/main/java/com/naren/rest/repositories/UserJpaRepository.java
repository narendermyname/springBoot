/**
 * 
 */
package com.naren.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naren.rest.dto.User;

/**
 * @author ntanwa
 *
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

	// Please find more detail in
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	// Below are query DSL methods
	/**
	 * Find all User with role
	 * 
	 * @param roleStartWith
	 * @return
	 */
	// Data specific language example
	List<User> findByRolesLike(String roleStartWith);// roleName have to be end
	// with %

	/**
	 * Find by email start with
	 * 
	 * @param roleName
	 * @return
	 */
	long countByEmailLike(String roleName);// roleName have to be end with %

	/**
	 * Find name and email.
	 * 
	 * @param name
	 * @param email
	 * @return
	 */
	List<User> findByNameAndEmailLike(String name, String email);

	List<User> findByNameIsOrEmailEquals(String name, String email);

	List<User> findAll();

	List<User> findByNameNotLike(String name); // name should %name or name% or
	// %name%

	List<User> findByNameLike(String name); // name should %name or name% or
	// %name%


	List<User> findByNameStartingWith(String name); // name should name%

	// name% or %name%

	/**
	 * In build criteria method
	 * 
	 * @param email
	 * @return
	 */
	User findByEmail(String email);

	/**
	 * Custom Criteria
	 * 
	 * @param name
	 * @param active
	 * @return
	 */
	@Query("select u from User u where u.name = :name and u.active = :active order by u.name")
	List<User> queryByNameAndActiveUser(@Param("name") String name, @Param("active") int active);

	@Query(value = "select * from USER whre name  = ?0", nativeQuery = true) 
	//Use this query for performance related and data base specific
	User queryByName(String name);

	@Modifying
	@Query("update User u set u.lastName = ?1")
	int update(String lastName);

	List<User> queryByLastName(@Param("lastName") String lastName);
}
