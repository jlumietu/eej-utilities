/**
 * 
 */
package com.eej.utilities.model.forms;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class FormLabel extends HtmlElementAbstractImpl implements Label {

	public static final String HTML_LABEL_TAG = "label";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	private String forId;
	
	/**
	 * 
	 */
	public FormLabel() {
		super();
		this.setTag(HTML_LABEL_TAG);
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.Label#setForId(java.lang.String)
	 */
	@Override
	public void setForId(String forId) {
		this.forId = forId;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.Label#getForId()
	 */
	@Override
	public String getForId() {
		return this.forId;
	}

	


}
