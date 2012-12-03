/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.dao;


import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.alokairu.core.model.Empresa;
import com.lazcano.alokairu.core.model.Inmueble;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author ilazcang
 */
public class InmuebleDao extends GenericDao<Inmueble>{

    @Override
    protected Class<Inmueble> getTClass() {
        return Inmueble.class;
    }
    
    public List<Inmueble> buscar(String nombre,Empresa empresa){
        Map<String,Object> parameters= new HashMap<String,Object>();
        parameters.put("nombre",nombre);
        parameters.put("empresa",empresa);
        return super.buscar("Select e from Inmueble e Where e.nombre like :nombre and e.baja is null and e.empresa=:empresa", parameters);
    }
}
