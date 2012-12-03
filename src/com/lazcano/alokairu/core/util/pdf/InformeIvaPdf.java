/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.pdf;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.lazcano.alokairu.core.model.Gasto;
import com.lazcano.alokairu.core.model.InformeIva;
import com.lazcano.alokairu.core.model.InformeIvaMes;
import com.lazcano.alokairu.core.model.Factura;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ilazcang
 */
public class InformeIvaPdf implements PdfDocument<InformeIva>{
 
    private String lineaRecibo(Factura agiri){
        StringBuffer linea= new StringBuffer("");
        linea.append("Inmueble :");
        linea.append(TextUtils.longitudFija(agiri.getNombreInmueble(), 50));
        linea.append("Renta :");
        Double renta=0d;
        if(agiri.getRenta()!=null){
            renta=agiri.getRenta();
        }
        linea.append(TextUtils.longitudFija(TextUtils.aEuros(renta), 10));
        linea.append("Cuota Iva :");
        Double cuotaIva=0d;
        if(agiri.getTotalIva()!=null){
            cuotaIva=agiri.getTotalIva();
        }
        linea.append(TextUtils.longitudFija(TextUtils.aEuros(cuotaIva), 10));
        return linea.toString();
    }
    
    private String lineaTotalRecibos(InformeIvaMes mes){
        StringBuffer result= new StringBuffer();
        result.append("Total importe Recibos :");
        result.append(TextUtils.longitudFija(TextUtils.aEuros(mes.getTotalImporteRecibos()), 10));
        result.append("Total Cuota Iva Recibos :");
        result.append(TextUtils.longitudFija(TextUtils.aEuros(mes.getTotalKuotaRecibos()), 10));
        return result.toString();
    }
    
    
    private String lineaGasto(Gasto gasto){
        StringBuffer linea= new StringBuffer("");
        linea.append("Inmueble :");
        linea.append(TextUtils.longitudFija(gasto.getInmueble().getNombre(), 40));
        linea.append("Importe :");
        Double importe=0d;
        if(gasto.getInportea()!=null){
            importe=gasto.getInportea();
        }
        linea.append(TextUtils.longitudFija(TextUtils.aEuros(importe), 9));
        
        linea.append("Porcentaje Iva :");
        Integer iva=0;
        if(gasto.getIva()!=null){
            iva=gasto.getIva();
        }
        
        linea.append(TextUtils.longitudFija(TextUtils.rellenaConCeros(iva+"",2), 3));
        
        linea.append("Cuota Iva :");
        Double cuotaIva=0d;
        if(gasto.getIvaKuota()!=null){
            cuotaIva=gasto.getIvaKuota();
        }
        linea.append(TextUtils.longitudFija(TextUtils.aEuros(cuotaIva), 9));
        return linea.toString();
    }
    
    private String lineaTotalGastos(Double importe,Double cuota){
        StringBuffer result= new StringBuffer();
        result.append("Total importe Gastos :");
        result.append(TextUtils.longitudFija(TextUtils.aEuros(importe), 10));
        result.append("Total Cuota Iva Gastos :");
        result.append(TextUtils.longitudFija(TextUtils.aEuros(cuota), 10));
        return result.toString();
    }
    
    
    public void print(FileOutputStream fos,InformeIva data){
        Document document = new Document();
        try{
            PdfWriter writer = PdfWriter.getInstance(document, fos);
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            BaseFont bfCampos = BaseFont.createFont("Courier", "Cp1252", false);
            BaseFont bfCamposNegrita = BaseFont.createFont("Courier-Bold", "Cp1252", false);
            
            cb.setFontAndSize(bfCamposNegrita, 9.0F);
            cb.beginText();
            cb.showTextAligned(0, "Trimestre :"+TextUtils.getTrimestre(data.getTrimestre()), 50.0F, 760.0F, 0.0F);
            cb.showTextAligned(0, "Total Iva :"+TextUtils.aEuros(data.getCalculoTotal()), 195.0F, 760.0F, 0.0F);
            cb.endText();
            
            cb.setFontAndSize(bfCampos, 8.0F);
            
            Float l=0F;
            for(int i=0;i<3;i++){
                InformeIvaMes mes=data.getMes(i);
                cb.beginText();
                cb.showTextAligned(0, "Mes :"+mes.getMes(), 50.0F, 740.0F-l, 0.0F);
                cb.showTextAligned(0, "Cuota Iva del mes :"+TextUtils.aEuros(mes.getCalculoIva()), 50.0F, 730.0F-l, 0.0F);
                cb.showTextAligned(0, "Recibos :", 50.0F, 720.0F-l, 0.0F);
                for(Factura agiri:mes.getOrdainAgiriLista()){
                    cb.showTextAligned(0, this.lineaRecibo(agiri), 90.0F, 710.0F-l, 0.0F);
                    l+=10;
                }
                cb.showTextAligned(0, this.lineaTotalRecibos(mes), 90.0F, 700.0F-l, 0.0F);                
               
                
                
                cb.endText();
                l+=90F;
            }
            cb.beginText();
             cb.showTextAligned(0, "Gastos :", 50.0F, 690.0F-l, 0.0F);
            Double importe=0d;
            Double cuota=0d;
             for(Gasto gastua:data.getGastos()){
                 importe+=gastua.getInportea();
                 cuota+=gastua.getIvaKuota();
                 cb.showTextAligned(0,this.lineaGasto(gastua) , 90.0F, 680.0F-l, 0.0F);
                    l+=10F;
                }
            cb.showTextAligned(0, this.lineaTotalGastos(importe,cuota), 90.0F, 670.0F-l, 0.0F);
            cb.endText();
            
            
            document.close();
          }catch (DocumentException de){
              
          }catch (IOException ioe) {
              
           }   
    }
}
