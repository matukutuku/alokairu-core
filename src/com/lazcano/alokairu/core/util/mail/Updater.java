/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lazcano.alokairu.core.util.mail;


import java.sql.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lazcano.alokairu.core.util.log.LocalLogger;



/**
 *
 * @author ilazcang
 */
public class Updater {
    
    private static final String UPDATE_FILE="update.txt";
    private static final String BACKUP_UPDATE_FILE="update.bak";
    
    private Updater(){
        
    }

    private static Connection openConnection(){
        Connection con=null;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con= DriverManager.getConnection("jdbc:derby:alokairu");
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return con;
    }
    
    public static void check(){
        //Comprobar si hay fichero
        File file= new File(UPDATE_FILE);
        if(file.exists()){
            String strLine=null;
            Connection con=null;
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                con=openConnection();
                //Leemos el fichero
                while ((strLine = br.readLine()) != null){
                    // Print the content on the console
                   LocalLogger.info(strLine);
                    Statement st=con.createStatement();
                    st.execute(strLine);
                   con.commit();
                   st.close();
                }
                //Borro el fichero
                br.close();
                File bckFile= new File(BACKUP_UPDATE_FILE);
                bckFile.delete();
                file.renameTo(bckFile);
            }catch(FileNotFoundException e){
                LocalLogger.error("No existe el fichero "+UPDATE_FILE);
            }catch(IOException e){
                LocalLogger.error("Error de E/S al leer el fichero "+UPDATE_FILE);
                throw new RuntimeException(e);
            }catch(SQLException e){
                LocalLogger.error("Error al ejecutar el sql "+strLine+" "+e.getMessage());
            }finally{
                if(con!=null){
                    try{ con.close();}catch(SQLException e){}
                }
            }
        }
    }
    
}
