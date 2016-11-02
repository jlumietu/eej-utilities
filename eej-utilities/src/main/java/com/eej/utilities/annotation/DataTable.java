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
public @interface DataTable{
	
	String tableName();
	
	String pageName() default "";
	
	String nombreLista() default "resultados";
	
	String tagModelConfigName() default "";
	
	String dataSource() default "";
	
}
