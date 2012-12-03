/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;





import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.aframework.manager.GenericManager;
import com.lazcano.alokairu.core.dao.InmuebleDao;
import com.lazcano.alokairu.core.dao.FacturaDao;
import com.lazcano.alokairu.core.model.Cliente;
import com.lazcano.alokairu.core.model.EmailConfig;
import com.lazcano.alokairu.core.model.Empresa;
import com.lazcano.alokairu.core.model.Inmueble;
import com.lazcano.alokairu.core.model.Factura;
import com.lazcano.alokairu.core.util.exception.NoFromEmailException;
import com.lazcano.alokairu.core.util.exception.NoPasswdEmailException;
import com.lazcano.alokairu.core.util.exception.NoServerEmailException;
import com.lazcano.alokairu.core.util.exception.NoToEmailException;
import com.lazcano.alokairu.core.util.exception.NoUserEmailException;
import com.lazcano.alokairu.core.util.mail.EmailSender;
import com.lazcano.alokairu.core.util.pdf.PdfPrinter;
import com.lazcano.alokairu.core.util.pdf.Reciboa;


/**
 *
 * @author ilazcang
 */
public class FacturaManager extends GenericManager<Factura>{

    private FacturaDao facturaDao;
    private InmuebleDao inmuebleDao;
    private static FacturaManager facturaManager;
    
    public static FacturaManager getInstance(){
        if(facturaManager==null){
            facturaManager= new FacturaManager();
        }
        return facturaManager;
    }
    
    private FacturaManager(){
        this.facturaDao= FacturaDao.getInstance();
        this.inmuebleDao= new InmuebleDao();
    }
    
    private Factura copia(Factura factura){
        Factura facturaNueva= new Factura();
        facturaNueva.setNumero(factura.getNumero()+1);
        facturaNueva.setEmpresa(factura.getEmpresa());
        facturaNueva.setCliente(factura.getCliente());
        facturaNueva.setInmueble(factura.getInmueble());
        facturaNueva.setRetencion(factura.getRetencion());
        facturaNueva.setDireccionCliente(factura.getDireccionCliente());
        facturaNueva.setMunicipioCliente(factura.getMunicipioCliente());
        facturaNueva.setNombreCliente(factura.getNombreCliente());
        facturaNueva.setProvinciaCliente(factura.getProvinciaCliente());
        facturaNueva.setDniCliente(factura.getDniCliente());
        facturaNueva.setCodigoPostalCliente(factura.getCodigoPostalCliente());
        facturaNueva.setDireccionEmpresa(factura.getDireccionEmpresa());
        facturaNueva.setMunicipioEmpresa(factura.getMunicipioEmpresa());
        facturaNueva.setNombreEmpresa(factura.getNombreEmpresa());
        facturaNueva.setProvinciaEmpresa(factura.getProvinciaEmpresa());
        facturaNueva.setDniEmpresa(factura.getDniEmpresa());
        facturaNueva.setCodigoPostalEmpresa(factura.getCodigoPostalEmpresa());
        facturaNueva.setFecha(new Date());
        facturaNueva.setNombreInmueble(factura.getNombreInmueble());
        facturaNueva.setRenta(factura.getRenta());
        facturaNueva.setIva(factura.getIva());
        facturaNueva.setNombreFormaPago(factura.getNombreFormaPago());
        return facturaNueva;
    }
    
    @Override
    protected GenericDao getDao() {
        return this.facturaDao;
    }
    
    
    
    
    public void guardar(Factura factura,Empresa empresa, Cliente cliente,Inmueble inmueble){
        if(factura==null){
            factura= new Factura();
        }
        factura.setEmpresa(empresa);
        factura.setCliente(cliente);
        factura.setInmueble(inmueble);
        factura.setRetencion(inmueble.getRetencion());
        factura.setDireccionCliente(cliente.getDireccion());
        factura.setMunicipioCliente(cliente.getMunicipio());
        factura.setNombreCliente(cliente.getNombre());
        factura.setProvinciaCliente(cliente.getProvincia());
        factura.setDniCliente(cliente.getDni());
        factura.setCodigoPostalCliente(cliente.getCodigoPostal());
        factura.setDireccionEmpresa(empresa.getDireccion());
        factura.setMunicipioEmpresa(empresa.getMunicipio());
        factura.setNombreEmpresa(empresa.getNombre());
        factura.setProvinciaEmpresa(empresa.getProvincia());
        factura.setDniEmpresa(empresa.getDni());
        factura.setCodigoPostalEmpresa(empresa.getCodigoPostal());
        factura.setFecha(new Date());
        factura.setNombreInmueble(inmueble.getNombre());
        factura.setRenta(inmueble.getRenta());
        factura.setIva(inmueble.getIva());
        super.guardar(factura);
    }
    
    
    public void crearSiguiente(Integer idInmueble){
        Inmueble inmueble=this.inmuebleDao.cargar(idInmueble);
        Factura ultima=this.facturaDao.buscarUltimo(inmueble);
        Factura facturaNueva=this.copia(ultima);
        Calendar fechaNueva =Calendar.getInstance();
        fechaNueva.setTime(ultima.getFecha());
        fechaNueva.add(Calendar.MONTH, 1);
        fechaNueva.set(Calendar.DAY_OF_MONTH, 1);
        facturaNueva.setFecha(fechaNueva.getTime());
        super.guardar(facturaNueva);
    }
    
    public void print(Factura agiri){
        PdfPrinter.print(new Reciboa(),agiri);
    }

    private void checkEnpresaEmail(Empresa empresa) throws NoFromEmailException, NoServerEmailException, NoUserEmailException, NoPasswdEmailException{
        if(empresa.getEmail()==null){
            throw new NoFromEmailException();
        }else if(empresa.getEmailServer()==null){
            throw new NoServerEmailException();
        }else if(empresa.getEmailUser()==null){
            throw new NoUserEmailException();
        }else if (empresa.getEmailPasswd()==null){
            throw new NoPasswdEmailException();
        }
    }
    
    private void checkClienteEmail(Cliente cliente) throws NoToEmailException{
        if(cliente.getEmail()==null){
            throw new NoToEmailException();
        }
    }
    
    public void send(Factura agiri) throws NoFromEmailException, NoServerEmailException, NoUserEmailException, NoPasswdEmailException, MessagingException, NoToEmailException{
        String fileName=agiri.getFecha().getTime()+".pdf";
        PdfPrinter.print(new Reciboa(),agiri,fileName,false);
        EmailConfig config= new EmailConfig();
        Empresa empresa=agiri.getEmpresa();
        this.checkEnpresaEmail(empresa);
        Cliente cliente=agiri.getCliente();
        this.checkClienteEmail(cliente);
        config.setSender(empresa.getEmail());
        config.setServer(empresa.getEmailServer());
        config.setPasswd(empresa.getEmailPasswd());
        EmailSender.send(config, cliente.getEmail(), "Recibo ", "", System.getProperty("java.io.tmpdir")+fileName);
    }
}
