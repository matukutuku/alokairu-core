/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.manager;


import java.util.List;

import com.lazcano.aframework.dao.GenericDao;
import com.lazcano.aframework.manager.GenericManager;
import com.lazcano.alokairu.core.dao.EmpresaDao;
import com.lazcano.alokairu.core.model.Empresa;


/**
 *
 * @author ilazcang
 */
public class EmpresaManager extends GenericManager<Empresa>{
        private EmpresaDao empresaDao;
        private static EmpresaManager empresaManager;
        
        private EmpresaManager(){
            this.empresaDao= new EmpresaDao();
        }

        public static EmpresaManager getInstance(){
            if(empresaManager==null){
                empresaManager= new EmpresaManager();
            }
            return empresaManager;
        }
        
        public List<Empresa> buscar(String izena){
            return this.empresaDao.buscar(izena);
        }

    @Override
    protected GenericDao getDao() {
        return this.empresaDao;
    }

}
