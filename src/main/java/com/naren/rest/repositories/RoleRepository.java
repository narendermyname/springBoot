/**
 * 
 */
package com.naren.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naren.rest.dto.Role;

/**
 * @author ntanwa
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRole(String role);
}
