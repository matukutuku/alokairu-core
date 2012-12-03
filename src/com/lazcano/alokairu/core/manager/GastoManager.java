/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.manager;


import java.util.List;
import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.aframework.manager.GenericManager;
import com.lazcano.alokairu.core.dao.GastoDao;
import com.lazcano.alokairu.core.model.Gasto;
/**
 *
 * @author ilazcang
 */
public class GastoManager extends GenericManager<Gasto>{
    private GastoDao gastoDao;
    
    private static GastoManager gastoManager;
    
    private GastoManager(){
        this.gastoDao=GastoDao.getInstance();
    }
    
     public static GastoManager getInstance(){
        if(GastoManager.gastoManager==null){
            GastoManager.gastoManager= new GastoManager();
        }
        return GastoManager.gastoManager;
    }
    
    @Override
    protected GenericDao getDao() {
        return gastoDao;
    }
    
    public List<Gasto> buscar(String descripcion){
       return this.gastoDao.buscar(descripcion);
    }
}
