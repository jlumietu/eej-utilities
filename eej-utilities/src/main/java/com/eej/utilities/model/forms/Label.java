/**
 * 
 */
package com.eej.utilities.model.forms;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public interface Label extends HtmlElement {

	abstract void setForId(String forId);
	
	abstract String getForId();
	
}
