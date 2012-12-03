/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilazcang
 */
public class LocalLogger {

    private LocalLogger(){
    }
    
    public static void error(String message){
        Logger logger=Logger.getLogger("alokairu");
        logger.log(Level.SEVERE, message);
    }
    
    public static void info(String message){
        Logger logger=Logger.getLogger("alokairu");
        logger.log(Level.INFO, message);
    }
}
