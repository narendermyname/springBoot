/**
 * 
 */
package com.naren.rest.dto.projection;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.naren.rest.dto.Role;
import com.naren.rest.dto.User;

/**
 * @author ntanwa
 *
 */
@Projection(name="userDetail", types = {User.class})
public interface UserDetail {

	Long getId();
	int getActive();
	String getEmail();
	String getLastName();
	//@Vaule annotation help us to avaide any erro that can be come if we modify User get method
	@Value("#{target.name}") 
	String getUserName();
	Set<Role> getRoles();
}
