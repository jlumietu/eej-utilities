/**
 * 
 */
package com.eej.utilities.model.formsv2;

/**
 * @author DOIBALMI
 *
 */
public interface FormElement extends HtmlElementObject {
	
	public abstract HtmlElementObject getHtmlWrapper();
	
	public abstract void setHtmlWrapper(HtmlElementObject wrapper);
	

}
