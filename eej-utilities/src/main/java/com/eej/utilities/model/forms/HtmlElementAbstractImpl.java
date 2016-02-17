/**
 * 
 */
package com.eej.utilities.model.forms;

import java.util.List;
import java.util.Map;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public abstract class HtmlElementAbstractImpl implements HtmlElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private Map<String, String> htmlAttributes;
	private List<String> htmlClass;
	private String id;
	private String tag;
	
	

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.HtmlElement#getTag()
	 */
	@Override
	public String getTag() {
		return this.tag;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.HtmlElement#setTag(java.lang.String)
	 */
	@Override
	public void setTag(String tag) {
		this.tag = tag;
		
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.HtmlElement#getId()
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.HtmlElement#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.HtmlElement#getHtmlClass()
	 */
	@Override
	public List<String> getHtmlClass() {
		return this.htmlClass;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.HtmlElement#setHtmlClass(java.util.List)
	 */
	@Override
	public void setHtmlClass(List<String> htmlClass) {
		this.htmlClass = htmlClass;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.HtmlElement#getHtmlAttributes()
	 */
	@Override
	public Map<String, String> getHtmlAttributes() {
		// TODO Auto-generated method stub
		return this.htmlAttributes;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.HtmlElement#setHtmlAttributes(java.util.Map)
	 */
	@Override
	public void setHtmlAttributes(Map<String, String> htmlAttributes) {
		this.htmlAttributes = htmlAttributes;
	}

}
