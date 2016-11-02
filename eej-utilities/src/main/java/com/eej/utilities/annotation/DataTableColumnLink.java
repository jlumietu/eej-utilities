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
@Target({ElementType.FIELD})
public @interface DataTableColumnLink {
	
	String mappingEndPoint();
	
	boolean includeTimestamp() default false;
	
	String paramName();
	
	String paramProperty();

}
