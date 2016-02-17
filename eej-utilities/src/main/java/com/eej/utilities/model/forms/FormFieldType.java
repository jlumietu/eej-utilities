/**
 * 
 */
package com.eej.utilities.model.forms;

import java.io.Serializable;

/**
 * @author DOIBALMI
 *
 */
public interface FormFieldType extends Serializable {

	abstract String getFieldType();
	
	abstract void setFieldType(String fieldType);
	
}
