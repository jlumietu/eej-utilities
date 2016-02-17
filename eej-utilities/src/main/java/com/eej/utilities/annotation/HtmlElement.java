/**
 * 
 */
package com.eej.utilities.annotation;

/**
 * @author DOIBALMI
 *
 */
public @interface HtmlElement {
	
	public String id();
	
	public String name();
	
	public String[] classes() default "";

}
