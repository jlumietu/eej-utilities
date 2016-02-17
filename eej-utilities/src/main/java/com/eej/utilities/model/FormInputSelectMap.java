/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;
import java.util.Map;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class FormInputSelectMap extends FormInputSelect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private Map<? extends Serializable, String> options;

	/**
	 * @return the options
	 */
	public Map<? extends Serializable, String> getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(Map<? extends Serializable, String> options) {
		this.options = options;
	}
	

}
