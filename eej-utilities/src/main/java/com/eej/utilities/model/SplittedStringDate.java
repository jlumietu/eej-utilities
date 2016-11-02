/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public class SplittedStringDate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private String day;
	
	private String month;
	
	private String year;
	
	/**
	 * 
	 */
	public SplittedStringDate() {
		super();
	}

	/**
	 * @param day
	 * @param month
	 * @param year
	 */
	public SplittedStringDate(String day, String month, String year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	

}
