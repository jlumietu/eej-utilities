/**
 * 
 */
package com.eej.utilities.annotation;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public @interface FormField {
	
	public String value() default "";
	
	public String clazz() default "java.lang.String";
	
	public enum fieldType{
		
		TEXT("TEXT"),
		PASSWORD("PASSWORD");
		
		private String type;
		
		private fieldType(String type){
			this.type = type;
		}

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}		
		
	}

}
