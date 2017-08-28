/**
 * 
 */
package com.naren.rest.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.naren.rest.exception.GenericException;

/**
 * 
 * Exception Handler for application
 * 
 * @author ntanwa
 *
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerConfig.class);

	@ExceptionHandler(GenericException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handleException(HttpServletRequest req, Exception e) {
		LOGGER.info("Error : {} ", e.getMessage());
	}

	// Either add this exception in Exception class or here
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleNoRecord(HttpServletRequest req, Exception e) {
		LOGGER.info("No Record found {}" + e);
	}
}
