/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.exception;

/**
 *
 * @author ilazcang
 */
public class NoServerEmailException extends Exception{
    
    @Override
    public String getMessage(){
        return "No se ha indicado un servidor de correo saliente";
    }
}
