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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.lazcano.aframework.model.LogicRemove;

/**
 *
 * @author ilazcang
 */
@Entity
@TableGenerator(name="tab-modu", initialValue=0, allocationSize=1)
@Table(name = "FORMA_PAGO")
public class FormaPago implements LogicRemove{
  
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="tab-modu")
    @Column(name = "ID")
    private Integer id;
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
    public void setId(Integer id) {
        this.id = id;
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
