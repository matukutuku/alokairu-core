/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.pdf;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.lazcano.alokairu.core.model.Factura;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;


/**
 *
 * @author ilazcang
 */
public class Reciboa implements PdfDocument<Factura>{


    public void print(FileOutputStream fos,Factura agiria){
        Document document = new Document();
        try{
            PdfWriter writer = PdfWriter.getInstance(document, fos);
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            BaseFont bfCampos = BaseFont.createFont("Courier", "Cp1252", false);
            BaseFont bfCamposNegrita = BaseFont.createFont("Courier-Bold", "Cp1252", false);
            
            
            cb.setFontAndSize(bfCamposNegrita, 10.0F);
            //this.fillForm(cb,factura);
            cb.setLineWidth(0.5F);
            
            BaseFont bf = BaseFont.createFont("Helvetica-Bold", "Cp1252", false);
            //Rectangulo Numero recibo
            cb.rectangle(41.0F, 735.0F, 120.0F, 40.0F);
            //Rectangulo Expedicion
            cb.rectangle(161.0F, 735.0F, 300.0F, 40.0F);
            //Rectangulo Importe
            cb.rectangle(461.0F, 735.0F, 100.0F, 40.0F);
            //Rectangulo Fecha Expedicion
            cb.rectangle(41.0F, 695.0F, 170.0F, 40.0F);
            //Rectangulo Mes Expedicion
            cb.rectangle(211.0F, 695.0F, 200.0F, 40.0F);
            //Rectangulo Vencimeinto
            cb.rectangle(411.0F, 695.0F, 150.0F, 40.0F);
            //Rectangulo Forma de pago
            cb.rectangle(41.0F, 567.0F, 520.0F, 10.0F);
            //Rectangulo arrendatario
            cb.rectangle(41.0F, 495.0F, 200.0F, 43.0F);
            //Rectangulo arrendador
            cb.rectangle(330.0F, 495.0F, 200.0F, 43.0F);
            
            cb.stroke();
            
            cb.beginText();
            cb.showTextAligned(0, "RECIBO NUMERO", 50.0F, 760.0F, 0.0F);
            cb.showTextAligned(0, "LOCALIDAD DE EXPEDICION", 195.0F, 760.0F, 0.0F);
            cb.showTextAligned(0, "IMPORTE", 490.0F, 760.0F, 0.0F);
            
            cb.showTextAligned(0, "FECHA EXPEDICION", 50.0F, 725.0F, 0.0F);
            cb.showTextAligned(0, "RECIBO CORRESPONDIENTE", 235.0F, 725.0F, 0.0F);
            cb.showTextAligned(0, "VENCIMIENTO", 440.0F, 725.0F, 0.0F);
            
            cb.endText();
            
            cb.setFontAndSize(bfCampos, 8.0F);
            cb.beginText();
            cb.setColorStroke(BaseColor.BLACK);
            cb.showTextAligned(0, TextUtils.rellenaConCeros(agiria.getId()+"",4)+"", 68.0F, 750.0F, 0.0F);
            cb.showTextAligned(0, agiria.getMunicipioEmpresa(), 263.0F, 750.0F, 0.0F);
            cb.showTextAligned(0, TextUtils.aEuros(agiria.getTotal()), 483.0F, 750.0F, 0.0F);
            
            cb.showTextAligned(0, TextUtils.aFechaLarga(agiria.getFecha()), 58.0F, 710.0F, 0.0F);
            cb.showTextAligned(0, TextUtils.nombreMes(agiria.getFecha()), 263.0F, 710.0F, 0.0F);
            cb.showTextAligned(0, TextUtils.aFechaLarga(DateUtils.fechaUltimoDiaMes(agiria.getFecha())), 433.0F, 710.0F, 0.0F);
            cb.showTextAligned(0, "Conceptos Arrendamiento", 41.0F, 680.0F, 0.0F);
            cb.showTextAligned(0, "Alquiler "+TextUtils.nombreMes(agiria.getFecha()), 41.0F, 670.0F, 0.0F);
            cb.showTextAligned(0, TextUtils.aEuros(agiria.getTotal()), 290.0F, 670.0F, 0.0F);
            cb.showTextAligned(0, "Base Imponible", 340.0F, 670.0F, 0.0F);
            cb.showTextAligned(0, TextUtils.aEuros(agiria.getRenta()), 460.0F, 670.0F, 0.0F);
            cb.showTextAligned(0, "I.V.A.", 340.0F, 660.0F, 0.0F);
            cb.showTextAligned(0, TextUtils.aEuros(agiria.getTotalIva()), 460.0F, 660.0F, 0.0F);
            cb.showTextAligned(0, "Retención", 340.0F, 650.0F, 0.0F);
            cb.showTextAligned(0, TextUtils.aEuros(agiria.getTotalRetencion()), 460.0F, 650.0F, 0.0F);
            cb.rectangle(400.0F, 645.0F, 100.0F, 0.25F);
            cb.stroke();
            cb.showTextAligned(0, "Total", 340.0F, 640.0F, 0.0F);
            cb.showTextAligned(0, TextUtils.aEuros(agiria.getTotal()), 460.0F, 635.0F, 0.0F);
            cb.showTextAligned(0, "Inmueble :"+agiria.getNombreInmueble(), 41.0F, 620.0F, 0.0F);
            cb.showTextAligned(0, "Recibido de quien abajo se indica, la cantidad de: ", 41.0F, 600.0F, 0.0F);
            cb.showTextAligned(0, TextUtils.numeroATexto(agiria.getTotal()), 41.0F, 590.0F, 0.0F);
            cb.showTextAligned(0, "FORMA DE PAGO: "+agiria.getNombreFormaPago(), 41.0F, 570.0F, 0.0F);
            cb.showTextAligned(0, "Datos del arrendatario", 41.0F, 540.0F, 0.0F);
            cb.showTextAligned(0, "Datos del arrendador", 330.0F, 540.0F, 0.0F);
            
            cb.showTextAligned(0, agiria.getNombreCliente(), 41.0F, 530.0F, 0.0F);
            cb.showTextAligned(0, agiria.getDireccionCliente(), 41.0F, 520.0F, 0.0F);
            cb.showTextAligned(0, agiria.getCodigoPostalCliente()+" "+agiria.getMunicipioCliente()+" ("+agiria.getProvinciaCliente()+")", 41.0F, 510.0F, 0.0F);
            cb.showTextAligned(0, agiria.getDniCliente(), 41.0F, 500.0F, 0.0F);
            
            cb.showTextAligned(0, agiria.getNombreEmpresa(), 330.0F, 530.0F, 0.0F);
            cb.showTextAligned(0, agiria.getDireccionEmpresa(), 330.0F, 520.0F, 0.0F);
            cb.showTextAligned(0, agiria.getCodigoPostalEmpresa()+" "+agiria.getMunicipioEmpresa()+" ("+agiria.getProvinciaEmpresa()+")", 330.0F, 510.0F, 0.0F);
            cb.showTextAligned(0, agiria.getDniEmpresa(), 330.0F, 500.0F, 0.0F);
            cb.endText();
            
            document.close();
          }catch (DocumentException de){
              
          }catch (IOException ioe) {
              
           }
 }

    
  
}

