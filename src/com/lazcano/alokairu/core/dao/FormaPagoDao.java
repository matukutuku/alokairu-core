/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.alokairu.core.model.FormaPago;

/**
 *
 * @author ilazcang
 */
public class FormaPagoDao extends GenericDao<FormaPago>{

    @Override
    protected Class<FormaPago> getTClass() {
        return FormaPago.class;
    }
    
    public List<FormaPago> buscar(String nombre){
        Map<String,Object> parameters=new HashMap<String,Object>();
        parameters.put("nombre",nombre);
        return super.buscar("Select o from FormaPago o Where o.nombre like :nombre and o.baja is null", parameters);
    }
}
