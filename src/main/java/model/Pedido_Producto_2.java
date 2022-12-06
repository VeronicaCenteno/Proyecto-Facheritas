/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jd754
 */
public class Pedido_Producto_2 {
    
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
    Conexion objConector = new Conexion();
    
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
    
    
}
