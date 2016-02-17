/**
 *
 */
package com.eej.utilities.date;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * @author DOIBALMI
 *
 */
public interface DateUtil {

    int getIntRepresentationHourAndMinute(Calendar cal);

    void avanzaHastaDiaDeLaSemana(Calendar cal, int idDiaSemana);

    String getCurrentTimeStamp();

    String dameFechaDateToString (Date fecha);
    
    String dameFechaDateToString (Date fecha, String formato);

    Date singleDateFormatFunction(Date date);

    boolean isFestivo(Calendar calendar);


    Date sumaDiasFecha (Date fecha, int numDias);

    /**
     * Pone a cero las horas, minutos y segundos de un Date
     * @param date date
     * @return Date
     */
    Date trim(final Date date);

    String formateaTimestampToString(Calendar cal);
    
    Date getNextDayHabile(Date date, int amount);
    
    String getNextDayHabile(Calendar shipDate, int amount);
    
}
