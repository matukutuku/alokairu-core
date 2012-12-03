/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.pdf;


import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Clase que ejecuta un PdfDocument vuelva la salida a un fichero y lo muestra
 * en la aplicación definida en S.O. para visualizar los pdfs
 * @author ilazcang
 */
public class PdfPrinter {

    //Fichero por defecto dónde generar el pdf si no se indica ninguno
    private static final String DEFAULT_FILENAME="1234.pdf";
    
    //Definimos un constructor privado para que no se puede instanciar la clase
    private PdfPrinter(){
        
    }
  
    /**
     * Método que genera el pdf en el fichero por defecto y lo visualiza
     * @param document Documento a generar.
     * @param data Datos para generar el documento
     */
    public static void print(PdfDocument document,Object data){
        print(document,data,DEFAULT_FILENAME,true);
    }
    
    /**
     * Método que genera el pdf en el fichero indicado y lo visualiza si se indica
     * @param document Documento a generar.
     * @param data Datos para generar el documento
     * @param pFileName Nomre del fichero a generar
     * @param show indica si se debe mostrar el pdf una vez generado
     */
    public static void print(PdfDocument document,Object data,String pFileName,boolean show){
        try{
            String fileName=System.getProperty("java.io.tmpdir")+pFileName;
            
            document.print(new FileOutputStream(fileName), data);
            if (Desktop.isDesktopSupported() && show) {
            try {
                File myFile = new File(fileName);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
}
        }catch(Exception e){
            e.printStackTrace();    
        }
    }
}
