/**
 * 
 */
package com.naren.rest.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Security Configuration bean
 * @author ntanwa
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${user-query}")
	private String usersQuery;

	@Value("${role-query}")
	private String rolesQuery;

	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String adminRole = env.getProperty("spring.sec.admin.role");
		String userRole = env.getProperty("spring.sec.user.role");
		http.httpBasic()
		.and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		//.antMatchers("/hello").permitAll()
		.antMatchers("/api/v1/**").hasAnyRole(adminRole)
		.antMatchers("/admin/**").hasAnyRole(adminRole)
		.antMatchers("/user/**").hasAnyRole(userRole)
		.anyRequest().authenticated()
		.and().formLogin()
		.permitAll()
		.loginPage("/login").permitAll()
		.and().logout().logoutUrl("/logout").permitAll()
		.and().exceptionHandling()
		.accessDeniedHandler(accessDeniedHandler);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		if ("true".equalsIgnoreCase(env.getProperty("spring.security.inmemory.enable")))
			auth.inMemoryAuthentication().withUser(env.getProperty("spring.sec.user.name"))
			.password(env.getProperty("spring.sec.user.password"))
			.roles(env.getProperty("spring.sec.user.role")).and()
			.withUser(env.getProperty("spring.sec.admin.name"))
			.password(env.getProperty("spring.sec.admin.password"))
			.roles(env.getProperty("spring.sec.admin.role"));
		else
			auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
			.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
