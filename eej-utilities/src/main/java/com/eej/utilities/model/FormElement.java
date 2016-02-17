/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;
import java.util.List;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class FormElement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private String name;
	
	private String id;
	
	private List<String> classes;
	
	private String action;
	
	private String method;
	
	private String type;
	
	private List<FormInput> inputs;

}
