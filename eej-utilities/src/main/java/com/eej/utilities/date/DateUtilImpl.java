/**
 *
 */
package com.eej.utilities.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * Clase con utilidades para manejar fechas y horas, comparar etc.
 *
 * @author jlumietu
 *
 *
 */
public class DateUtilImpl implements DateUtil{

    public static final String DATE_SEPARATOR = "/";

    public static final String DATE_SEPARATOR_GUION = "-";

    private final Logger logger = Logger.getLogger(this.getClass());

    private DateFestivos dateFestivos; 
    
    private List<Integer> weekDayFestivos;

	private String defaultFormat;

    /**
     *
     * @param now
     * @param hora
     * @param listaHorasCorte
     * @return
     */
    private List<String> getDatesFor(Calendar now, int hora, List<Integer> listaHorasCorte){
        List<String> result = new ArrayList<String>();
        for(int horaCorte: listaHorasCorte){
            logger.debug("Hora: " + hora + "; HoraCorte: " + horaCorte);
            if(horaCorte > hora){
                result.add(this.getNextDayHabile(now, 1, true, "-"));
            }else{
                result.add(this.getNextDayHabile(now, 2, true, "-"));
            }
        }
        if(logger.isDebugEnabled()){
            for(String s: result){
                logger.debug("Dates:" + s);
            }
        }
        return result;
    }

    /**
     *
     * @param cal
     * @param amount
     * @param cloneCalendar
     * @return
     */
    private String getNextDayHabile(Calendar cal, int amount, boolean cloneCalendar, String separator){
        Calendar clone = (Calendar)cal.clone();
        return this.getNextDayHabile(clone, amount, separator);
    }

    /**
     * 
     * @param date
     * @param amount
     * @return
     */
    public Date getNextDayHabile(Date date, int amount){
    	Calendar c = new GregorianCalendar();
    	c.setTime(date);
    	c = this.getNextDayHabileCalendar(c, amount, DATE_SEPARATOR);
    	Date increased = c.getTime();
    	return increased;
    } 
    
    /**
     *
     * @param now
     * @return
     */
    public String getNextDayHabile(Calendar shipDate, int amount){
        return this.getNextDayHabile(shipDate, amount, DATE_SEPARATOR);
    }

    /**
     *
     * @param shipDate
     * @param amount
     * @param separator
     * @return
     */
    private String getNextDayHabile(Calendar shipDate, int amount, String separator){
        logger.debug("Entrada en getNextDayHabile");
        DateFormat dateFormat = new SimpleDateFormat("dd" + separator + "MM" + separator + "yyyy");
        shipDate = this.getNextDayHabileCalendar(shipDate, amount, separator);
        return dateFormat.format(shipDate.getTime());
    }
    
    /**
     * 
     * @param shipDate
     * @param amount
     * @param separator
     * @return
     */
    private Calendar getNextDayHabileCalendar(Calendar shipDate, int amount, String separator){
    	DateFormat dateFormat = new SimpleDateFormat("dd" + separator + "MM" + separator + "yyyy");
    	shipDate.add(Calendar.DATE, amount);
        logger.debug("getNextDayHabile. Antes del while: " + dateFormat.format(shipDate.getTime()));
        while((shipDate.get(Calendar.DAY_OF_WEEK)== Calendar.SATURDAY)
                || (shipDate.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY)
                || this.dateFestivos.getFechasFestivasNoPasadasString(separator).contains(dateFormat.format(shipDate.getTime()))){
            shipDate.add(Calendar.DATE, 1);
            logger.debug("Iteracion getNextDayHabile: fecha es: " + shipDate.get(Calendar.DAY_OF_WEEK));
            logger.debug("getNextDayHabile. iterando en el while del while: " + dateFormat.format(shipDate.getTime()));
        }
        logger.debug("FechaHabilNext (Ya fuera del while): " + dateFormat.format(shipDate.getTime()));
        return shipDate;
    }

    /**
     *
     * @param now
     * @param nowHour
     * @param horaCorte
     * @return
     */
    private String tratarNoContratableEnFinde(Calendar now, int nowHour, int horaCorte){
        if(horaCorte > nowHour){
            return this.avanzaHastaDiaNumeroEnLaSemana(now, Calendar.MONDAY, "-");
        }else{
            return this.avanzaHastaDiaNumeroEnLaSemana(now, Calendar.TUESDAY, "-");
        }
    }

    /**
     *
     * @param now
     * @return
     */
    private String avanzaHastaMartes(Calendar now){
    	//int numeroDiasASumarPorLunesFestivo = this.calcularDiferencialPorFestivos(now);
        //return this.avanzaHastaDiaNumeroEnLaSemana(now, Calendar.TUESDAY + numeroDiasASumarPorLunesFestivo);
    	
    	/*
    	 * Aunque parece raro, el avance hasta el martes (desde el viernes) se hace de esta forma por el 
    	 * orden en que se evalúan el nº de días a avanzar.
    	 * Las funciones getNextDayHabileXXXX([]) primero suman el número de días naturales recibidos
    	 * en el parámetro amount y luego comprueban si el día es festivo, sábado o domingo.
    	 * Sin embargo, en este caso, lo que debemos hacer es sumar un día natural y comprobar si es hábil
    	 * (ejemplo, 
    	 * viernes + 1 = sábado; 
    	 * sábado habil? No > sábado +1 = domingo;
    	 * domingo hábil? No > domingo +1 = lunes;
    	 * 	- lunes(festivo) hábil? No > lunes +1 = martes;
    	 *  - lunes(no festivo) hábil? Si = fin;
    	 *  Ahora, como teníamos que saltarnos un día habil, por eso hacemos el calendar + 1 cuando
    	 *  ya estamos en el primer día habil después de hacer el fecha original + 1
    	 *  )
    	 *  Por ese motivo el avance desde viernes, sábado o domingo hasta el martes se hace en dos pasos,
    	 *  de forma que se hace "dame el primer día habil posterior a hoy", y luego "ahora avanza hasta 
    	 *  el siguiente día hábil al primer resultado".    
    	 */
    	now = this.getNextDayHabileCalendar(now, 1, DATE_SEPARATOR);
    	return this.getNextDayHabile(now, 1);
    }
    
    /**
     * 
     * @param shipDate
     * @param numeroDiasASumar
     * @return
     */
    private String avanzaHastaMartes(Calendar shipDate, int numeroDiasASumar) {
		return this.avanzaHastaDiaNumeroEnLaSemana(shipDate, Calendar.TUESDAY + numeroDiasASumar);
	}

    /**
     *
     * @param now
     * @return
     */
    private String avanzaHastaMartes(Calendar now, String separator){
        return this.avanzaHastaDiaNumeroEnLaSemana(now, Calendar.TUESDAY, separator);
    }

    /**
     *
     * @param now
     * @param idDiaSemana
     * @return
     */
    private String avanzaHastaDiaNumeroEnLaSemana(Calendar now, int idDiaSemana){
        return this.avanzaHastaDiaNumeroEnLaSemana(now, idDiaSemana, "/");
    }

    /**
     *
     * @param now
     * @param idDiaSemana
     * @param separator
     * @return
     */
    private String avanzaHastaDiaNumeroEnLaSemana(Calendar now, int idDiaSemana, String separator){
        DateFormat dateFormat = new SimpleDateFormat("dd"+separator+"MM"+separator+"yyyy");
        this.avanzaHastaDiaDeLaSemana(now, idDiaSemana);
        return dateFormat.format(now.getTime());
    }

    /**
     *
     * @param cal
     * @param idDiaSemana
     */
    @Override
    public void avanzaHastaDiaDeLaSemana(Calendar cal, int idDiaSemana){
    	while(idDiaSemana > 7){
    		cal.add(Calendar.DATE, 7);
    		idDiaSemana = idDiaSemana - 7;
    	}
        while(cal.get(Calendar.DAY_OF_WEEK)!= idDiaSemana){
            cal.add(Calendar.DATE, 1);
        }
    }

    /**
     * Devuelve una representacion de la hora en formato 1700
     *
     * @param cal
     * @return
     */
    @Override
    public int getIntRepresentationHourAndMinute(Calendar cal){
        String auxHour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
        while(auxHour.length()<2){
            auxHour = "0".concat(auxHour);
        }
        String auxMin = String.valueOf(cal.get(Calendar.MINUTE));
        while(auxMin.length()<2){
            auxMin = "0".concat(auxMin);
        }
        logger.debug("getIntRepresentationHourAndMinute = " + auxHour.concat(auxMin));
        return Integer.parseInt(auxHour.concat(auxMin));
    }


    /**
     *
     * @param now
     * @param limit
     * @return
     */
    private String calcularDiferenciaTiempo(Calendar now, Calendar limit){
        long timeLeft = limit.getTimeInMillis() - now.getTimeInMillis();
        logger.debug("timeLeft: " + timeLeft);
        long seconds = timeLeft / 1000;
        logger.debug("timeLeft seconds: " + seconds);
        long minutes = seconds / 60;
        logger.debug("timeLeft minutes: " + minutes);
        long hours = minutes / 60;
        logger.debug("timeLeft hours: " + hours);
        StringBuffer sb = new StringBuffer();
        sb.append(hours);
        sb.append(":");
        String minutesLeft = String.valueOf(minutes - (hours * 60));
        while(minutesLeft.length() < 2){
            minutesLeft = "0".concat(minutesLeft);
        }
        sb.append(minutesLeft);
        logger.debug("timeLeft total: " + sb.toString());
        return sb.toString();
    }

    @Override
    public String getCurrentTimeStamp() {
        Date date= new Date();
        return Long.toString((new Timestamp(date.getTime())).getTime());
    }
    
    @Override
    public final String dameFechaDateToString(final Date fecha) {
    	return this.dameFechaDateToString(fecha, this.defaultFormat);
    }
    
    @Override
    public final String dameFechaDateToString(final Date fecha, final String formato) {

        String fechaFormateada = "";
        String formatoFinal = formato;
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat(formatoFinal);

        if (fecha != null) fechaFormateada = formatoDeFecha.format(fecha);
        return fechaFormateada;
    }

    /**
     * Método unitario de reformateo de fecha. Igual sería interesante sacarlo a un util...
     * @param date
     * @return
     */
    @Override
    public Date singleDateFormatFunction(Date date){
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        Date dateFormatoCorrecto;
        try {
            dateFormatoCorrecto = df.parse(df.format(date));
            logger.debug("synOrder.getDate_pickup "	+ dateFormatoCorrecto);
            return dateFormatoCorrecto;
        } catch (Exception e) {
            logger.error("Formateo incorrecto de la fecha del envio: "
                    + date);
            logger.error(
                    e.getClass().getName() + " " + e.getMessage(),
                    e);
            // Si falla el formateo, no quiero que casque. La fecha es un dato
            // menor y se puede cambiar por el panel de control.
            //throw new RuntimeException(e);
        }
        return date;
    }

    @Override
    public boolean isFestivo(Calendar calendar) {
        DateFormat dateFormat = new SimpleDateFormat("dd" + DATE_SEPARATOR_GUION + "MM" + DATE_SEPARATOR_GUION + "yyyy");
        boolean isFestivo = 
        		this.weekDayFestivos.contains(calendar.get(Calendar.DAY_OF_WEEK)) ||         		
        		this.dateFestivos.getFechasFestivasNoPasadasString(DATE_SEPARATOR_GUION).contains(dateFormat.format(calendar.getTime()));
        logger.debug("Es festivo? " + dateFormat.format(calendar.getTime()) + " -> " + isFestivo);
        return isFestivo;
        //return false;
    }
    
    /**
     * 
     * @param now
     * @return
     */
    private int calcularDiferencialPorFestivos(Calendar now) {
		int diferencial = 0;
		do{
			now.add(Calendar.DATE, 1);
			if(this.isFestivo(now)){
				diferencial++;
			}
		}while(this.isFestivo(now) || (now.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || (now.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)));
		logger.debug("diferencial calculado por festivos: dias a sumar:" + diferencial);
		return diferencial;
	}

    /**
     * Suma numDias a la fecha pasada.
     * @param fecha Date
     * @param numDias int
     * @return Date
     */
    @Override
    public final Date sumaDiasFecha (final Date fecha, final int numDias) {

        Date fechaFinal = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, numDias);

        fechaFinal = cal.getTime();

        return fechaFinal;
    }

    /**
     * Pone a cero las horas, minutos y segundos de un Date
     * @param date date
     * @return Date
     */
    @Override
    public final Date trim(final Date date){
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    @Override
    public final String formateaTimestampToString(Calendar cal) {

        String fecha = "";

        String dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString((cal.get(Calendar.MONTH) + 1));
        String anio = Integer.toString(cal.get(Calendar.YEAR));
        String hora = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minuto = Integer.toString(cal.get(Calendar.MINUTE));
        String segundo = Integer.toString(cal.get(Calendar.SECOND));

        if (dia.length() < 2) {
            dia = "0".concat(dia);
        }
        if (mes.length() < 2) {
            mes = "0".concat(mes);
        }
        if (hora.length() < 2) {
            hora = "0".concat(hora);
        }
        if (minuto.length() < 2) {
            minuto = "0".concat(minuto);
        }
        if (segundo.length() < 2) {
            segundo = "0".concat(segundo);
        }


        fecha = dia +"/"+ mes +"/"+ anio + " " + hora +":"+ minuto +":"+ segundo;


        return fecha;
    }
    
    public DateFestivos getDateFestivos() {
		return dateFestivos;
	}

	public void setDateFestivos(DateFestivos dateFestivos) {
		this.dateFestivos = dateFestivos;
	}

	public List<Integer> getWeekDayFestivos() {
		return weekDayFestivos;
	}

	public void setWeekDayFestivos(List<Integer> weekDayFestivos) {
		this.weekDayFestivos = weekDayFestivos;
	}

	public String getDefaultFormat() {
		return defaultFormat;
	}

	public void setDefaultFormat(String defaultFormat) {
		this.defaultFormat = defaultFormat;
	}	
	
}
