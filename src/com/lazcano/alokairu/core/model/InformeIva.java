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
public class InformeIva {
    
    private Integer trimestre;
    private InformeIvaMes mes[]= new InformeIvaMes[3];
    private Double calculoTotal;
    private List<Gasto> gastos;
    
    public InformeIva(Integer trimestre){
        this.trimestre=trimestre;
    }
    
    public void setMeses(InformeIvaMes[] meses){
        this.mes=meses;
        
    }
    
    public Double getCalculoTotal(){
        this.calculoTotal=mes[0].getCalculoIva()+mes[1].getCalculoIva()+mes[2].getCalculoIva();
        for(Gasto gasto:this.gastos){
            this.calculoTotal=this.calculoTotal-gasto.getIvaKuota();
        }
        return this.calculoTotal;
    }
    
    public Integer getTrimestre(){
        return this.trimestre;
    }
    
    public InformeIvaMes getMes(int mes){
        return this.mes[mes];
    }
    
    public void setGastos(List<Gasto> gastos){
        this.gastos=gastos;
    }
    
    public List<Gasto> getGastos(){
        return this.gastos;
    }
}
