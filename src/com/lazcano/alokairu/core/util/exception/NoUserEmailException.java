/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.exception;

/**
 *
 * @author ilazcang
 */
public class NoUserEmailException extends Exception{
    @Override
    public String getMessage(){
        return "No se ha especificado un usuario de correo";
    }
}
