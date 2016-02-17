/**
 * 
 */
package com.eej.utilities.model.forms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author jlumietu
 *
 */
public interface FormElement extends HtmlElement, Serializable {
	
	abstract String getName();
	
	abstract void setName(String name);
	
	abstract String getType();
	
	abstract void setType(String name);

}
