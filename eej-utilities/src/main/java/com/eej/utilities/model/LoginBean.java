/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private String userName;
	
	private String password;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
