/**
 * 
 */
package com.naren.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Rest MVC Configuration to enable Spring Data REST
 * @author ntanwa
 *
 */
@Configuration
public class RestMvcConfiguration extends RepositoryRestMvcConfiguration {

	@Override
	public RepositoryRestConfiguration  config(){
		RepositoryRestConfiguration config = super.config();
		config.setBasePath("/api/v1");
		return config;
	}
}
