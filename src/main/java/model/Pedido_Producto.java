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
public class Pedido_Producto {
    
    //ATRIBUTOS
    private int idProductoFk;
    private long idPedidoFk;
    private double cantidad;
    Conexion objConector = new Conexion();
    
    //CONSTRUCTOR
    public Pedido_Producto(){
    }
    
    //GETTERS Y SETTERS

    public int getIdProductoFk() {
        return idProductoFk;
    }

    public void setIdProductoFk(int idProductoFk) {
        this.idProductoFk = idProductoFk;
    }

    public long getIdPedidoFk() {
        return idPedidoFk;
    }

    public void setIdPedidoFk(long idPedidoFk) {
        this.idPedidoFk = idPedidoFk;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    public Conexion getObjConector() {
        return objConector;
    }

    public void setObjConector(Conexion objConector) {
        this.objConector = objConector;
    }
    
    //INSERTAR
    public void insertarPedido_Producto(){
        objConector.conectar();
        
        try {
            String sql = "INSERT INTO pedido_has_producto"
                    + "(idProductoFk, idPedidoFk, cantidad)"
                    + "VALUES(?,?,?);";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setInt(1,this.idProductoFk);
            stmt.setLong(2,this.idPedidoFk);
            stmt.setDouble(3,this.cantidad);
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error){
            System.out.println("Error al Insertar"+error);
        }
    }
    
    public ResultSet consultarPedidoProducto(){
        objConector.conectar();
        
        try {
            String sql = "SELECT COUNT(idPedidoFk) AS items FROM pedido_has_producto WHERE idPedidoFk = ?;";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setLong(1,this.idPedidoFk);
            stmt.execute();
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        } 
        catch (Exception error){
            System.out.println("Error al Consultar"+error);
        }
        return null;
    }
    
}