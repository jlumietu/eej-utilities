/**
 * 
 */
package com.eej.utilities.exception;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public class NoDataTableAnnotationException extends Exception {

	public NoDataTableAnnotationException(String string) {
		super(string);		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;

}
