/**
 * 
 */
package com.eej.utilities.model.forms;

import java.io.Serializable;

/**
 * Representa elementos que se incluyen dentro del propio HTML, 
 * 
 * @author jlumietu
 *
 */
public interface HtmlEmbeddable extends Serializable {

	abstract HtmlElement getAncestor();
	
	abstract void setAncestor(HtmlElement ancestor);
	
}
