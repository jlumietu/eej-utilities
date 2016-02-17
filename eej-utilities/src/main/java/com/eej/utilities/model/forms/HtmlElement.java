/**
 * 
 */
package com.eej.utilities.model.forms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author DOIBALMI
 *
 */
public interface HtmlElement extends Serializable {
	
	public static final String HTML_ELEMENT_FORM_TAG = "form";
	
	abstract String getTag();
	
	abstract void setTag(String tag);

	abstract String getId();
	
	abstract void setId(String id);
	
	abstract List<String> getHtmlClass(); 
	
	abstract void setHtmlClass(List<String> htmlClass);
	
	abstract Map<String, String> getHtmlAttributes();
	
	abstract void setHtmlAttributes(Map<String, String> htmlAttributes);
	
}
