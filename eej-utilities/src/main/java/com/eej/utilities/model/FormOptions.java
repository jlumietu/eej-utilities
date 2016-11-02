/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public class FormOptions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private Class<? extends Serializable> value;
	
	private String label;
	
	private boolean defaultSelected;

	/**
	 * @return the value
	 */
	public Class<? extends Serializable> getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Class<? extends Serializable> value) {
		this.value = value;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the defaultSelected
	 */
	public boolean isDefaultSelected() {
		return defaultSelected;
	}

	/**
	 * @param defaultSelected the defaultSelected to set
	 */
	public void setDefaultSelected(boolean defaultSelected) {
		this.defaultSelected = defaultSelected;
	}
	
	

}
