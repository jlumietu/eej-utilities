/**
 * 
 */
package com.eej.utilities.annotation;

/**
 * @author jlumietu
 *
 */
public @interface FormLabel {
	
	public String text() ;
	
	public String htmlClass() default "";

}
