/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;


/**
 *
 * @author ilazcang
 */

@Entity
@TableGenerator(name="tab-agiri", initialValue=0, allocationSize=1)
@Table(name = "AGIRIA")
public class Factura {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="tab-agiri")
    @Column(name = "ID")
    private Integer id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "FECHA_FACTURA")
    private Date fecha;
    
    @Column(name = "RENTA")
    private Double renta;
    
    @Column(name = "IVA")
    private Integer iva;
    
    @Column(name = "NUMERO")
    private Integer numero;
    
    @Column(name = "RETENCION")
    private Integer retencion;
    
    @Column(name = "NOMBRE_INMUEBLE")
    private String nombreInmueble;
    
    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;
    
    @Column(name = "DIRECCION_EMPRESA")
    private String direccionEmpresa;
    
    @Column(name = "MUNICIPIO_EMPRESA")
    private String municipioEmpresa;
    
    @Column(name = "CODIGO_POSTAL_EMPRESA",length=5)
    private String codigoPostalEmpresa;
    
    @Column(name = "DNI_EMPRESA",length=9)
    private String dniEmpresa;
    
    @Column(name = "PROVINCIA_EMPRESA")
    private String provinciaEmpresa;
    
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    
    @Column(name = "DIRECCION_CLIENTE")
    private String direccionCliente;
    
    @Column(name = "MUNICIPIO_CLIENTE")
    private String municipioCliente;
    
    @Column(name = "CODIGO_POSTAL_CLIENTE",length=5)
    private String codigoPostalCliente;
    
    @Column(name = "PROVINCIA_CLIENTE")
    private String provinciaCliente;
    
    @Column(name = "DNI_CLIENTE",length=9)
    private String dniCliente;
    
    @Column(name = "NOMBRE_FORMA_PAGO",length=100)
    private String nombreFormaPago;
    
    @ManyToOne
    private Inmueble inmueble;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Empresa empresa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getRenta() {
		return renta;
	}

	public void setRenta(Double renta) {
		this.renta = renta;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getRetencion() {
		return retencion;
	}

	public void setRetencion(Integer retencion) {
		this.retencion = retencion;
	}

	public String getNombreInmueble() {
		return nombreInmueble;
	}

	public void setNombreInmueble(String nombreInmueble) {
		this.nombreInmueble = nombreInmueble;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getMunicipioEmpresa() {
		return municipioEmpresa;
	}

	public void setMunicipioEmpresa(String municipioEmpresa) {
		this.municipioEmpresa = municipioEmpresa;
	}

	public String getCodigoPostalEmpresa() {
		return codigoPostalEmpresa;
	}

	public void setCodigoPostalEmpresa(String codigoPostalEmpresa) {
		this.codigoPostalEmpresa = codigoPostalEmpresa;
	}

	public String getDniEmpresa() {
		return dniEmpresa;
	}

	public void setDniEmpresa(String dniEmpresa) {
		this.dniEmpresa = dniEmpresa;
	}

	public String getProvinciaEmpresa() {
		return provinciaEmpresa;
	}

	public void setProvinciaEmpresa(String provinciaEmpresa) {
		this.provinciaEmpresa = provinciaEmpresa;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getMunicipioCliente() {
		return municipioCliente;
	}

	public void setMunicipioCliente(String municipioCliente) {
		this.municipioCliente = municipioCliente;
	}

	public String getCodigoPostalCliente() {
		return codigoPostalCliente;
	}

	public void setCodigoPostalCliente(String codigoPostalCliente) {
		this.codigoPostalCliente = codigoPostalCliente;
	}

	public String getProvinciaCliente() {
		return provinciaCliente;
	}

	public void setProvinciaCliente(String provinciaCliente) {
		this.provinciaCliente = provinciaCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getNombreFormaPago() {
		return nombreFormaPago;
	}

	public void setNombreFormaPago(String nombreFormaPago) {
		this.nombreFormaPago = nombreFormaPago;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Double getTotalIva(){
		return renta+(renta*iva/100d);
	}
	
	public Double getTotalRetencion(){
		return renta+(renta*retencion/100d);
	}
	
	public Double getTotal(){
		return renta+this.getTotalIva()-this.getTotalRetencion();
	}
    
}