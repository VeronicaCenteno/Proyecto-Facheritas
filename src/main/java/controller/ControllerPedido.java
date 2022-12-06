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
import model.ConsultaPedido;
import model.Pedido_Producto_2;
import model.Pedido;

/**
 *
 * @author jd754
 */
@WebServlet(name = "ControllerPedido", urlPatterns = {"/ControllerPedido"})
public class ControllerPedido extends HttpServlet {
    Pedido objPedido = new Pedido();
    Pedido_Producto_2 objPedido_Producto_2 = new Pedido_Producto_2();
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
            if(accion.equals("Insertar_Pedido")){
                int precioPedido = Integer.parseInt("precioPedido");
                String fechaPedido = request.getParameter("fechaPedido");
                String horaPedido = request.getParameter("horaPedido");
                String estadoPedido = request.getParameter("estadoPedido");
                String satisfaccionPedido = request.getParameter("satisfaccionPedido");
                objPedido.setPrecioPedido(precioPedido);
                objPedido.setFechaPedido(fechaPedido);
                objPedido.setHoraPedido(horaPedido);
                objPedido.setEstadoPedido(estadoPedido);
                objPedido.setSatisfaccionPedido(satisfaccionPedido);
                        
                    
                objPedido.insertarPedido();
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "alert('PEDIDO SOLICITADO CORRECTAMENTE!!!'); "+
                                "window.location.href='views/producto/listarProducto.jsp'; "+
                                "</script> </body> </html>";
                out.println(mensaje);
            }
        }
    }
    
    //CONSULTAR POR CITA
    public ArrayList listar(){
        try{
            ResultSet consulta = objPedido.listarPedidos();
            ArrayList <Pedido_Producto_2> listaPedidos = new ArrayList<>();
            
            while(consulta.next()){
                objPedido = new Pedido();
                objPedido.setIdPedido(consulta.getLong(1));
                objPedido.setPrecioPedido(consulta.getInt(2));
                objPedido.setFechaPedido(consulta.getString(3));
                objPedido.setHoraPedido(consulta.getString(4));
                objPedido.setEstadoPedido(consulta.getString(5));
                objPedido.setSatisfaccionPedido(consulta.getString(6));
                objPedido.setIdClienteFK(consulta.getString(7));
            }
            return listaPedidos;
        }
        catch (Exception error){
            System.out.println("ERROR: "+error);
        }
        return null;
    }
    
     //CONSULTAR POR FECHA
    public ArrayList listarPedidosFecha(String fechaPedido){
        try{
            ResultSet consulta = objPedido.listarPedidos();
            ArrayList <Pedido> listaPedidos = new ArrayList<>();
            
            while(consulta.next()){
                objPedido = new Pedido();
                objPedido.setIdPedido(consulta.getLong(1));
                objPedido.setPrecioPedido(consulta.getInt(2));
                objPedido.setFechaPedido(consulta.getString(3));
                objPedido.setHoraPedido(consulta.getString(4));
                objPedido.setEstadoPedido(consulta.getString(5));
                objPedido.setSatisfaccionPedido(consulta.getString(6));
                objPedido.setIdClienteFK(consulta.getString(7));
            }
            return listaPedidos;
        }
        catch (Exception error){
            System.out.println("ERROR: "+error);
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
