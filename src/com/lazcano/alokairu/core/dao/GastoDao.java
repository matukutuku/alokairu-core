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
import com.lazcano.alokairu.core.model.Gasto;

/**
 *
 * @author ilazcang
 */
public class GastoDao extends GenericDao{

    private static GastoDao gastuaDao;
    
    
    
    private GastoDao(){
        
    }
    
    public static GastoDao getInstance(){
        if(gastuaDao==null){
            gastuaDao=new GastoDao();
        }
        return gastuaDao;
    }
    
    
    @Override
    protected Class<Gasto> getTClass() {
        return Gasto.class;
    }
    
     public List<Gasto> buscar(String deskribapena){
       Map<String,Object> parameters=new HashMap<String,Object>();
       parameters.put("deskribapena", deskribapena);
       return super.buscar("Select g from Gastua g Where g.deskribapena like :deskribapena ", parameters);
    }
     
     public List<Gasto> buscar(Date inicio, Date fin){
       Map<String,Object> parameters=new HashMap<String,Object>();
       parameters.put("inicio", inicio);
       parameters.put("fin", fin);
       return super.buscar("Select g from Gastua g Where g.data >=:inicio and g.data <=:fin ", parameters);
     }
     
     public List<Gasto> buscar(Date inicio, Date fin,Empresa enpresa){
       Map<String,Object> parameters=new HashMap<String,Object>();
       parameters.put("inicio", inicio);
       parameters.put("fin", fin);
       parameters.put("enpresa", enpresa);
       return super.buscar("Select g from Gastua g Where g.data >=:inicio and g.data <=:fin and g.eraikina.enpresa=:enpresa", parameters);
     }
     
     public List<Gasto> buscar(Integer agnoIva, Integer trimestreIva,Empresa enpresa){
       Map<String,Object> parameters=new HashMap<String,Object>();
       parameters.put("agnoIva", agnoIva);
       parameters.put("trimestreIva", trimestreIva);
       parameters.put("enpresa", enpresa);
       return super.buscar("Select g from Gastua g Where g.agnoIva >=:agnoIva and g.trimestreIva <=:trimestreIva and g.eraikina.enpresa=:enpresa", parameters);
     }
}
