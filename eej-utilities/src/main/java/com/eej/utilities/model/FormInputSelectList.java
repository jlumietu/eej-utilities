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
public class FormInputSelectList extends FormInputSelect implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private List<FormOptions> options;

	/**
	 * @return the options
	 */
	public List<FormOptions> getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(List<FormOptions> options) {
		this.options = options;
	}	

}
