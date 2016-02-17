/**
 * 
 */
package com.eej.utilities.annotation;

/**
 * @author jlumietu
 *
 */
public @interface Form {
	
	public String formName() default "";
	
	public String formId() default"" ; 
	
	public String action();
	
	public enum FormType{
		
		WWW_URL_ENCODED("application/x-www-form-urlencoded"),
		MULTIPART("multipart/form-data");
		
		private String type;
		
		private FormType(String type){
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
	
	public enum HttpMethod{
		
		POST("POST"),
		GET("GET"),
		PUT("PUT"),
		DELETE("DELETE");
		
		private String method;
		
		private HttpMethod(String method){
			this.method = method;
		}

		/**
		 * @return the method
		 */
		public String getMethod() {
			return method;
		}

		/**
		 * @param method the method to set
		 */
		public void setMethod(String method) {
			this.method = method;
		}
		
	}
}
