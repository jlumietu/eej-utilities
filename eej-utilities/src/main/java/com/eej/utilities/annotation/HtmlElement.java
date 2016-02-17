/**
 * 
 */
package com.eej.utilities.annotation;

/**
 * @author jlumietu
 *
 */
public @interface HtmlElement {
	
	public String id();
	
	public String name();
	
	public String[] classes() default "";

}
