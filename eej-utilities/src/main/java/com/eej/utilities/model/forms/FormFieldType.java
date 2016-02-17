/**
 * 
 */
package com.eej.utilities.model.forms;

import java.io.Serializable;

/**
 * @author jlumietu
 *
 */
public interface FormFieldType extends Serializable {

	abstract String getFieldType();
	
	abstract void setFieldType(String fieldType);
	
}
