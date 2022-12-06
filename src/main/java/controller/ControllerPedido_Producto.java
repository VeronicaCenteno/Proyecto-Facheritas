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
import model.Pedido_Producto;

/**
 *
 * @author jd754
 */
@WebServlet(name = "ControllerPedido_Producto", urlPatterns = {"/ControllerPedido_Producto"})
public class ControllerPedido_Producto extends HttpServlet {
    Pedido_Producto objPedido_Producto = new Pedido_Producto();
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
                try{
                    int idProductoFk = Integer.parseInt(request.getParameter("idProducto"));
                    long idPedidoFk = Long.parseLong(request.getSession().getAttribute("idPedido").toString());
                    double cantidad = Double.parseDouble(request.getParameter("cantidad"));
                    objPedido_Producto.setIdPedidoFk(idPedidoFk);
                    objPedido_Producto.setIdProductoFk(idProductoFk);
                    objPedido_Producto.setCantidad(cantidad);
                    
                    objPedido_Producto.insertarPedido_Producto();
                    
                     String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='menu.jsp'; "+
                                "</script> </body> </html>";
                    out.println(mensaje);
                } catch(Exception error) {
                    
                }             
            }
        }
    }
    
    //CONSULTAR PEDIDO_PRODUCTO
    public int consultarPedidoProducto(long idPedidoFk){
        try{
            objPedido_Producto.setIdPedidoFk(idPedidoFk);
            ResultSet consulta = objPedido_Producto.consultarPedidoProducto();
           int items  = 0;
            while(consulta.next()){
               items = consulta.getInt(1);
            }
                System.out.println(items);
                return items;
        }
            catch (Exception error){
                System.out.println("ERROR" +error);
            }
            return 0;
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