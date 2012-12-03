/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.lazcano.aframework.model.LogicRemove;

/**
 *
 * @author ilazcang
 */
@Entity
@TableGenerator(name="tab-eraikin", initialValue=0, allocationSize=1)
@Table(name = "INMUEBLE")
public class Inmueble implements LogicRemove{
 
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="tab-eraikin")
    @Column(name = "ID")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="ID_EMPRESA")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name="ID_CLIENTE")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="ID_FORMA_PAGO")
    private FormaPago formaPago;
     @Column(name = "RENTA")
     private Double renta;
     @Column(name = "IVA")
     private Integer iva;
     @Column(name = "RETENCION")
     private Integer retencion;
     @Column(name = "NOMBRE")
     private String nombre;
     @Column(name = "BAJA")
     private Boolean baja;     
     
    /**
     * @return the gakoa
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param gakoa the gakoa to set
     */
    public void setID(Integer id) {
        this.id = id;
    }

    /**
     * @return the enpresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param enpresa the enpresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the bezero
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param bezero the bezero to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the ordainketa
     */
    public FormaPago getFormaPago() {
        return formaPago;
    }

    /**
     * @param ordainketa the ordainketa to set
     */
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * @return the errenta
     */
    public Double getRenta() {
        return renta;
    }

    /**
     * @param errenta the errenta to set
     */
    public void setRenta(Double renta) {
        this.renta = renta;
    }

    /**
     * @return the iva
     */
    public Integer getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(Integer iva) {
        this.iva = iva;
    }

    /**
     * @return the atxikipena
     */
    public Integer getRetencion() {
        return retencion;
    }

    /**
     * @param atxikipena the atxikipena to set
     */
    public void setRetencion(Integer retencion) {
        this.retencion = retencion;
    }

    /**
     * @return the izena
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param izena the izena to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public void setBaja(Boolean balioa) {
        this.baja=balioa;
    }

    
    public Boolean isBaja() {
        return this.baja;
    }


    
}
