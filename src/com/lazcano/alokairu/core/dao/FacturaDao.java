/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.dao;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.alokairu.core.model.Empresa;
import com.lazcano.alokairu.core.model.Inmueble;
import com.lazcano.alokairu.core.model.Factura;

/**
 *
 * @author ilazcang
 */
public class FacturaDao extends GenericDao<Factura>{
    
    private static FacturaDao facturaDao;
    
    private FacturaDao(){
        
    }
    
    public static FacturaDao getInstance(){
        if(FacturaDao.facturaDao==null){
            FacturaDao.facturaDao= new FacturaDao();
        }
        return FacturaDao.facturaDao;
    }
    
    @Override
    protected Class<Factura> getTClass() {
        return Factura.class;
    }
    
    public Factura buscarUltimo(Inmueble inmueble){
        Map<String,Object> parameters= new HashMap<String,Object>();
        parameters.put("inmueble", inmueble);
        List<Factura> lista=super.buscar("Select o from Factura o Where o.inmueble=:inmueble order by o.fecha desc", parameters,1);
        Factura result=null;
        if(lista.size()>0){
            result=lista.get(0);
        }
        return result;
    }
    
    public List<Factura> buscar(Date desde,Date hasta,Empresa empresa){
        Map<String,Object> parameters= new HashMap<String,Object>();
        parameters.put("desde", desde);
        parameters.put("hasta", hasta);
        parameters.put("empresa", empresa);
        return super.buscar("Select o from Factura o Where o.fecha >=:desde and o.fecha <=:hasta and o.empresa=:empresa", parameters);
    }
    
}
