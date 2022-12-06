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
public class Usuario {
    
    //ATRIBUTOS
    private int idUsuario;
    private String nombreUsuario;
    private String rolUsuario;
    private String emailUsuario;
    private String contrasenaUsuario;
    Conexion objConector = new Conexion();
    
    //CONSTRUCTOR
    public Usuario(){
    }
    
    //ENCAPSULAR

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }
    
    //INSERTAR
    public void insertarUsuario(){
        objConector.conectar();
        
        try {
            String sql = "INSERT INTO usuario"
                    + "(idUsuario, nombreUsuario, rolUsuario, emailUsuario, contrasenaUsuario)"
                    + "VALUES(NULL,?,?,?,?);";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,this.nombreUsuario);
            stmt.setString(2,this.rolUsuario);
            stmt.setString(3,this.emailUsuario);
            stmt.setString(4,this.contrasenaUsuario);
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error){
            System.out.println("Error al Insertar"+ error);
        }
    }
    
    //LISTAR
    public ResultSet listarUsuarios(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM usuario";
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
    public ResultSet consultarUsuario(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.idUsuario));
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
            String sql = "SELECT * FROM usuario WHERE emailUsuario = ?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.emailUsuario));
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
            String sql = "SELECT * FROM usuario WHERE emailUsuario = ? AND contrasenaUsuario = ?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.emailUsuario));
            stmt.setString(2,String.valueOf(this.contrasenaUsuario));
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
    public void actualizarUsuario(){
        objConector.conectar();
        try{
            
            String sql = "UPDATE usuario SET "
                        + "nombreUsuario = ?, "
                        + "rolUsuario = ?, "
                        + "emailUsuario = ?, "
                        + "contrasenaUsuario = ? "
                        + "WHERE idUsuario = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement (sql);
            stmt.setString(1,this.nombreUsuario);
            stmt.setString(2,this.rolUsuario);
            stmt.setString(3,this.emailUsuario);
            stmt.setString(4,this.contrasenaUsuario);
            stmt.setString(5,String.valueOf(this.idUsuario));
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error al Actualizar: "+ error);
        }
    }
    
    //ELIMINAR
    public void eliminarUsuario(){
        objConector.conectar();
        try{
            String sql = "DELETE FROM usuario "
                        + "WHERE idUsuario = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.idUsuario));
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error al Eliminar: "+ error);
        }
    }
}

