/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.manager;


import java.util.List;

import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.aframework.manager.GenericManager;
import com.lazcano.alokairu.core.dao.ClienteDao;
import com.lazcano.alokairu.core.model.Cliente;
import com.lazcano.alokairu.core.model.Empresa;

/**
 *
 * @author ilazcang
 */
public class ClienteManager extends GenericManager{
    private ClienteDao clienteDao;
    private static ClienteManager clienteManager;
    
    private ClienteManager(){
        this.clienteDao=ClienteDao.getInstance();
    }
    
    public static ClienteManager getInstance(){
        if(ClienteManager.clienteManager==null){
            ClienteManager.clienteManager= new ClienteManager();
        }
        return ClienteManager.clienteManager;
    }
    
    public List<Cliente> buscar(String nombre,Empresa empresa){
        return this.clienteDao.buscar(nombre,empresa);
    }
    

    @Override
    protected GenericDao getDao() {
        return this.clienteDao;
    }
    
  
}
