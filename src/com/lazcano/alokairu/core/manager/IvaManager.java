/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.manager;


import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.lazcano.alokairu.core.dao.GastoDao;
import com.lazcano.alokairu.core.dao.FacturaDao;
import com.lazcano.alokairu.core.model.Empresa;
import com.lazcano.alokairu.core.model.InformeIva;
import com.lazcano.alokairu.core.model.InformeIvaMes;
import com.lazcano.alokairu.core.model.Factura;

/**
 *
 * @author ilazcang
 */
public class IvaManager {
    
    
    private FacturaDao facturaDao;
    private GastoDao gastoDao;
    private static IvaManager ivaManager;
    
    private IvaManager(){
        this.facturaDao=FacturaDao.getInstance();
        this.gastoDao=GastoDao.getInstance();
    }
    
    public static IvaManager getInstance(){
        if(IvaManager.ivaManager==null){
            IvaManager.ivaManager=new IvaManager();
        }
        return IvaManager.ivaManager;
    }
    
    private InformeIvaMes crearMesInforme(Integer mes, Integer agno,Empresa enpresa){
        Calendar inicio= Calendar.getInstance();
        inicio.set(Calendar.MONTH, mes);
        inicio.set(Calendar.YEAR, agno);
        inicio.set(Calendar.DAY_OF_MONTH,1);
        
        Calendar fin= Calendar.getInstance();
        fin.set(Calendar.MONTH, mes);
        fin.set(Calendar.YEAR, agno);
        fin.set(Calendar.DAY_OF_MONTH,fin.getActualMaximum(Calendar.DAY_OF_MONTH));
        List<Factura> agiriLista=this.facturaDao.buscar(inicio.getTime(), fin.getTime(),enpresa);
        InformeIvaMes result= new InformeIvaMes(inicio.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()), agno, agiriLista,enpresa);
        return result;
    }
    
    public InformeIva crearInforme(Integer trimestre,Integer agno,Empresa enpresa){
        InformeIva informe= new InformeIva(trimestre);
        InformeIvaMes[] meses= new InformeIvaMes[3];
        for(int i=0;i<3;i++){
            int mes=(trimestre*3)+i;
            meses[i]=this.crearMesInforme(mes, agno,enpresa);
        }
        informe.setMeses(meses);
        informe.setGastos(this.gastoDao.buscar(agno, trimestre, enpresa));
        return informe;
    }
}
