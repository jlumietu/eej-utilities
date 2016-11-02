/**
 * 
 */
package com.eej.utilities.model;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public enum FormInputType {

	INPUT("input"),
	HIDDEN("hidden"),
	NUMBER("number"),
	DECIMAL("decimal"),
	DATE("date"),
	CHECKBOX("checkbox"),
	OPTION("option"),
	SELECT("select"),
	RADIO("radio");
	
	private String value;
	
	private FormInputType(String value){
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
