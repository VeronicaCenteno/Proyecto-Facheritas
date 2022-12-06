<%-- 
    Document   : menu2
    Created on : 1/11/2022, 3:54:30 p. m.
    Author     : jd754
--%>

<%@page import="controller.ControllerPedido_Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Producto"%>
<%@page import="controller.ControllerProducto"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Vendor CSS Files -->
        <link href="https://cdn-icons-png.flaticon.com/512/1046/1046747.png" rel="icon">
    <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  
    <!-- Template Main CSS File -->
      <link href="assets/css/styleRegistro.css" rel="stylesheet" type="text/css"/>

    <link href="assets/css/style.css" rel="stylesheet">
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Menu</title>
  <meta content="" name="description">
  <meta content="" name="keywords">



  <!-- =======================================================
  * Template Name: Delicious - v4.9.1
  * Template URL: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>
    <header id="header" class="fixed-top d-flex align-items-cente">
  <div class="container-fluid container-xl d-flex align-items-center justify-content-lg-between">

    <h1 class="logo me-auto me-lg-0"><img src="assets/img/logo.jpeg"  width="200px" height="200px"  srcset=""></h1>
    <!-- Uncomment below if you prefer to use an image logo -->
    <!-- <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

    <nav id="navbar" class="navbar order-last order-lg-0">
            <ul>
               <a class="nav-link scrollto active" href="index.jsp"><h6>Inicio</h6></a>
                
                <%
                    int carrito= 0;
                    ControllerPedido_Producto ctrCarrito = new ControllerPedido_Producto();
                    long idPedidoFk = Long.parseLong(request.getSession().getAttribute("idPedido").toString());
                    carrito = ctrCarrito.consultarPedidoProducto(idPedidoFk);
                %>
                
                <a class="nav-link scrollto" href="loginCliente.jsp"><img src="assets/img/carrito-de-compras (2).png"> <%=carrito+""%> </a>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
    </nav><!-- .navbar -->

  </div>
        </header><!-- End Header -->
        <br><br><br><br><br><br><br><br>

                <!-- ======= Menu Section ======= -->
  
    <!-- ======= Menu Section ======= -->
    <section id="menu" class="menu">
      <div class="container">

        <div class="section-title">
          <h2>Nuestro  <span>Menu</span></h2>
        </div>
          
        <div class="row">
          <div class="col-lg-12 d-flex justify-content-center">
            <ul id="menu-flters">
              <li data-filter=".filter-PerrosC">Perros Calientes</li>
              <li data-filter=".filter-Rollitos">Rollitos</li>
              <li data-filter=".filter-Salchipapas">Salchipapas</li>
              <li data-filter=".filter-Sanduches">Sanduches</li>  
              <li data-filter=".filter-SmottiesA">Smotties en Agua</li>
              <li data-filter=".filter-SmottiesL">Smotties en Leche</li>
              <li data-filter=".filter-Toppings">Toppings</li>
              <li data-filter=".filter-WaflesD">Wafles de Dulce</li>
              <li data-filter=".filter-WaflesS">Wafles de Sal</li>
              <li><a href="menu.jsp">Anterior Menú</a></li>
            </ul>
          </div>
        </div>
          
          
        <div class="row menu-container">
           <div class=" menu-item filter-PerrosC">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th> 
                    <th>Añadir</th>
                </tr>
                <%
                    ArrayList<Producto> listaPerrosC = new ArrayList<>();
                    ControllerProducto ctrProductosPerrosC = new ControllerProducto();
                    listaPerrosC = ctrProductosPerrosC.consultarPerrosC();

                    for(int i=0; i<listaPerrosC.size();i++){
                %>
                <tr>
                    <td><%=listaPerrosC.get(i).getNombreProducto()%></td>
                    <td><%=listaPerrosC.get(i).getPrecioProducto()%></td>    
                    <td><%=listaPerrosC.get(i).getDescripcionProducto()%></td>
                    <td>
                    <form method="GET" action="ControllerPedido_Producto">
                        <input type="hidden" name="idProducto" value="<%=listaPerrosC.get(i).getIdProducto()%>">
                        <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                        <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                    </form>
                    </td>
                </tr>
                <% } %>
                </table>
            </div>
          </div>  
           
          <div class=" menu-item filter-Rollitos">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir </th>
                </tr>
                <%
                    ArrayList<Producto> listaRollitos = new ArrayList<>();
                    ControllerProducto ctrProductosRollitos = new ControllerProducto();
                    listaRollitos = ctrProductosRollitos.consultarRollitos();

                    for(int i=0; i<listaRollitos.size();i++){
                %>
                <tr>
                    <td><%=listaRollitos.get(i).getNombreProducto()%></td>
                    <td><%=listaRollitos.get(i).getPrecioProducto()%></td>    
                    <td><%=listaRollitos.get(i).getDescripcionProducto()%></td>
                    <td>
                    <form method="GET" action="ControllerPedido_Producto">
                        <input type="hidden" name="idProducto" value="<%=listaRollitos.get(i).getIdProducto()%>">
                        <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                        <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                    </form>
                    </td>
                </tr>
                <% } %>
                </table>
            </div>
          </div>  
          
           <div class=" menu-item filter-Salchipapas">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaSalchipapas = new ArrayList<>();
                    ControllerProducto ctrProductosSalchipapas = new ControllerProducto();
                    listaSalchipapas = ctrProductosSalchipapas.consultarSalchipapas();

                    for(int i=0; i<listaSalchipapas.size();i++){
                %>
                <tr>
                    <td><%=listaSalchipapas.get(i).getNombreProducto()%></td>
                    <td><%=listaSalchipapas.get(i).getPrecioProducto()%></td>    
                    <td><%=listaSalchipapas.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaSalchipapas.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
        
           <div class=" menu-item filter-Sanduches">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaSanduches = new ArrayList<>();
                    ControllerProducto ctrProductosSanduches = new ControllerProducto();
                    listaSanduches = ctrProductosSanduches.consultarSanduches();

                    for(int i=0; i<listaSanduches.size();i++){
                %>
                <tr>
                    <td><%=listaSanduches.get(i).getNombreProducto()%></td>
                    <td><%=listaSanduches.get(i).getPrecioProducto()%></td>    
                    <td><%=listaSanduches.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaSanduches.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
                
           <div class=" menu-item filter-SmottiesA">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaSmotiiesA = new ArrayList<>();
                    ControllerProducto ctrProductosSmottiesA = new ControllerProducto();
                    listaSmotiiesA = ctrProductosSmottiesA.consultarSmottiesAgua();

                    for(int i=0; i<listaSmotiiesA.size();i++){
                %>
                <tr>
                    <td><%=listaSmotiiesA.get(i).getNombreProducto()%></td>
                    <td><%=listaSmotiiesA.get(i).getPrecioProducto()%></td>    
                    <td><%=listaSmotiiesA.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaSmotiiesA.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
        
           <div class=" menu-item filter-SmottiesL">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaSmottiesL = new ArrayList<>();
                    ControllerProducto ctrProductosSmottiesL = new ControllerProducto();
                    listaSmottiesL = ctrProductosSmottiesL.consultarSmottiesLeche();

                    for(int i=0; i<listaSmottiesL.size();i++){
                %>
                <tr>
                    <td><%=listaSmottiesL.get(i).getNombreProducto()%></td>
                    <td><%=listaSmottiesL.get(i).getPrecioProducto()%></td>    
                    <td><%=listaSmottiesL.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaSmottiesL.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
            
           <div class=" menu-item filter-Toppings">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaToppings = new ArrayList<>();
                    ControllerProducto ctrProductosToppings = new ControllerProducto();
                    listaToppings = ctrProductosToppings.consultarToppings();

                    for(int i=0; i<listaToppings.size();i++){
                %>
                <tr>
                    <td><%=listaToppings.get(i).getNombreProducto()%></td>
                    <td><%=listaToppings.get(i).getPrecioProducto()%></td>    
                    <td><%=listaToppings.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaToppings.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
            
           <div class=" menu-item filter-WaflesD">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaWaflesD = new ArrayList<>();
                    ControllerProducto ctrProductosWaflesD = new ControllerProducto();
                    listaWaflesD = ctrProductosWaflesD.consultarWaflesD();

                    for(int i=0; i<listaWaflesD.size();i++){
                %>
                <tr>
                    <td><%=listaWaflesD.get(i).getNombreProducto()%></td>
                    <td><%=listaWaflesD.get(i).getPrecioProducto()%></td>    
                    <td><%=listaWaflesD.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaWaflesD.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
        
           <div class=" menu-item filter-WaflesS">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaWaflesS = new ArrayList<>();
                    ControllerProducto ctrProductosWaflesS = new ControllerProducto();
                    listaWaflesS = ctrProductosWaflesS.consultarWaflesS();

                    for(int i=0; i<listaWaflesS.size();i++){
                %>
                <tr>
                    <td><%=listaWaflesS.get(i).getNombreProducto()%></td>
                    <td><%=listaWaflesS.get(i).getPrecioProducto()%></td>    
                    <td><%=listaWaflesS.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaWaflesS.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
        
        
        </div>
      </div>
    </section>
    <!-- End Menu Section -->
    

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="asset/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="asset/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="asset/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="asset/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="asset/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="asset/js/main1.js"></script>
</body>
</html>