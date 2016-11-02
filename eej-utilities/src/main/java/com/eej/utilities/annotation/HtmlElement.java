/**
 * 
 */
package com.eej.utilities.annotation;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public @interface HtmlElement {
	
	public String id();
	
	public String name();
	
	public String[] classes() default "";

}
