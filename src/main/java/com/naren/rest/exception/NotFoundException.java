/**
 * 
 */
package com.naren.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ntanwa
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Person Not found." )
public class NotFoundException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2115808067207671416L;

	/**
	 * 
	 */
	public NotFoundException() {
	}

	/**
	 * @param message
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
