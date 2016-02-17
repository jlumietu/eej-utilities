/**
 * 
 */
package com.eej.utilities.date;

import java.util.Date;
import java.util.List;

/**
 * @author jlumietu
 *
 */
public interface DateFestivos {
	
	public abstract List<Date> getFechasFestivasNoPasadasString(String dateSeparator);
	
	public abstract List<Date> getFechasFestivas(String dateSeparator);

}
