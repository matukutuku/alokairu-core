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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.lazcano.aframework.model.LogicRemove;

/**
 *
 * @author ilazcang
 */
@Entity
@TableGenerator(name="tab-enpresa", initialValue=0, allocationSize=1)
@Table(name = "EMPRESA")
public class Empresa implements LogicRemove{
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="tab-enpresa")
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
    private String dni;
    @Column(name = "CODIGO_POSTAL",length=5)
    private String codigoPostal;
    @Column(name = "BAJA")
    private Boolean baja;
    
    @Column(name = "EMAIL",length=200)
    private String email;
    
    @Column(name = "EMAIL_USER",length=200)
    private String emailUser;
    
    @Column(name = "EMAIL_PASSWD",length=200)
    private String emailPasswd;
    
    @Column(name = "EMAIL_SERVER",length=200)
    private String emailServer;
    
    @Column(name = "LOGIN",length=9)
    private String login;
    
    @Column(name = "PASSWD",length=20)
    private String passwd;
    
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
    public void setLurraldea(String provincia) {
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
    public void setCodigoPostal(String codigoPostal) {
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
     * @return the emailUser
     */
    public String getEmailUser() {
        return emailUser;
    }

    /**
     * @param emailUser the emailUser to set
     */
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    /**
     * @return the emailPasswd
     */
    public String getEmailPasswd() {
        return emailPasswd;
    }

    /**
     * @param emailPasswd the emailPasswd to set
     */
    public void setEmailPasswd(String emailPasswd) {
        this.emailPasswd = emailPasswd;
    }

    /**
     * @return the emailServer
     */
    public String getEmailServer() {
        return emailServer;
    }

    /**
     * @param emailServer the emailServer to set
     */
    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


}
