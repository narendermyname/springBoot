/**
 * 
 */
package com.naren.rest.config;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.naren.rest.dto.User;

/**
 * This event trigger when ever we try to create, update, delete and get user resource.
 * @author ntanwa
 *
 */

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

	@HandleBeforeCreate
	public void handleBeforeCreate(User user) throws Exception{
		if(user.getActive() == 1){
			throw new Exception();
		}
	}
}
