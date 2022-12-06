/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jd754
 */
public class Cliente {
    
    //ATRIBUTOS
    private int idCliente;
    private String nombreCliente;
    private String emailCliente;
    private String telefonoCliente;
    private String contrasenaCliente;
    Conexion objConector = new Conexion();
    
    //CONSTRUCTOR
    public Cliente(){
    }
    
    //ENCAPSULAR
    public int getIdCliente(){
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getContrasenaCliente() {
        return contrasenaCliente;
    }

    public void setContrasenaCliente(String contrasenaCliente) {
        this.contrasenaCliente = contrasenaCliente;
    }
    
    //INSERTAR
    public void insertarCliente(){
        objConector.conectar();
        
        try {
            String sql = "INSERT INTO cliente"
                    + "(idCliente, nombreCliente, emailCliente, telefonoCliente, contrasenaCliente)"
                    + "VALUES(NULL,?,?,?,?);";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,this.nombreCliente);
            stmt.setString(2,this.emailCliente);
            stmt.setString(3,this.telefonoCliente);
            stmt.setString(4,this.contrasenaCliente);
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error){
            System.out.println("Error al Insertar"+ error);
        }
    }
    
    //LISTAR
    public ResultSet listarClientes(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM cliente";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch(Exception error){
            System.out.println("Error al Listar: "+error);
        }
        return null;
    }
    
    //CONSULTAR X ID
    public ResultSet consultarCliente(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM cliente WHERE idCliente = ?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.idCliente));
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar: "+error);
        }
        return null;
    }
    
    //CONSULTAR CLIENTE POR CORREO
    public ResultSet consultarCorreo(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM cliente WHERE emailCliente = ?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.emailCliente));
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar: "+error);
        }
        return null;
    }
    
    
    //LOGIN
    public ResultSet login(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM cliente WHERE emailCliente = ? AND contrasenaCliente = ?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.emailCliente));
            stmt.setString(2,String.valueOf(this.contrasenaCliente));
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar: "+error);
        }
        return null;
    }
    
    //ACTUALIZAR
    public void actualizarCliente(){
        objConector.conectar();
        try{
            
            String sql = "UPDATE cliente SET "
                        + "nombreCliente = ?, "
                        + "emailCliente = ?, "
                        + "telefonoCliente = ?, "
                        + "contrasenaCliente = ? "
                        + "WHERE idCliente = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement (sql);
            stmt.setString(1,this.nombreCliente);
            stmt.setString(2,this.emailCliente);
            stmt.setString(3,this.telefonoCliente);
            stmt.setString(4,this.contrasenaCliente);
            stmt.setString(5,String.valueOf(this.idCliente));
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error al Actualizar: "+ error);
        }
    }
    
    //ELIMINAR
    public void eliminarCliente(){
        objConector.conectar();
        try{
            String sql = "DELETE FROM cliente "
                        + "WHERE idCliente = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.idCliente));
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error al Eliminar: "+ error);
        }
    }
}
