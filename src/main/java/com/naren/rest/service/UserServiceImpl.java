/**
 * 
 */
package com.naren.rest.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.naren.rest.dto.Role;
import com.naren.rest.dto.User;
import com.naren.rest.repositories.RoleRepository;
import com.naren.rest.repositories.UserJpaRepository;

/**
 * @author ntanwa
 *
 */
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJpaRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Set<Role> userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(userRole);
		userRepository.save(user);
	}

}