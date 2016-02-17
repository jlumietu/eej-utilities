/**
 * 
 */
package com.eej.utilities.model.forms;

import java.util.List;
import java.util.Map;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class FormBaseImpl extends FormElementAbstractImpl implements Form {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private String type;
	
	private String action;
	
	private String encType;
	
	private String method;
	
	private List<? extends FormField> fieldList;
	
	/**
	 * 
	 */
	public FormBaseImpl() {
		super();
		this.setTag(Form.HTML_ELEMENT_FORM_TAG);
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setType(String name) {
		this.type = name;
	}

	@Override
	public String getAction() {
		return this.action;
	}

	@Override
	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String getMethod() {
		return this.method;
	}

	@Override
	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String getEncType() {
		return this.encType;
	}

	@Override
	public void setEncType(String encType) {
		this.encType = encType;
	}

	@Override
	public List<? extends FormField> getFieldList() {
		return this.fieldList;
	}

	@Override
	public void setFieldList(List<? extends FormField> fieldList) {
		this.fieldList = fieldList;
	}

	
}
