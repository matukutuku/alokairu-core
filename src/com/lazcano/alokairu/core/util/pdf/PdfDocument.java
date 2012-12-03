/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.pdf;

import java.io.FileOutputStream;

/**
 *  Interfaz que represenat un documento PDF a generar
 *  las clases que lo implementen deberán implementar el método print que a partir
 *  de los datos T generará el pdf en outputStream.
 * @author ilazcang
 */
public interface PdfDocument<T> {
    
    /**
     * Método que genera el pdf en outputstream con los datos
     * @param fos OutputStream en el que generar el pdf
     * @param data  Datos para generar el pdf
     */
    public  void print(FileOutputStream fos,T data);
}
