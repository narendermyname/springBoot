/**
 * 
 */
package com.naren.rest.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ntanwa
 *
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class SystemExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(SystemExceptionHandler.class);

	@ExceptionHandler(GenericException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorInfo handleException(HttpServletRequest req, Exception e) {
		LOGGER.info("Error : {} ", e.getMessage());
		return new ErrorInfo(req.getContextPath(), e.getMessage());
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Record Exist.")
	// Either add this exception in Exception class or here
	@ExceptionHandler(NotFoundException.class)
	public void handleNoRecord() {
		LOGGER.info("No Record found {}");
	}
}
