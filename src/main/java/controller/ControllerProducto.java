/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;

/**
 *
 * @author jd754
 */
@WebServlet(name = "ControllerProducto", urlPatterns = {"/ControllerProducto"})
public class ControllerProducto extends HttpServlet {
    Producto objProducto = new Producto();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("btnAccion");
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //INSERTAR
            if(accion.equals("Insertar")){
                String nombreProducto = request.getParameter("nombreProducto");
                String precioProducto = request.getParameter("precioProducto");
                String categoriaProducto = request.getParameter("categoriaProducto");
                String descripcionProducto = request.getParameter("descripcionProducto");
                objProducto.setNombreProducto(nombreProducto);
                objProducto.setPrecioProducto(precioProducto);
                objProducto.setCategoriaProducto(categoriaProducto);
                objProducto.setDescripcionProducto(descripcionProducto);

                objProducto.insertarProducto();

                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "alert('PRODUCTO INSERTADO CORRECTAMENTE!!!'); "+
                                "window.location.href='views/producto/listarProducto.jsp'; "+
                                "</script> </body> </html>";
                out.println(mensaje);
            }
            
            //ACTUALIZAR
            else if(accion.equals("Actualizar")){
                int idProducto = Integer.parseInt(request.getParameter("idProducto")); 
                String nombreProducto = request.getParameter("nombreProducto");
                String precioProducto = request.getParameter("precioProducto");
                String categoriaProducto = request.getParameter("categoriaProducto");
                String descripcionProducto = request.getParameter("descripcionProducto"); 
                objProducto.setIdProducto(idProducto);
                objProducto.setNombreProducto(nombreProducto);
                objProducto.setPrecioProducto(precioProducto);
                objProducto.setCategoriaProducto(categoriaProducto);
                objProducto.setDescripcionProducto(descripcionProducto);
                
                objProducto.actualizarProducto();
               
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "alert('PRODUCTO ACTUALIZADO CORRECTAMENTE!!!'); "+
                                "window.location.href='views/producto/listarProducto.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
                
            }
            
            //ELIMINAR
            else if(accion.equals("Eliminar")){
                 int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                objProducto.setIdProducto(idProducto);
                
                objProducto.eliminarProducto();
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='views/producto/listarProducto.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
            }
        }
    }
    
    public ArrayList listar(){
        try{
            ResultSet consulta = objProducto.listarProductos();
            ArrayList <Producto> listaProductos = new ArrayList<>();
            
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaProductos.add(objProducto);
            }
            return listaProductos;
        }
        catch(Exception error){
            System.out.println("ERROR: "+error);
        }
        return null;
    }
    
   
    
    //CONSULTAR POR ID
    public ArrayList consultaXIdProducto(int idProducto){
        try{
            objProducto.setIdProducto(idProducto);
            ResultSet consulta = objProducto.consultarProducto();
            ArrayList<Producto> listaProducto = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaProducto.add(objProducto);
        }
            return listaProducto;
    }
        catch (Exception error){
            System.out.println("ERROR" +error);
        }
        return null;
    }
    
    //CONSULTAR ADICIONES
        public ArrayList consultarAdiciones(){
        try{
            ResultSet consulta = objProducto.listarAdiciones();
            ArrayList<Producto> listaAdiciones = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaAdiciones.add(objProducto);
            }
                return listaAdiciones;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
    
        //CONSULTAR ANTOJITOS
    public ArrayList consultarAntojitos(){
        try{
            ResultSet consulta = objProducto.listarAntojitos();
            ArrayList<Producto> listaAntojitos = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaAntojitos.add(objProducto);
            }
                return listaAntojitos;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
    
    //CONSULTAR BEBIDAS CALIENTES
        public ArrayList consultarBebidasC(){
        try{
            ResultSet consulta = objProducto.listarBebidasC();
            ArrayList<Producto> listaBebidasC = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaBebidasC.add(objProducto);
            }
                return listaBebidasC;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
    //CONSULTAR BEBIDAS FAMILIARES
        public ArrayList consultarBebidasF(){
        try{
            ResultSet consulta = objProducto.listarBebidasF();
            ArrayList<Producto> listaBebidasF = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaBebidasF.add(objProducto);
            }
                return listaBebidasF;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
        //CONSULTAR BEBIDAS PERSONALES
        public ArrayList consultarBebidasP(){
        try{
            ResultSet consulta = objProducto.listarBebidasP();
            ArrayList<Producto> listaBebidasP = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaBebidasP.add(objProducto);
            }
                return listaBebidasP;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
        
        //CONSULTAR CERVEZAS
        public ArrayList consultarCervezas(){
        try{
            ResultSet consulta = objProducto.listarCervezas();
            ArrayList<Producto> listaCervezas = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaCervezas.add(objProducto);
            }
                return listaCervezas;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }   
        
        //CONSULTAR FRAPPES
        public ArrayList consultarFrappes(){
        try{
            ResultSet consulta = objProducto.listarFrappes();
            ArrayList<Producto> listaFrappes = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaFrappes.add(objProducto);
            }
                return listaFrappes;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }   
        
    //CONSULTAR HAMBURGUESAS
    public ArrayList consultarHamburguesas(){
        try{
            ResultSet consulta = objProducto.listarHamburguesas();
            ArrayList<Producto> listaHamburguesas = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaHamburguesas.add(objProducto);
            }
                return listaHamburguesas;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
    
    //CONSULTAR MAZORCADAS
        public ArrayList consultarMazorcadas(){
        try{
            ResultSet consulta = objProducto.listarMazorcadas();
            ArrayList<Producto> listaMazorcadas = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaMazorcadas.add(objProducto);
            }
                return listaMazorcadas;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }   
        
        //CONSULTAR OTROS PLATOS
        public ArrayList consultarOtrosP(){
        try{
            ResultSet consulta = objProducto.listarOtrosP();
            ArrayList<Producto> listaOtrosP = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaOtrosP.add(objProducto);
            }
                return listaOtrosP;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
        //CONSULTAR PERROS CALIENTES
        public ArrayList consultarPerrosC(){
        try{
            ResultSet consulta = objProducto.listarPerrosC();
            ArrayList<Producto> listaPerrosC = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaPerrosC.add(objProducto);
            }
                return listaPerrosC;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
        //CONSULTAR ROLLITOS
        public ArrayList consultarRollitos(){
        try{
            ResultSet consulta = objProducto.listarRollitos();
            ArrayList<Producto> listaRollitos = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaRollitos.add(objProducto);
            }
                return listaRollitos;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
    //CONSULTAR SALCHIPAPAS
    public ArrayList consultarSalchipapas(){
        try{
            ResultSet consulta = objProducto.listarSalchipapas();
            ArrayList<Producto> listaSalchipapas = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaSalchipapas.add(objProducto);
            }
                return listaSalchipapas;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
    
        //CONSULTAR SANDUCHES
        public ArrayList consultarSanduches(){
        try{
            ResultSet consulta = objProducto.listarSanduches();
            ArrayList<Producto> listaSanduches = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaSanduches.add(objProducto);
            }
                return listaSanduches;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
        //CONSULTAR SMOTTIES EN AGUA
        public ArrayList consultarSmottiesAgua(){
        try{
            ResultSet consulta = objProducto.listarSmottiesAgua();
            ArrayList<Producto> listaSmottiesAgua = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaSmottiesAgua.add(objProducto);
            }
                return listaSmottiesAgua;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
        //CONSULTAR SMOTTIES EN LECHE
        public ArrayList consultarSmottiesLeche(){
        try{
            ResultSet consulta = objProducto.listarSmottiesLeche();
            ArrayList<Producto> listaSmottiesLeche = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaSmottiesLeche.add(objProducto);
            }
                return listaSmottiesLeche;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
        //CONSULTAR TOPPINGS
        public ArrayList consultarToppings(){
        try{
            ResultSet consulta = objProducto.listarToppings();
            ArrayList<Producto> listaToppings = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaToppings.add(objProducto);
            }
                return listaToppings;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
           //CONSULTAR WAFLES DE DULCE
        public ArrayList consultarWaflesD(){
        try{
            ResultSet consulta = objProducto.listarWaflesD();
            ArrayList<Producto> listaWaflesD = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaWaflesD.add(objProducto);
            }
                return listaWaflesD;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
          //CONSULTAR WAFLES SAL
        public ArrayList consultarWaflesS(){
        try{
            ResultSet consulta = objProducto.listarWaflesS();
            ArrayList<Producto> listaWaflesS = new ArrayList<>();
            while(consulta.next()){
                objProducto = new Producto();
                objProducto.setIdProducto(consulta.getInt(1));
                objProducto.setNombreProducto(consulta.getString(2));
                objProducto.setPrecioProducto(consulta.getString(3));
                objProducto.setCategoriaProducto(consulta.getString(4));
                objProducto.setDescripcionProducto(consulta.getString(5));
                listaWaflesS.add(objProducto);
            }
                return listaWaflesS;
        }
            catch (Exception error){
                System.out.println("ERROR" + error);
            }
            return null;
    }
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
