/**
 * 
 */
package com.eej.utilities.annotation;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public @interface FormLabel {
	
	public String text() ;
	
	public String htmlClass() default "";

}
