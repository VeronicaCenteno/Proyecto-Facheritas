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
    <link href="assets/vendor/swiper/swiper-bundle" >  
    <link href="assets/css/style.css" rel="stylesheet">
  
    <!-- Template Main CSS File -->
      <link href="assets/css/styleRegistro.css" rel="stylesheet" type="text/css"/>
      <link href="assets/css/style.css" rel="stylesheet">
      <link href="assets/css/boton.css" rel="stylesheet" type="text/css"/>
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
            
                <a class="nav-link scrollto active" href="index.jsp"><h6>Inicio</h6></a>
                
                <%
                    int carrito= 0;
                    ControllerPedido_Producto ctrCarrito = new ControllerPedido_Producto();
                    long idPedidoFk = Long.parseLong(request.getSession().getAttribute("idPedido").toString());
                    carrito = ctrCarrito.consultarPedidoProducto(idPedidoFk);
                %>
                
               <a class="nav-link scrollto" href="loginCliente.jsp"><img src="assets/img/carrito-de-compras (2).png"> <%=carrito+""%> </a>
                            
            <i class="bi bi-list mobile-nav-toggle"></i>
    </nav><!-- .navbar -->

  </div>
        </header><!-- End Header -->
        <br><br><br><br><br><br><br><br>
        
        <!-- ======= Menu Section ======= -->
    <section id="menu" class="menu">
      <div class="container">

        <div class="section-title">
          <h2>Nuestro <span>Menu</span></h2>
        </div>

        <div class="row">
          <div class="col-lg-12 d-flex justify-content-center">
            <ul id="menu-flters">
              <li data-filter=".filter-Adiciones">Adiciones</li>
              <li data-filter=".filter-Antojitos">Antojitos</li>
              <li data-filter=".filter-BebidasC">Bebidas Calientes</li>
              <li data-filter=".filter-BebidasF">Bebidas Familiares</li>  
              <li data-filter=".filter-BebidasP">Bebidas Personales</li>
              <li data-filter=".filter-Cervezas">Cervezas</li>
              <li data-filter=".filter-Frappes">Frappes</li>
              <li data-filter=".filter-Hamburguesas">Hamburguesas</li>
              <li data-filter=".filter-Mazorcadas">Mazorcadas</li>
              <li data-filter=".filter-OtrosP">Otros Platos</li>
              <a href="menu_1.jsp">Siguiente Menu</a>
            </ul>
          </div>
        </div>
          
        <div class="row menu-container">
           <div class=" menu-item filter-Adiciones">
            <div class="menu-content">
              <table >
                <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th >Descripcion</th>
                    <th>Añadir</th>
                </tr>
                <%
                    ArrayList<Producto> listaAdiciones = new ArrayList<>();
                    ControllerProducto ctrProductosAdi = new ControllerProducto();
                    listaAdiciones = ctrProductosAdi.consultarAdiciones();

                    for(int i=0; i<listaAdiciones.size();i++){
                %>
                <tr>
                    <td><%=listaAdiciones.get(i).getNombreProducto()%></td>
                    <td><%=listaAdiciones.get(i).getPrecioProducto()%></td>    
                    <td><%=listaAdiciones.get(i).getDescripcionProducto()%></td>
                    <td>
                    <form method="GET|" action="ControllerPedido_Producto">
                        <input type="hidden" name="idProducto" value="<%=listaAdiciones.get(i).getIdProducto()%>">
                        <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                        <button class="btn-lrg submit-btn"  onclick="insertar()" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                    </form>
                    </td>
                </tr>
                <% } %>
                </table>
            </div>
          </div>  
           
          <div class=" menu-item filter-Antojitos">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th> 
                    <th>Añadir</th>
                </tr>
                <%
                    ArrayList<Producto> listaAntojitos = new ArrayList<>();
                    ControllerProducto ctrProductosAn = new ControllerProducto();
                    listaAntojitos = ctrProductosAn.consultarAntojitos();

                    for(int i=0; i<listaAntojitos.size();i++){
                %>
                <tr>
                    <td><%=listaAntojitos.get(i).getNombreProducto()%></td>
                    <td><%=listaAntojitos.get(i).getPrecioProducto()%></td>    
                    <td><%=listaAntojitos.get(i).getDescripcionProducto()%></td>
                    <td>
                    <form method="GET" action="ControllerPedido_Producto">
                        <input type="hidden" name="idProducto" value="<%=listaAntojitos.get(i).getIdProducto()%>">
                        <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                        <button class="btn-lrg submit-btn" onclick="insertar()" type="submit" name="btnAccion" value="Insertar">Insertar</button>
                    </form>
                    </td>
                </tr>
                <% } %>
                </table>
            </div>
          </div>  
                

            <div class=" menu-item filter-Hamburguesas">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaHamburguesas = new ArrayList<>();
                    ControllerProducto ctrProductos = new ControllerProducto();
                    listaHamburguesas = ctrProductos.consultarHamburguesas();

                    for(int i=0; i<listaHamburguesas.size();i++){
                %>
                <tr>
                    <td><%=listaHamburguesas.get(i).getNombreProducto()%></td>
                    <td><%=listaHamburguesas.get(i).getPrecioProducto()%></td>    
                    <td><%=listaHamburguesas.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaHamburguesas.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()" >Insertar</button>
                        </form>
                    </td>
                    </tr>
                <% } %>
            </table>
          </div>
          </div>  
        
                      <div class=" menu-item filter-BebidasC">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaBebidasC = new ArrayList<>();
                    ControllerProducto ctrProductosBebidasC = new ControllerProducto();
                    listaBebidasC = ctrProductosBebidasC.consultarBebidasC();

                    for(int i=0; i<listaBebidasC.size();i++){
                %>
                <tr>
                    <td><%=listaBebidasC.get(i).getNombreProducto()%></td>
                    <td><%=listaBebidasC.get(i).getPrecioProducto()%></td>    
                    <td><%=listaBebidasC.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaBebidasC.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()" >Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>
        
                
           <div class=" menu-item filter-BebidasF">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaBebidasF = new ArrayList<>();
                    ControllerProducto ctrProductosBebidasF = new ControllerProducto();
                    listaBebidasF = ctrProductosBebidasF.consultarBebidasF();

                    for(int i=0; i<listaBebidasC.size();i++){
                %>
                <tr>
                    <td><%=listaBebidasF.get(i).getNombreProducto()%></td>
                    <td><%=listaBebidasF.get(i).getPrecioProducto()%></td>    
                    <td><%=listaBebidasF.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaBebidasF.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>
        
           <div class=" menu-item filter-BebidasP">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaBebidasP = new ArrayList<>();
                    ControllerProducto ctrProductosBebidasP = new ControllerProducto();
                    listaBebidasP = ctrProductosBebidasP.consultarBebidasP();

                    for(int i=0; i<listaBebidasC.size();i++){
                %>
                <tr>
                    <td><%=listaBebidasP.get(i).getNombreProducto()%></td>
                    <td><%=listaBebidasP.get(i).getPrecioProducto()%></td>    
                    <td><%=listaBebidasP.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaBebidasP.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()">Insertar</button>
                        </form>
                    </td>0
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
            
           <div class=" menu-item filter-Cervezas">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaCervezas = new ArrayList<>();
                    ControllerProducto ctrProductosCervezas = new ControllerProducto();
                    listaCervezas = ctrProductosCervezas.consultarCervezas();

                    for(int i=0; i<listaCervezas.size();i++){
                %>
                <tr>
                    <td><%=listaCervezas.get(i).getNombreProducto()%></td>
                    <td><%=listaCervezas.get(i).getPrecioProducto()%></td>    
                    <td><%=listaCervezas.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaCervezas.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
            
           <div class=" menu-item filter-Frappes">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaFrappes = new ArrayList<>();
                    ControllerProducto ctrProductosFrappes = new ControllerProducto();
                    listaFrappes = ctrProductosFrappes.consultarFrappes();

                    for(int i=0; i<listaFrappes.size();i++){
                %>
                <tr>
                    <td><%=listaFrappes.get(i).getNombreProducto()%></td>
                    <td><%=listaFrappes.get(i).getPrecioProducto()%></td>    
                    <td><%=listaFrappes.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaFrappes.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
        
           <div class=" menu-item filter-Mazorcadas">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaMazorcadas = new ArrayList<>();
                    ControllerProducto ctrProductosMazorcadas = new ControllerProducto();
                    listaMazorcadas = ctrProductosMazorcadas.consultarMazorcadas();

                    for(int i=0; i<listaMazorcadas.size();i++){
                %>
                <tr>
                    <td><%=listaMazorcadas.get(i).getNombreProducto()%></td>
                    <td><%=listaMazorcadas.get(i).getPrecioProducto()%></td>    
                    <td><%=listaMazorcadas.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaMazorcadas.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
        
           <div class=" menu-item filter-OtrosP">
            <div class="menu-content">
              <table class="rwd-table" style="border-style: solid; border-color: white" >
                <tr>

                    <th>Nombre</th>
                    <th>Precio</th>
                    <th style="width: 300px;">Descripcion</th>
                    <th>Añadir</th>

                </tr>
                <%
                    ArrayList<Producto> listaOtrosP = new ArrayList<>();
                    ControllerProducto ctrProductosOtrosP = new ControllerProducto();
                    listaOtrosP = ctrProductosOtrosP.consultarOtrosP();

                    for(int i=0; i<listaOtrosP.size();i++){
                %>
                <tr>
                    <td><%=listaOtrosP.get(i).getNombreProducto()%></td>
                    <td><%=listaOtrosP.get(i).getPrecioProducto()%></td>    
                    <td><%=listaOtrosP.get(i).getDescripcionProducto()%></td>
                    <td>
                        <form method="GET" action="ControllerPedido_Producto">
                            <input type="hidden" name="idProducto" value="<%=listaOtrosP.get(i).getIdProducto()%>">
                            <input type="number" name="cantidad" style="height: 20px; width: 150px;">
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()">Insertar</button>
                        </form>
                    </td>
                    </tr>
        <% } %>
        </table>
            </div>
          </div>  
        
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
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()">Insertar</button>
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
                    <th>Añadir</th>

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
                            <button class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Insertar" onclick="insertar()">Insertar</button>
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
<script src="assets/js/AlertaUsuario.js" type="text/javascript">
    </script><script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="sweetalert2.all.min.js"></script>
<script src="sweetalert2.min.js"></script>



</html>