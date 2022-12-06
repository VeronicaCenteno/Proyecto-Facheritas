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
import model.Cliente;
import model.Usuario;

/**
 *
 * @author jd754
 */
@WebServlet(name = "ControllerInicioUsuario", urlPatterns = {"/ControllerInicioUsuario"})
public class ControllerInicioUsuario extends HttpServlet {
    Usuario objUsuario = new Usuario();
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
        String accion = request.getParameter("btnAccion");
        
        try ( PrintWriter out = response.getWriter()) {
            //INGRESAR 
            if (accion.equals("Ingresar")) {
                String emailUsuario = request.getParameter("emailUsuario");
                String contrasenaUsuario = request.getParameter("contrasenaUsuario");
                objUsuario.setEmailUsuario(emailUsuario);
                objUsuario.setContrasenaUsuario(contrasenaUsuario);
                
                try {
                    ResultSet usuarioSet = objUsuario.login();
                    ArrayList<Usuario> lUsuario = new ArrayList<>(); 
                    int numUsuario = 0;
                    while(usuarioSet.next()){
                        Usuario objUsuario2 = new Usuario(); 
                        objUsuario2.setIdUsuario(usuarioSet.getInt(1));
                        objUsuario2.setNombreUsuario(usuarioSet.getString(2));
                        objUsuario2.setRolUsuario(usuarioSet.getString(3));
                        objUsuario2.setEmailUsuario(usuarioSet.getString(4));
                        objUsuario2.setContrasenaUsuario(usuarioSet.getString(5));
                        lUsuario.add(objUsuario2); 
                        numUsuario++; 
                    }
                    
                    if (numUsuario > 0) {
                             if(lUsuario.get(0).getRolUsuario().equals("Administrador")){
                                 String mensaje="<html> <body>"+
                                        "<script type='text/javascript'>"+
                                        "window.location.href='indexAdmi.jsp'; "+
                                        "</script> </body> </html>";
                                 out.println(mensaje);
                             }
                             else{
                                 String mensaje="<html> <body>"+
                                        "<script type='text/javascript'>"+
                                        "alert('BIENVENIDO COCINERO'); "+
                                        "window.location.href='indexCocinero.jsp'; "+
                                        "</script> </body> </html>";
                                out.println(mensaje);
                             }
                        }
                        else {
                            String mensaje="<html> <body>"+
                                        "<script type='text/javascript'>"+
                                        "alert('EMAIL O CONTRASEÑA INCORRECTOS'); "+
                                        "window.location.href='index.jsp'; "+
                                        "</script> </body> </html>";
                            out.println(mensaje);
                        }
                } catch (Exception error) {
                    System.out.println("Error controlador: "+error);
                }
                }
        
            }
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
