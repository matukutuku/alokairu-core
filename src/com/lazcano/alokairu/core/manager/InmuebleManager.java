/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.manager;


import java.util.List;

import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.aframework.manager.GenericManager;
import com.lazcano.alokairu.core.dao.InmuebleDao;
import com.lazcano.alokairu.core.model.Empresa;
import com.lazcano.alokairu.core.model.Inmueble;

/**
 *
 * @author ilazcang
 */
public class InmuebleManager extends GenericManager<Inmueble>{

    private InmuebleDao inmuebleDao;
    private static InmuebleManager inmuebleManager;
    
    
    
    private InmuebleManager(){
        this.inmuebleDao= new InmuebleDao();
    }
    
    public static InmuebleManager getInstance(){
        if(inmuebleManager==null){
            inmuebleManager= new InmuebleManager();
        }
        return inmuebleManager;
    }
    
    @Override
    protected GenericDao getDao() {
        return this.inmuebleDao;
    }
    
    public List<Inmueble> buscar(String nombre,Empresa empresa){
        return this.inmuebleDao.buscar(nombre,empresa);
    }
}
