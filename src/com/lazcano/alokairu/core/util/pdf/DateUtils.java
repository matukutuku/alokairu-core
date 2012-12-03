/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.pdf;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ilazcang
 */
public class DateUtils {

    private DateUtils(){
        
    }
    
    /**
     * Función que obtiene el último día del més indicado como Date
     * @param data Date con el mes cuyo último día queremos obtener
     * @return  Date correspondiente al último días del mes
     */
    public static Date fechaUltimoDiaMes(Date data){
       Calendar azkena =Calendar.getInstance();
       azkena.setTime(data);
       azkena.set(Calendar.DAY_OF_MONTH, azkena.getActualMaximum(Calendar.DAY_OF_MONTH));
       return azkena.getTime();
    }
    
    /**
     * Función que devuelve el Date correspondiente al primer día del año
     * @param agno Año para el que queremos obtener el Date
     * @return Date del primer día del año indicado
     */
    public static Date primerDiaAgno(Integer agno){
        Calendar calendar= Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH,1);
        calendar.set(Calendar.YEAR, agno);
        return calendar.getTime();
    }
    
    /**
     * Función que devuelve el Date correspondiente al último día del año
     * @param agno Año para el que queremos obtener el Date
     * @return Date del último día del año indicado
     */
    public static Date ultimoDiaAgno(Integer agno){
        Calendar calendar= Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.MONTH,12);
        calendar.set(Calendar.YEAR, agno);
        return calendar.getTime();
    }

    /**
     * Función que Devuelve el Date correspondiente al primer día de este agno
     * @return Date del 1/1
     */
    public static Date primerDiaEsteAgno(){
        Calendar cal=Calendar.getInstance();
        return DateUtils.primerDiaAgno(cal.get(Calendar.YEAR));
    }
    
    /**
     * Función que Devuelve el Date correspondiente al último día de este agno
     * @return Date del 31/12
     */
    public static Date ultimoDiaEsteAgno(){
        Calendar cal=Calendar.getInstance();
        return DateUtils.ultimoDiaAgno(cal.get(Calendar.YEAR));
    }
}
