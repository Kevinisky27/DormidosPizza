/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.edu.dominos_Pizzagt.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author kevinalexanderlimarecinos
 */
public class MySQLSconexion {
    Connection conectardb = null; 
    
    public Connection Conectar() {
       String DB = "jdbc:mysql://sql10.freesqldatabase.com";
       String Usuario = "sql10413110"; 
       String Password = "QC3L6VqdDt"; 
       try{
            
           Class.forName("com.mysql.cj.jdbc.Driver"); 
           conectardb = DriverManager.getConnection(DB, Usuario, Password);
           
        } catch (Exception e) {
            // Si al momento de conectarse a la base de datos nos aparece un error, mostrará este mensaje
            //JOptionPane.showMessageDialog(null, "Error al Conectarse a la Base de Datos");
            JOptionPane.showMessageDialog(null,"Error al conectar la Base de Datos :( ");
        }
       return conectardb; 
    }   
}
