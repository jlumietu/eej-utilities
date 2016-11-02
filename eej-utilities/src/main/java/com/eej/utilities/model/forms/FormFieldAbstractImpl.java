/**
 * 
 */
package com.eej.utilities.model.forms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public abstract class FormFieldAbstractImpl extends FormElementAbstractImpl implements FormField {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	private Serializable value;
	private boolean required;
	private Label label;
	private String type;

	/* (non-Javadoc)
	 * @see com.ib.utilities.model.forms.FormField#setValue(java.io.Serializable)
	 */
	@Override
	public void setValue(Serializable value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.ib.utilities.model.forms.FormField#getValue()
	 */
	@Override
	public Serializable getValue() {
		return this.value;
	}

	/* (non-Javadoc)
	 * @see com.ib.utilities.model.forms.FormField#setRequired(boolean)
	 */
	@Override
	public void setRequired(boolean required) {
		this.required = required;
	}

	/* (non-Javadoc)
	 * @see com.ib.utilities.model.forms.FormField#isRequired()
	 */
	@Override
	public boolean isRequired() {
		return this.required;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.FormElement#getType()
	 */
	@Override
	public final String getType() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.FormElement#setType(java.lang.String)
	 */
	@Override
	public final void setType(String name) {
		this.type = name;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.FormField#getLabel()
	 */
	@Override
	public Label getLabel() {
		return this.label;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.forms.FormField#setLabel(com.eej.utilities.model.forms.Label)
	 */
	@Override
	public void setLabel(Label label) {
		this.label = label;
	}
	
	

}
