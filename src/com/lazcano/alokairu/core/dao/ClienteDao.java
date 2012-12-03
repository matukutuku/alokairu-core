/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.dao;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.alokairu.core.model.Cliente;
import com.lazcano.alokairu.core.model.Empresa;

/**
 *
 * @author ilazcang
 */
public class ClienteDao extends GenericDao<Cliente>{
 
    private static ClienteDao clienteDao;
    
    private ClienteDao(){
        
    }
    
    public static ClienteDao getInstance(){
        if(ClienteDao.clienteDao==null){
            ClienteDao.clienteDao= new ClienteDao();
        }
        return ClienteDao.clienteDao;
    }
    
    @Override
    protected Class<Cliente> getTClass() {
        return Cliente.class;
    }
    
    public List<Cliente> buscar(String nombre,Empresa enpresa){
        Map<String,Object> parametros= new HashMap<String,Object>();
        parametros.put("nombre",nombre);
        parametros.put("empresa",enpresa);
        return super.buscar("Select b from Cliente b Where b.nombre like :nombre and b.baja is null and b.empresa=:empresa", parametros);
    }
}
