/**
 * 
 */
package com.naren.rest.exception;

/**
 * @author ntanwa
 *
 */
public class ErrorInfo {

	private String url;
	private String message;
	public ErrorInfo(String contextPath, String message) {
		this.url = contextPath;
		this.message =  message;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ErrorInfo [url=" + url + ", message=" + message + "]";
	}
}
