/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.manager;


import java.util.List;

import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.aframework.manager.GenericManager;
import com.lazcano.alokairu.core.dao.FormaPagoDao;
import com.lazcano.alokairu.core.model.FormaPago;

/**
 *
 * @author ilazcang
 */
public class FormaPagoManager extends GenericManager<FormaPago>{

    private FormaPagoDao formaPagoDao;
    private static FormaPagoManager formaPagoManager;
    
    private FormaPagoManager(){
        this.formaPagoDao= new FormaPagoDao();
    }
    
    public static FormaPagoManager getInstance(){
        if(formaPagoManager==null){
            formaPagoManager= new FormaPagoManager();
        }
        return formaPagoManager;
    }
    
    @Override
    protected GenericDao getDao() {
        return this.formaPagoDao;
    }
    
    public List<FormaPago> buscar(String nombre){
        return this.formaPagoDao.buscar(nombre);
    }
    
}
