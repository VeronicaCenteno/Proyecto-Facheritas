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

/**
 *
 * @author jd754
 */
@WebServlet(name = "ControllerClient", urlPatterns = {"/ControllerClient"})
public class ControllerClient extends HttpServlet {
    Cliente objCliente = new Cliente();
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
                String nombreCliente = request.getParameter("nombreCliente");
                String emailCliente = request.getParameter("emailCliente");
                String telefonoCliente = request.getParameter("telefonoCliente");
                String contrasenaCliente = request.getParameter("contrasenaCliente");
                objCliente.setNombreCliente(nombreCliente);
                objCliente.setEmailCliente(emailCliente);
                objCliente.setTelefonoCliente(telefonoCliente);
                objCliente.setContrasenaCliente(contrasenaCliente);
                
                try {
                    ResultSet clienteSet = objCliente.consultarCorreo();
                    int numCliente = 0;
                    while(clienteSet.next()){
                        numCliente++;
                    }
                    if (numCliente > 0) {
                        String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('ESTE CORREO YA HA SIDO REGISTRADO'); "+
                                    "window.location.href='views/cliente/registroCliente.jsp'; "+
                                    "</script> </body> </html>";
                        out.println(mensaje);
                    }
                    else {
                        objCliente.insertarCliente();

                        String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('CLIENTE INSERTADO CORRECTAMENTE!!!'); "+
                                    "window.location.href='index.jsp'; "+
                                    "</script> </body> </html>";
                        out.println(mensaje);
                    }
                    
                    
                } catch (Exception error) {
                    System.out.println("Error controlador: "+error);
                }
                
            }
            
            //ACTUALIZAR
            else if(accion.equals("Actualizar")){
                int idCliente = Integer.parseInt(request.getParameter("idCliente")); 
                String nombreCliente = request.getParameter("nombreCliente");
                String emailCliente = request.getParameter("emailCliente");
                String telefonoCliente = request.getParameter("telefonoCliente");
                String contrasenaCliente = request.getParameter("contrasenaCliente"); 
                objCliente.setIdCliente(idCliente);
                objCliente.setNombreCliente(nombreCliente);
                objCliente.setEmailCliente(emailCliente);
                objCliente.setTelefonoCliente(telefonoCliente);
                objCliente.setContrasenaCliente(contrasenaCliente);
                
                objCliente.actualizarCliente();
               
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "alert('CLIENTE ACTUALIZADO CORRECTAMENTE!!!'); "+
                                "window.location.href='views/cliente/listarCliente.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
                
            }
            
            //ELIMINAR
            else if(accion.equals("Eliminar")){
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                objCliente.setIdCliente(idCliente);
                
                objCliente.eliminarCliente();
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "alert('CLIENTE ELIMINADO CORRECTAMENTE!!!'); "+
                                "window.location.href='views/cliente/listarCliente.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
            }
        }
    }
    
    public ArrayList listar(){
        try{
            ResultSet consulta = objCliente.listarClientes();
            ArrayList <Cliente> listaClientes = new ArrayList<>();
            
            while(consulta.next()){
                objCliente = new Cliente();
                objCliente.setIdCliente(consulta.getInt(1));
                objCliente.setNombreCliente(consulta.getString(2));
                objCliente.setEmailCliente(consulta.getString(3));
                objCliente.setTelefonoCliente(consulta.getString(4));
                objCliente.setContrasenaCliente(consulta.getString(5));
                listaClientes.add(objCliente);
            }
            return listaClientes;
        }
        catch(Exception error){
            System.out.println("ERROR: "+error);
        }
        return null;
    }
    
    //CONSULTAR POR ID
    public ArrayList consultarxIdCliente(int idCliente){
        try{
            
            ResultSet consulta = objCliente.consultarCliente();
            ArrayList<Cliente> listaCliente = new ArrayList<>();
            while(consulta.next()){
                objCliente = new Cliente();
                objCliente.setIdCliente(consulta.getInt(1));
                objCliente.setNombreCliente(consulta.getString(2));
                objCliente.setEmailCliente(consulta.getString(3));
                objCliente.setTelefonoCliente(consulta.getString(4));
                objCliente.setContrasenaCliente(consulta.getString(5));
                listaCliente.add(objCliente);
        }
            return listaCliente;
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
