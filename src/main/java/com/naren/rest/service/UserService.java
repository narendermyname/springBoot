/**
 * 
 */
package com.naren.rest.service;

import com.naren.rest.dto.User;

/**
 * @author ntanwa
 *
 */
public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
