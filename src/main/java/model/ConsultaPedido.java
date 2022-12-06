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
public class ConsultaPedido {
    
    //ATRIBUTOS
    private long idPedido;
    private int precioPedido;
    private String fechaPedido;
    private String horaPedido;
    private String estadoPedido;
    private String satisfaccionPedido;
    private String idClienteFK;
    private int idProductoFk;
    private long idPedidoFk;
    private double cantidad;
    private int idProducto;
    private String nombreProducto;
    private String precioProducto;
    private String categoriaProducto;
    private String descripcionProducto;
    private int idCliente;
    private String nombreCliente;
    private String emailCliente;
    private String telefonoCliente;
    private String contrasenaCliente;
    Conexion objConector = new Conexion();
    
    //CONSTRUCTOR
    public ConsultaPedido(){
    }
    
    //ENCAPSULAR

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public int getPrecioPedido() {
        return precioPedido;
    }

    public void setPrecioPedido(int precioPedido) {
        this.precioPedido = precioPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getIdCliente() {
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

    public Conexion getObjConector() {
        return objConector;
    }

    public void setObjConector(Conexion objConector) {
        this.objConector = objConector;
    }
    
    //CONSULTAR
    public ResultSet consultaPedido() {
            objConector.conectar();
        
        try {
            String sql = "SELECT * FROM consultaPedido WHERE idPedidoFk=?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setLong(1,this.idPedidoFk);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar: "+error);
        }
        return null;
    }
}
