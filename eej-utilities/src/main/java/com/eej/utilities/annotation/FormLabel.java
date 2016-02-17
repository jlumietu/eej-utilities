/**
 * 
 */
package com.eej.utilities.annotation;

/**
 * @author DOIBALMI
 *
 */
public @interface FormLabel {
	
	public String text() ;
	
	public String htmlClass() default "";

}
