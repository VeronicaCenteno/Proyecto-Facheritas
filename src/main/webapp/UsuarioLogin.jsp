<%-- 
    Document   : UsuarioLogin
    Created on : 26/09/2022, 3:46:02 p. m.
    Author     : jd754
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="width    =device-width, initial-scale=1.0" name="viewport">
  
    <title>Facheritas - Inicio Sesión Usuario</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
  
    <!-- Favicons -->
    <link href="https://cdn-icons-png.flaticon.com/512/3518/3518672.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  
    <!-- Vendor CSS Files -->
    <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
      <link href="assets/css/styleRegistro.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<body>
  <header id="header" class="fixed-top d-flex align-items-cente">
  <div class="container-fluid container-xl d-flex align-items-center justify-content-lg-between">

    <h1 class="logo me-auto me-lg-0"><img src="assets/img/logo.jpeg"  width="200px" height="200px"  srcset=""></h1>
    <!-- Uncomment below if you prefer to use an image logo -->
    <!-- <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

    <nav id="navbar" class="navbar order-last order-lg-0">
            <ul>
                <li><a class="nav-link scrollto active" href="index.jsp"><h6>Inicio</h6></a></li>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
    </nav><!-- .navbar -->

  </div>
        </header><!-- End Header -->
        <br><br><br><br><br><br><br><br>

                <!-- ======= Menu Section ======= -->
    <section id="menu" class="menu section-bg">
   <form method="POST" action="ControllerInicioUsuario">
    <center>
        <div class="container">
          
                <div class="row input-container">
                      <div class="section-title">
                          
                <p> Inicio Sesión Usuario</p>
                </div>
                                <div class="col-xs-12">
                                <div class="styled-input wide">
                                <input type="text" name="emailUsuario" required />
                                <label>Email</label> 
                                </div>
                                </div>

                                <div class="col-xs-12">
                                <div class="styled-input wide">
                                <input type="password" name="contrasenaUsuario" required />
                                <label>Contraseña</label> 
                                </div>
                                </div>
                                <div class="col-xs-12">
                                    <button  class="btn-lrg submit-btn" type="submit" name="btnAccion" value="Ingresar" onclick="inicio()">Entrar</button>
                                </div>
                </div>
        </div> 	
            </center>
    </form>
                <br><br><br><br><br><br><br><br>

</section>
               
          <!-- End Menu Section -->
          <div class="container">
            <div class="copyright">
              &copy; Copyright <strong><span>Facheritas</span></strong>. All Rights Reserved
            </div>
            <div class="credits">
              <!-- All the links in the footer should remain intact. -->
              <!-- You can delete the links only if you purchased the pro version. -->
              <!-- Licensing information: https://bootstrapmade.com/license/ -->
              <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/restaurantly-restaurant-template/ -->
            </div>
          </div>
        </footer><!-- End Footer -->
      
        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
      
        <!-- Vendor JS Files -->
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>
      
        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    


</body>
<script src="assets/js/AlertaUsuario.js" type="text/javascript"></script>

</html>