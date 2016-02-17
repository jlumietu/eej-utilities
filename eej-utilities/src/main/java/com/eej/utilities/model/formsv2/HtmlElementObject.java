/**
 * 
 */
package com.eej.utilities.model.formsv2;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author DOIBALMI
 *
 */
public interface HtmlElementObject extends Serializable {
	
	public abstract String getId();
	
	public abstract void setId(String id);
	
	public abstract String getName();
	
	public abstract void setName(String name);
	
	public abstract List<String> getClasses();
	
	public abstract void setClasses(List<String> classes);
	
	public abstract Map<String, Serializable> getAttributes();
	
	public abstract void setAttributes(Map<String, Serializable> attributes);

}
