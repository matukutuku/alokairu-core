/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.model;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.lazcano.aframework.model.LogicRemove;

/**
 *
 * @author ilazcang
 */
@Entity
@TableGenerator(name="tab-bezero", initialValue=0, allocationSize=1)
@Table(name = "CLIENTE")
public class Cliente implements LogicRemove {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="tab-bezero")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    @Basic(optional = false)
    private String nombre;

    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "MUNICIPIO")
    private String municipio;
    @Column(name = "PROVINCIA")
    private String provincia;
    @Column(name = "DNI",length=9)
    @Basic(optional = false)
    private String dni;
    @Column(name = "CODIGO_POSTAL",length=5)
    private String codigoPostal;
    
    @Column(name = "BAJA")
    private Boolean baja;
    
    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
    private Empresa enpresa;
    
    /**
     * @return the gakoa
     */
    
    public Integer getID() {
        return id;
    }

    /**
     * @param gakoa the gakoa to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
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

    /**
     * @return the helbidea
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param helbidea the helbidea to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the herria
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param herria the herria to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the lurraldea
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param lurraldea the lurraldea to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the nan
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param nan the nan to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the postaKodea
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param postaKodea the postaKodea to set
     */
    public void setPostaKodea(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    
    public void setBaja(Boolean balioa) {
        this.baja=balioa;
    }


    public Boolean isBaja() {
        return this.baja;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the enpresa
     */
    public Empresa getEnpresa() {
        return enpresa;
    }

    /**
     * @param enpresa the enpresa to set
     */
    public void setEnpresa(Empresa enpresa) {
        this.enpresa = enpresa;
    }



}
