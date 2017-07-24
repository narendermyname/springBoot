/**
 * 
 */
package com.naren.rest.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * @author ntanwa
 *
 */
@Component
public class AppAccessDeniedHandler implements AccessDeniedHandler {

	private static Logger logger = LoggerFactory.getLogger(AppAccessDeniedHandler.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.access.AccessDeniedHandler#handle(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.access.AccessDeniedException)
	 */
	@Override
	public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException exception)
			throws IOException, ServletException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			logger.info("User '" + auth + "' attempted to access the protected URL: " + req.getRequestURI());
		}

		res.sendRedirect(req.getContextPath() + "/protected");

	}

}
