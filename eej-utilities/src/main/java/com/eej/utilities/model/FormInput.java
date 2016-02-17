/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;
import java.util.List;

import com.eej.utilities.ApplicationVersion;

/**
 * @author DOIBALMI
 *
 */
public class FormInput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private FormInputType type;
	
	private String id;
	
	private String name;
	
	private List<String> classes;
	
	private boolean required;

	/**
	 * @return the type
	 */
	public FormInputType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(FormInputType type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the classes
	 */
	public List<String> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(List<String> classes) {
		this.classes = classes;
	}

	/**
	 * @return the required
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * @param required the required to set
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	

}
