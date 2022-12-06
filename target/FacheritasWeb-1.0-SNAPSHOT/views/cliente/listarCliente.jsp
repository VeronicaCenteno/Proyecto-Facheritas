<%-- 
    Document   : listarCliente
    Created on : 5/09/2022, 6:23:31 p. m.
    Author     : jd754
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cliente"%>
<%@page import="controller.ControllerClient"%>

<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
  
    <title>Consultar Cliente</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
  
    <!-- Favicons -->
    <link href="https://cdn-icons-png.flaticon.com/512/4149/4149882.png" rel="icon">
    <link href="../../assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  
    <!-- Vendor CSS Files -->
    <link href="../../assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="../../assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="../../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="../../assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="../../assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="../../assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  
    <!-- Template Main CSS File -->
      <link href="../../assets/css/styleRegistro.css" rel="stylesheet" type="text/css"/>

    <link href="../../assets/css/style.css" rel="stylesheet">
</head>
    <body>
        <header id="header" class="fixed-top d-flex align-items-cente">
      <div class="container-fluid container-xl d-flex align-items-center justify-content-lg-between">

        <h1 class="logo me-auto me-lg-0"><img src="../../assets/img/logo.jpeg"  width="200px" height="200px"  srcset=""></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

        <nav id="navbar" class="navbar order-last order-lg-0">
          <ul>
              <li><a class="nav-link scrollto active" href="../../indexUsu.jsp"><h6>Inicio</h6></a></li>
          </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->

      </div>
    </header><!-- End Header -->
    <br><br><br><br><br><br><br><br>
    <center>
<div class="section-title">
                     <br><br>   
                <p>Consultar Cliente  </p>
                </div>        <br> 
        <table class="rwd-table">
        <tr>
            <th>Nombre</th>
            <th>Telefono</th>
        </tr>
        <%
            ArrayList<Cliente> listaCliente = new ArrayList<>();
            ControllerClient ctrClientes = new ControllerClient();
            listaCliente = ctrClientes.listar();
            
            for(int i=0; i<listaCliente.size();i++){
        %>
        <tr>
        <td><%=listaCliente.get(i).getNombreCliente()%></td>
        <td><%=listaCliente.get(i).getTelefonoCliente()%></td> 
        
        </tr>
        <% } %>
        </table>
        </center>
    </body>
</html>
