/**
 * 
 */
package com.eej.utilities.model.forms;

import java.io.Serializable;
import java.util.List;

/**
 * @author jlumietu
 *
 */
public interface Form extends FormElement, Serializable {
	
	
	
	public static final String HTTP_METHOD_POST = "POST";
	public static final String HTTP_METHOD_GET = "GET";
	public static final String HTTP_METHOD_PUT = "PUT";
	public static final String HTTP_METHOD_DELETE = "DELETE";
	
	abstract String getAction();
	
	abstract void setAction(String action);
	
	abstract String getMethod();
	
	abstract void setMethod(String method);	
	
	abstract String getEncType();
	
	abstract void setEncType(String encType);
	
	abstract List<? extends FormField> getFieldList();
	
	abstract void setFieldList(List<? extends FormField> fieldList);

}
