/**
 * 
 */
package com.eej.utilities.model.forms;

import java.io.Serializable;

/**
 * @author jlumietu
 *
 */
public interface FormField extends FormElement {
	
	public abstract void setValue(Serializable value);
	
	public abstract Serializable getValue();
	
	public abstract void setRequired(boolean required);
	
	public abstract boolean isRequired();
	
	public abstract Label getLabel();
	
	public abstract void setLabel(Label label);

}
