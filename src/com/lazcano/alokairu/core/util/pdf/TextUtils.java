/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.pdf;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  Clase que aporta métodos para trabajar con cadenas de texto y números
 * @author ilazcang
 */
public class TextUtils {
    
    private TextUtils(){
        
    }
    
    /**
     * Devuelve la representación en texto de un entero menor o igual que quince
     * @param numero El número a convertir
     * @return El texto que lo representa, null si el número es mayor que quince.
     */
    private static String unidadATexto(int numero){
        Map<Integer,String> mapa = new HashMap<Integer,String>();
        mapa.put(0,"CERO");
        mapa.put(1,"UNO");
        mapa.put(2,"DOS");
        mapa.put(3,"TRES");
        mapa.put(4,"CUATRO");
        mapa.put(5,"CINCO");
        mapa.put(6,"SEIS");
        mapa.put(7,"SIETE");
        mapa.put(8,"OCHO");
        mapa.put(9,"NUEVE");
        mapa.put(10,"DIEZ");
        mapa.put(11,"ONCE");
        mapa.put(12,"DOCE");
        mapa.put(13,"TRECE");
        mapa.put(14,"CATORCE");
        mapa.put(15,"QUINCE");
        return mapa.get(numero);
    }
    
    /**
     * Método que devuelve el texto que representa las decenas de un número
     * @param numero El número cuya representación queremos obtener
     * @return El texto que representa sus decenas
     */
    private static String decenaATexto(int numero){
        Map<Integer,String> mapa = new HashMap<Integer,String>();
        mapa.put(1,"DIEZ");
        mapa.put(2,"VEINTI");
        mapa.put(3,"TREINTA");
        mapa.put(4,"CUARENTA");
        mapa.put(5,"CINCUENTA");
        mapa.put(6,"SESENTA");
        mapa.put(7,"SETENTA");
        mapa.put(8,"OCHENTA");
        mapa.put(9,"NOVENTA");
        return mapa.get(numero);
    }
    
    /**
     * Método que devuelve la representación en texto de las centenas de un 
     * número.
     * @param numero El número cuya representación queremos obtener
     * @return La representación de las centenas en texto
     */
    private static String centenasATexto(int numero){
        Map<Integer,String> mapa = new HashMap<Integer,String>();
        mapa.put(1,"CIENTO");
        mapa.put(2,"DOSCIENTOS");
        mapa.put(3,"TRESCIENTOS");
        mapa.put(4,"CUATROCIENTOS");
        mapa.put(5,"QUIENIENTOS");
        mapa.put(6,"SEISCIENTOS");
        mapa.put(7,"SETECIENTOS");
        mapa.put(8,"OCHOCIENTOS");
        mapa.put(9,"NOVECIENTOS");
        return mapa.get(numero);
    }
    
    /**
     * Método que rellena con ceros la parte izquierda de un String hasta alcanzar
     * la longitud indicada.
     * @param texto El texto a rellenar
     * @param longitud La longitud deseada
     * @return el texto con tantos ceros como sean necesarios a su izquierda para
     * llegar a la longitud indicada
     */
    public static String rellenaConCeros(String texto,int longitud){
        
        if(texto.length()<longitud){
            return TextUtils.rellenaConCeros("0"+texto, longitud);
        }else{
            return texto;
        }
            
    }
    
    /**
     * Método que formatea un Double al formado de Euros en un String
     * @param valor EL valor a formatear
     * @return el valor formateado
     */
    public static String aEuros(Double valor){
        DecimalFormat doubleFormat = new DecimalFormat("##.00"); 
        return doubleFormat.format(valor);
    }
    
    /**
     * Método que devuelve una fecha en un  String en formato de fecha larga
     * p.e 1 de Octubre de 2012
     * @param fecha La fecha cuya representación queremos obtener.
     * @return  La representación
     */
    public static String aFechaLarga(Date fecha){
        SimpleDateFormat df= new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        return df.format(fecha);
    }
    
    /**
     * Método que devuelve el nombre del mes de una fecha
     * @param fecha Fecha cuyo mes queremos obtener
     * @return El mes en un String
     */
    public static String nombreMes(Date fecha){
        SimpleDateFormat df= new SimpleDateFormat("MMMM");
        return df.format(fecha);
    }
    
    /**
     * Método que obtiene la representación en texto de un Double
     * @param numero El número cuya representación queremos obtener
     * @return Su representación
     */
    public static String numeroATexto(Double numero){
        StringBuilder cadena = new StringBuilder();
        if(numero<16.0d){
            if(numero!=0.0d){
                cadena.append(unidadATexto(numero.intValue()));
            }
            double decimales=numero-Math.floor(numero);
                    
            if(decimales>0.0d){
                cadena.append(" EUROS COMA ").append(TextUtils.numeroATexto(new Double(Math.round(decimales*100.0d)))).append(" CENTIMOS");
            }
        }else if(numero<100.0d){
            cadena.append(decenaATexto(numero.intValue()/10)).append(" Y ").append(TextUtils.numeroATexto(numero % 10.0d));
        }else if(numero<1000.0d){
            cadena.append(centenasATexto(numero.intValue()/100)).append(" ").append(TextUtils.numeroATexto(numero % 100.0d));
        }else{
            cadena.append(TextUtils.numeroATexto(numero / 1000.0d)).append(" MIL ").append(cadena.append(TextUtils.numeroATexto(numero % 1000.0d)));
        }
        
        return cadena.toString();
    }
    
    /**
     * Método que dado un entero que representa un trimestre devuelve su 
     * representación como texto
     * @param trimestre El trimestre cuya representación queremos obtener
     * @return Su representación como texto
     */
    public static String getTrimestre(Integer trimestre){
        String result=null;
        switch(trimestre){
            case 0:
                result="PRIMERO";
                break;
            case 1:
                result="SEGUNDO";
                break;
            case 2:
                result="TERCERO";
                break;
                
            case 3:
                result="CUARTO";
                break;
        }
        return result;
    }
    
    /**
     * Método que devuelve una cadena rellenándola con blancos a la izquierda
     * hasta obtener la longitud deseada.
     * @param cadena cadena que contiene el texto a rellenar
     * @param longitud Longitud que deseamos que alcance
     * @return El texto con blancos a la izquierda hasta alcanzar la longitud
     * deseada
     */
    public static String longitudFija(String cadena, int longitud){
        StringBuffer result= new StringBuffer(cadena);
        if(result.length()<longitud){
            while(result.length()!=longitud){
                result.append(" ");
            }
        }else if(result.length()>longitud){
            result.delete(longitud-1,result.length());
        }
        
        return result.toString();
    }
}
