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
public class Pedido {
    
    //ATRIBUTOS
    private long idPedido; 
    private int precioPedido;
    private String fechaPedido;
    private String horaPedido;
    private String estadoPedido;
    private String satisfaccionPedido;
    private String idClienteFK;
    Conexion objConector = new Conexion();
    
    //Constructor
    public Pedido(){
    }
    
    //Encapsular

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }
    
    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getPrecioPedido() {
        return precioPedido;
    }

    public void setPrecioPedido(int precioPedido) {
        this.precioPedido = precioPedido;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }
    

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getSatisfaccionPedido() {
        return satisfaccionPedido;
    }

    public void setSatisfaccionPedido(String satisfaccionPedido) {
        this.satisfaccionPedido = satisfaccionPedido;
    }

    public String getIdClienteFK() {
        return idClienteFK;
    }

    public void setIdClienteFK(String idClienteFK) {
        this.idClienteFK = idClienteFK;
    }

    public Conexion getObjConector() {
        return objConector;
    }

    public void setObjConector(Conexion objConector) {
        this.objConector = objConector;
    }
    
    //INSERTAR
    public void insertarPedido(){
        objConector.conectar();
        
        try{
            String sql = "INSERT INTO pedido"
                    + "(idPedido, precioPedido, fechaPedido, horaPedido, estadoPedido, satisfaccionPedido, idclienteFK)"
                    + "VALUES(?,?,?,?,?,?,?);";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setLong(1,this.idPedido);
            stmt.setInt(2,this.precioPedido);
            stmt.setString(3,this.fechaPedido);
            stmt.setString(4,this.horaPedido);
            stmt.setString(5,this.estadoPedido);
            stmt.setString(6,this.satisfaccionPedido);
            stmt.setString(7,this.idClienteFK);
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error){
            System.out.println("Error al Insertar"+ error);
        }
    }
    
    //ACTAULIZAR IDFK
    public void actaulizarFk(){
        objConector.conectar();
        try{
            String sql = "UPDATE pedido "
                        + "SET idclienteFK=? "
                        + "WHERE idPedido=?;";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.idClienteFK));
            stmt.setString(2,String.valueOf(this.idPedido));
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error){
            System.out.println("Error al Actualizar: "+ error);
        }
    }
    
    //CONSULTAR CITA
    public ResultSet listarPedidos(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM consultaFecha; ";
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
    
    //consultar por fecha 
      public ResultSet listarPedidosFecha(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM consultaFecha WHERE fechaPedido= ? ; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,this.fechaPedido);
            objConector.desconectar();
        }
        catch(Exception error){
            System.out.println("Error al Listar: "+error);
        }
        return null;
    }
}
