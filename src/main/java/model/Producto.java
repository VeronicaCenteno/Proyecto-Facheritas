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
public class Producto {
    
    //ATRIBUTOS
    private int idProducto;
    private String nombreProducto;
    private String precioProducto;
    private String categoriaProducto;
    private String descripcionProducto;
    Conexion objConector = new Conexion();
    public ResultSet consultarCategoria;
    
    //CONSTRUCTOR
    public Producto(){
    }
    
    //ENCAPSULAR

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

    public Conexion getObjConector() {
        return objConector;
    }

    public void setObjConector(Conexion objConector) {
        this.objConector = objConector;
    }
    
    //INSERTAR
    public void insertarProducto(){
        objConector.conectar();
        
        try {
            String sql = "INSERT INTO producto"
                    + "(idProducto, nombreProducto, precioProducto, categoriaProducto, descripcionProducto)"
                    + "VALUES(NULL,?,?,?,?);";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,this.nombreProducto);
            stmt.setString(2,this.precioProducto);
            stmt.setString(3,this.categoriaProducto);
            stmt.setString(4,this.descripcionProducto);
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error){
            System.out.println("Error al Insertar"+ error);
        }
    }
    
    //LISTAR
    public ResultSet listarProductos(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto";
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
    public ResultSet consultarProducto(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE idProducto = ?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.idProducto));
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR HAMBURGUESAS POR CATEGORIA
    public ResultSet listarHamburguesas(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Hamburguesas'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR ANTOJITOS POR CATEGORIA
    public ResultSet listarAntojitos(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Antojitos'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR SALCHIPAPAS POR CATEGORIA
    public ResultSet listarSalchipapas(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Salchipapas'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR ROLLITOS POR CATEGORIA
    public ResultSet listarRollitos(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Rollitos'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR ROLLITOS POR CATEGORIA
    public ResultSet listarAdiciones(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Adiciones'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
        //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarBebidasC(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Bebidas Calientes'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarBebidasF(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Bebidas Familiares'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarBebidasP(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Bebidas Personales'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarCervezas(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Cervezas'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
        //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarFrappes(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Frappes'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
        //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarMazorcadas(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Mazorcadas'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
     //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarOtrosP(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Otros Platos'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
     //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarPerrosC(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Perros Calientes'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
     //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarSanduches(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Sanduches'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarSmottiesAgua(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Smotties en Agua'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarSmottiesLeche(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Smotties  en Leche'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarToppings(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Toppings'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarWaflesD(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Wafles de Dulce'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //CONSULTAR BEBIDAS CALIENTES POR CATEGORIA
    public ResultSet listarWaflesS(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM producto WHERE categoriaProducto = 'Wafles de Sal'";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar" +error);
        }
        return null;
    }
    
    //ACTUALIZAR
    public void actualizarProducto(){
        objConector.conectar();
        try{
        
            String sql = "UPDATE producto SET "
                        + "nombreProducto = ?, "
                        + "precioProducto = ?, "
                        + "categoriaProducto = ?, "
                        + "descripcionProducto = ? "
                        + "WHERE idProducto = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,this.nombreProducto);
            stmt.setString(2,this.precioProducto);
            stmt.setString(3,this.categoriaProducto);
            stmt.setString(4,this.descripcionProducto);
            stmt.setString(5,String.valueOf(this.idProducto));
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error al Actualizar "+error);
        }
    }
    
    //ELIMINAR
    public void eliminarProducto(){
        objConector.conectar();
        try{
            String sql = "DELETE FROM producto "
                        + "WHERE idProducto = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
             stmt.setString(1, String.valueOf(this.idProducto));
             stmt.execute();
             objConector.desconectar();
        } catch (Exception error){
            System.out.println("Error al Eliminar: "+error);
        }
    }
}
