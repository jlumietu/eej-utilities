/**
 * 
 */
package com.eej.utilities.model.forms;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public abstract class FormElementAbstractImpl extends HtmlElementAbstractImpl implements FormElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private String name;
	
	/* (non-Javadoc)
	 * @see com.ib.utilities.model.forms.FormElement#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see com.ib.utilities.model.forms.FormElement#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}


}
