/**
 * 
 */
package com.eej.utilities.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public @interface DataTableRowOwnerId {

}
