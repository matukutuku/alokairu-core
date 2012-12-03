/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;


/**
 *
 * @author ilazcang
 */
@Entity
@TableGenerator(name="tab-gastoa", initialValue=0, allocationSize=1)
@Table(name = "GASTO")
public class Gasto implements Serializable {
	
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="tab-gastoa")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IMPORTE")
    private Double importe;
    
    @Column(name = "IVA")
    private Integer iva;
 
    @Column(name = "DESCRIPCION",length=255)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name="ID_INMUEBLE")
    private Inmueble inmueble;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "FECHA")
    private Date fecha;
    
    @Column(name = "IVA_TRIMESTREA")
    private Integer trimestreIva;
    
    @Column(name = "IVA_URTEA")
    private Integer agnoIva;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Gasto)) {
            return false;
        }
        Gasto other = (Gasto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "alokairu.model.Gastua[ id=" + id + " ]";
    }

    /**
     * @return the eraikina
     */
    public Inmueble getInmueble() {
        return inmueble;
    }

    /**
     * @param eraikina the eraikina to set
     */
    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    /**
     * @return the inportea
     */
    public Double getInportea() {
        return importe;
    }

    /**
     * @param inportea the inportea to set
     */
    public void setInportea(Double inportea) {
        this.importe = inportea;
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
     * @return the deskribapena
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param deskribapena the deskribapena to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion= descripcion;
    }

    /**
     * @return the data
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param data the data to set
     */
    public void setFEcha(Date fecha) {
        this.fecha = fecha;
    }
 
    public Double getIvaKuota(){
        return (this.importe * this.iva.doubleValue())/100d;
    }

    /**
     * @return the trimestreIva
     */
    public Integer getTrimestreIva() {
        return trimestreIva;
    }

    /**
     * @param trimestreIva the trimestreIva to set
     */
    public void setTrimestreIva(Integer trimestreIva) {
        this.trimestreIva = trimestreIva;
    }

    /**
     * @return the agno
     */
    public Integer getAgnoIva() {
        return agnoIva;
    }

    /**
     * @param agno the agno to set
     */
    public void setAgnoIva(Integer agno) {
        this.agnoIva = agno;
    }

    public Integer getPrimaryKey() {
        return this.id;
    }
    
}
