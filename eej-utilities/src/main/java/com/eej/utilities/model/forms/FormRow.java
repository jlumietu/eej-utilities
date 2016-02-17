/**
 * 
 */
package com.eej.utilities.model.forms;

import java.io.Serializable;

/**
 * @author jlumietu
 *
 */
public interface FormRow extends Serializable {

	abstract FormField getFormField();
	
	abstract void setFormField(FormField formField);
	
	abstract HtmlEmbeddableElement getHtmlElementContainer();
	
	abstract void setHtmlElementContainer(HtmlEmbeddableElement element); 
	
}
