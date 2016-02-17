/**
 * 
 */
package com.eej.utilities.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author doibalmi
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DataTableColumn {
	
	public enum DataType{
		
		STRING("string"),
		IMG("img"), 
		HTML("html"),
		DATE("date");
		
		private String value;
		
		private DataType(String value){
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}
		
		
	}

	String columnName();
	
	boolean searchable() default false;
	
	boolean columnSearch() default false;
	
	boolean sortable() default true;
	
	String defaultSort() default "";
	
	String width() default "";
	
	DataType dataType() default DataType.STRING;
	
	boolean displayColumn() default true;
	
	String defaultClass() default "";
	
	String defaultSearch() default "";
	
	String defaultContent() default "";
	
	String cellColor() default "";
	
	int colIndex();
	
	String fontColor() default "";
	
	String imgSrc() default "";
	
	String linkRef() default "";
	
	String linkText() default"";
	
	String linkTitle() default"";
	
	String dateConversionPattern() default "dd/MM/yyyy";
	
}
