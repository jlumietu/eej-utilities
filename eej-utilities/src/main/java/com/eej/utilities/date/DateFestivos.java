/**
 * 
 */
package com.eej.utilities.date;

import java.util.Date;
import java.util.List;

/**
 * @author DOIBALMI
 *
 */
public interface DateFestivos {
	
	public abstract List<Date> getFechasFestivasNoPasadasString(String dateSeparator);
	
	public abstract List<Date> getFechasFestivas(String dateSeparator);

}
