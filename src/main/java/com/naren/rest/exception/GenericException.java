/**
 * 
 */
package com.naren.rest.exception;

/**
 * @author ntanwa
 *
 */
public class GenericException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2323059630189348401L;
	
	public GenericException(String message){
		super(message);
	}
	
	public GenericException(String message, Throwable exception){
		super(message,exception);
	}

}
