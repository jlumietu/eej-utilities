/**
 * 
 */
package com.eej.utilities.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DataTableRowLink {

	String mappingEndPoint();
	
	boolean includeTimestamp() default false;
	
	boolean allowNewRowCreation() default false;
	
}
