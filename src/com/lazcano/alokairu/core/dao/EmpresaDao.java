/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.dao;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.alokairu.core.model.Empresa;

/**
 *
 * @author ilazcang
 */
public class EmpresaDao extends GenericDao<Empresa>{

    @Override
    protected Class<Empresa> getTClass() {
        return Empresa.class;
    }
    
    public List<Empresa> buscar(String nombre){
       Map<String,Object> parameters=new HashMap<String,Object>();
       parameters.put("nombre", nombre);
       return super.buscar("Select e from Empresa e Where e.nombre like :nombre and e.baja is null", parameters);
    }
    
    public Empresa buscarPorLogin(String login){
    	Empresa result=null;
    	Empresa empresa= new Empresa();
    	empresa.setLogin(login);
    	List<Empresa> lista=super.buscarPorEjemplo(empresa);
    	if(!lista.isEmpty()){
    		result=lista.get(0);
    	}
    	return result;
    }
}
