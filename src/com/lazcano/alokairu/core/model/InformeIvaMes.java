/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.model;

import java.util.List;

/**
 *
 * @author ilazcang
 */
public class InformeIvaMes {
    private String mes;
        private Integer agno;
        
        
        private List<Factura> ordainAgiriLista;
        private Double calculoIva;
        private Empresa enpresa;
        private Double totalImporteRecibos;
        private Double totalKuotaRecibos;
    
    public InformeIvaMes(String mes,Integer agno,  List<Factura> ordainAgiriLista,Empresa enpresa){
            this.mes=mes;
            this.agno=agno;
            
            this.ordainAgiriLista=ordainAgiriLista;
            
            this.totalImporteRecibos=0d;
            this.totalKuotaRecibos=0d;
            for(Factura agiri:ordainAgiriLista){
                this.totalImporteRecibos+=agiri.getRenta();
                this.totalKuotaRecibos+=agiri.getTotalIva();
            }
            
            
            this.calculoIva=this.totalKuotaRecibos;
            this.enpresa=enpresa;
        }

        /**
         * @return the mes
         */
        public String getMes() {
            return mes;
        }

        /**
         * @param mes the mes to set
         */
        public void setMes(String mes) {
            this.mes = mes;
        }

        /**
         * @return the agno
         */
        public Integer getAgno() {
            return agno;
        }

        

        

        

        /**
         * @return the ordainAgiria
         */
        public List<Factura> getOrdainAgiriLista() {
            return ordainAgiriLista;
        }

        /**
         * @return the calculoIva
         */
        public Double getCalculoIva() {
            return calculoIva;
        }
    
        public Empresa getEnpresa(){
            return this.enpresa;
        }

    /**
     * @return the totalImporteRecibos
     */
    public Double getTotalImporteRecibos() {
        return totalImporteRecibos;
    }

    /**
     * @return the totalKuotaRecibos
     */
    public Double getTotalKuotaRecibos() {
        return totalKuotaRecibos;
    }
}
