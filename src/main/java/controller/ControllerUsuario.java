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
import model.Usuario;

/**
 *
 * @author jd754
 */
@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {
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
        String accion = request.getParameter("btnAccion");
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //INSERTAR
            if(accion.equals("Insertar")){
                String nombreUsuario = request.getParameter("nombreUsuario");
                String rolUsuario = request.getParameter("rolUsuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String contrasenaUsuario = request.getParameter("contrasenaUsuario");
                objUsuario.setNombreUsuario(nombreUsuario);
                objUsuario.setRolUsuario(rolUsuario);
                objUsuario.setEmailUsuario(emailUsuario);
                objUsuario.setContrasenaUsuario(contrasenaUsuario);               
                
                try {
                    ResultSet usuarioSet = objUsuario.consultarCorreo();
                    int numUsuario = 0;
                    while(usuarioSet.next()){
                        numUsuario++;
                    }
                    if (numUsuario > 0) {
                        String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('ESTE CORREO YA HA SIDO REGISTRADO'); "+
                                    "window.location.href='views/usuario/registroUsuario.jsp'; "+
                                    "</script> </body> </html>";
                        out.println(mensaje);
                    }
                    else {
                        objUsuario.insertarUsuario();

                        String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('USUARIO INSERTADO CORRECTAMENTE!!!'); "+
                                    "window.location.href='views/usuario/listarUsuario.jsp'; "+
                                    "</script> </body> </html>";
                        out.println(mensaje);
                    }
                    
                    
                } catch (Exception error) {
                    System.out.println("Error controlador: "+error);
                }
            }
            
            //ACTUALIZAR
            else if(accion.equals("Actualizar")){
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                String nombreUsuario = request.getParameter("nombreUsuario");
                String rolUsuario = request.getParameter("rolUsuario");
                String emailUsuario = request.getParameter("emailUsuario");
                String contrasenaUsuario = request.getParameter("contrasenaUsuario");
                
                objUsuario.setIdUsuario(idUsuario);
                objUsuario.setNombreUsuario(nombreUsuario);
                objUsuario.setRolUsuario(rolUsuario);
                objUsuario.setEmailUsuario(emailUsuario);
                objUsuario.setContrasenaUsuario(contrasenaUsuario);
                
                objUsuario.actualizarUsuario();
                
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "alert('USUARIO ACTUALIZADO CORRECTAMENTE!!!'); "+
                                "window.location.href='views/usuario/listarUsuario.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
            }
            
            //ELIMINAR
            else if(accion.equals("Eliminar")){
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                objUsuario.setIdUsuario(idUsuario);
                
                objUsuario.eliminarUsuario();
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "alert('USUARIO ELIMINADO CORRECTAMENTE!!!'); "+
                                "window.location.href='views/usuario/listarUsuario.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
            }
            
    
            
        }
    }
    
    public ArrayList listar(){
        try{
            ResultSet consulta = objUsuario.listarUsuarios();
            ArrayList <Usuario> listaUsuarios = new ArrayList<>();
            
            while(consulta.next()){
                objUsuario = new Usuario();
                objUsuario.setIdUsuario(consulta.getInt(1));
                objUsuario.setNombreUsuario(consulta.getString(2));
                objUsuario.setRolUsuario(consulta.getString(3));
                objUsuario.setEmailUsuario(consulta.getString(4));
                objUsuario.setContrasenaUsuario(consulta.getString(5));
                listaUsuarios.add(objUsuario);
            }
            return listaUsuarios;
        }
        catch(Exception error){
            System.out.println("ERROR: "+error);
        }
        return null;
    }
    
    //CONSULTAR POR ID
    public ArrayList consultarxIdUsuario(int idUsuario){
        try{
            objUsuario.setIdUsuario(idUsuario);
            ResultSet consulta = objUsuario.consultarUsuario();
            ArrayList<Usuario> listaUsuario = new ArrayList<>();
            while(consulta.next()){
                objUsuario = new Usuario();
                objUsuario.setIdUsuario(consulta.getInt(1));
                objUsuario.setNombreUsuario(consulta.getString(2));
                objUsuario.setRolUsuario(consulta.getString(3));
                objUsuario.setEmailUsuario(consulta.getString(4));
                objUsuario.setContrasenaUsuario(consulta.getString(5));
                listaUsuario.add(objUsuario);
        }
            return listaUsuario;
    }
        catch (Exception error){
            System.out.println("ERROR" +error);
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
