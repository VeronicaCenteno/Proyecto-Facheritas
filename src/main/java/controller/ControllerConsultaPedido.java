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

/**
 *
 * @author jd754
 */
@WebServlet(name = "ControllerConsultaPedido", urlPatterns = {"/ControllerConsultaPedido"})
public class ControllerConsultaPedido extends HttpServlet {
    ConsultaPedido objConsultaPedido = new ConsultaPedido();
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        }
    }
 
        //CONSULTAR
        public ArrayList consultaPedido(long idPedidoFk){

            try{
                objConsultaPedido.setIdPedidoFk(idPedidoFk);
                ResultSet consulta = objConsultaPedido.consultaPedido();
                ArrayList <ConsultaPedido> listaConsultaPedido = new ArrayList<>();
                
                while(consulta.next()){
                    
                objConsultaPedido = new ConsultaPedido();
                        objConsultaPedido.setIdPedido(consulta.getLong(1));
                        objConsultaPedido.setPrecioPedido(consulta.getInt(2));
                        objConsultaPedido.setFechaPedido(consulta.getString(3));
                        objConsultaPedido.setHoraPedido(consulta.getString(4));
                        objConsultaPedido.setEstadoPedido(consulta.getString(5));
                        objConsultaPedido.setSatisfaccionPedido(consulta.getString(6));
                        objConsultaPedido.setIdClienteFK(consulta.getString(7));
                        objConsultaPedido.setIdProductoFk(consulta.getInt(8));
                        objConsultaPedido.setIdPedidoFk(consulta.getInt(9));
                        objConsultaPedido.setCantidad(consulta.getDouble(10));
                        objConsultaPedido.setIdPedido(consulta.getInt(11));
                        objConsultaPedido.setNombreProducto(consulta.getString(12));
                        objConsultaPedido.setPrecioProducto(consulta.getString(13));
                        objConsultaPedido.setCategoriaProducto(consulta.getString(14));
                        objConsultaPedido.setDescripcionProducto(consulta.getString(15));
                        objConsultaPedido.setIdCliente(consulta.getInt(16));
                        objConsultaPedido.setNombreCliente(consulta.getString(17));
                        objConsultaPedido.setEmailCliente(consulta.getString(18));
                        objConsultaPedido.setTelefonoCliente(consulta.getString(19));
                        objConsultaPedido.setContrasenaCliente(consulta.getString(20));
                        listaConsultaPedido.add(objConsultaPedido);
                }
                return listaConsultaPedido;
            }
            catch(Exception error){
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
