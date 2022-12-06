/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jd754
 */
public class Conexion {
    
   //Declarar atributos para la conexion
    private  String bbdd="jdbc:mysql://localhost:3306/bd_facheritas";
    private  String usuario="root";
    private  String clave="";
    public  Connection conn;

    //Declarar el metodo de conexion
    public void conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn=DriverManager.getConnection(bbdd,usuario,clave);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexion a la base de datos"+e.getMessage().toString());
        }
    }
    
    public void desconectar(){
        conn=null; 
    }
}