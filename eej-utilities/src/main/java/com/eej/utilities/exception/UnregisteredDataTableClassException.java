/**
 * 
 */
package com.eej.utilities.exception;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public class UnregisteredDataTableClassException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;

	/**
	 * 
	 */
	public UnregisteredDataTableClassException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnregisteredDataTableClassException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UnregisteredDataTableClassException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UnregisteredDataTableClassException(Throwable cause) {
		super(cause);
	}
	
	

}
