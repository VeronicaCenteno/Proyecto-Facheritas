<%-- 
    Document   : index
    Created on : 5/09/2022, 5:05:55 p. m.
    Author     : jd754
--%>

<%@page import="model.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <!DOCTYPE html>
        <head>
            <meta charset="utf-8">
            <meta content="width=device-width, initial-scale=1.0" name="viewport">

            <title>Facheritas</title>
            <meta content="" name="description">
            <meta content="" name="keywords">

            <!-- Favicons -->
            <link href="../webapp/assets/img/hamburguesa.png" rel="icon">
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

            <!-- =======================================================
            * Template Name: Restaurantly - v3.8.0
            * Template URL: https://bootstrapmade.com/restaurantly-restaurant-template/
            * Author: BootstrapMade.com
            * License: https://bootstrapmade.com/license/
            ======================================================== -->
        </head>

        <body>

            <!-- ======= Top Bar ======= -->

            <!-- ======= Header ======= -->
            <header id="header" class="fixed-top d-flex align-items-cente">
                <div class="container-fluid container-xl d-flex align-items-center justify-content-lg-between">

                    <h1 class="logo me-auto me-lg-0"><img src="assets/img/facheritaslogo.png"  width="190px" height="200px"  srcset=""></h1>
                    <!-- Uncomment below if you prefer to use an image logo -->
                    <!-- <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

                    <nav id="navbar" class="navbar order-last order-lg-0">
                        <ul>
                            <li><a class="nav-link scrollto active" href="#hero">Inicio</a></li>
                            <li><a class="nav-link scrollto" href="#about">Nosotros</a></li>
                            <li><a class="nav-link scrollto" href="#contact">Contactanos</a></li>
                            <li><a class="nav-link scrollto" href="menu.jsp">Menú</a></li>
                            <li><a class="nav-link scrollto" href="UsuarioLogin.jsp">Inicio Sesión Usuario</a></li>
                            <li><a class="nav-link scrollto" ><img src="assets/img/carrito-de-compras (2).png" alt=""></a></li>
                        </ul>
                        <i class="bi bi-list mobile-nav-toggle"></i>
                    </nav><!-- .navbar -->

                </div>
            </header><!-- End Header -->

            <!-- ======= Hero Section ======= -->
            <section id="hero" class="d-flex align-items-center">
                <div class="container position-relative text-center text-lg-start" data-aos="zoom-in" data-aos-delay="100">
                    <div class="row">
                        <div class="col-lg-8">
                            <h1>FACHERITAS</h1>
                            <h2>Disfruta de nuestros deliciosos platos!</h2>

                            <div class="btns">
                            </div>
                        </div>
                    </div>
                </div>
            </section><!-- End Hero -->

            <main id="main">

                <!-- ======= About Section ======= -->
                <section id="about" class="about">
                    <div class="container" data-aos="fade-up">
                        <h1>Nosotros</h1>

                        <div class="row">
                            <div class="col-lg-6 order-1 order-lg-2" data-aos="zoom-in" data-aos-delay="100">
                                <div class="about-img">
                                    <img src="assets/img/about.jpg" alt="350px" width="500px" height="200px"> 
                                </div>
                            </div>
                            <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content">
                                <h3></h3>
                                <p class="fst-italic">
                                    Somos un negocio el cual se dedica a brindar un servicio de comidas con un toque
                                    diferente a los demás negocios, el cual nos caracterizamos por ofrecer un excelente
                                    servicio al cliente, en el cual ellos se sientan a gusto con la atención y las comidas.
                                </p>
                                <ul>
                                    <li><i class="bi bi-check-circle"></i> “Para nosotros es un placer atender a nuestros clientes ya que así nos esforzamos cada día
                                        más por mejorar en nuestro servicio.”.</li>
                            </div>
                        </div>

                    </div>
                </section><!-- End About Section -->

                <!-- ======= Why Us Section ======= -->
                <section id="why-us" class="why-us">
                    <div class="container" data-aos="fade-up">

                        <div class="section-title">
                            <h2>  </h2>
                            <p>
                                Por qué elegir nuestro restaurante</p>
                        </div>

                        <div class="row">

                            <div class="col-lg-4">
                                <div class="box" data-aos="zoom-in" data-aos-delay="100">
                                    <span>01</span>
                                    <p>Nos dedicamos a la preparación de comidas diferentes y deliciosas que permitan a nuestros comensales tener una experiencia de sabor deliciosa y a precios accesibles</p>
                                </div>
                            </div>

                            <div class="col-lg-4 mt-4 mt-lg-0">
                                <div class="box" data-aos="zoom-in" data-aos-delay="200">
                                    <span>02</span>
                                    <p>Tus comidas las puedes cambiar, combinar o armar como quieras.
                                        Todo lo que ofrecemos son productos frescos y preparados en el instante que los solicitan</p>
                                </div>
                            </div>

                            <div class="col-lg-4 mt-4 mt-lg-0">
                                <div class="box" data-aos="zoom-in" data-aos-delay="300">
                                    <span>03</span>
                                    <p>Nuestra prioridad es tener una buena calidad de atencion hacia nuestros clientes, brindarles comodidad </p>
                                </div>
                            </div>

                        </div>

                    </div>
                </section><!-- End Why Us Section -->

                <!-- ======= Specials Section ======= -->
                <section id="specials" class="specials">
                </section><!-- End Book A Table Section -->

                

                <!-- ======= Contact Section ======= -->
                <section id="contact" class="contact">
                    <div class="container" data-aos="fade-up">

                        <div class="section-title">
                            <h2>Contactanos</h2>
                            <p>Contactanos</p>
                        </div>
                    </div>

                    <div data-aos="fade-up">
                        <iframe style="border:0; width: 100%; height: 350px;" src="https://www.google.com/maps/embed?pb=!3m2!1ses-419!2sco!4v1660671858542!5m2!1ses-419!2sco!6m8!1m7!1sf80S-tQxQY5MnW0yDU3MKw!2m2!1d4.723977988404969!2d-74.08948016511776!3f263.7714920398215!4f1.0229585914130865!5f0.7820865974627469" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>



                    </div>
                </section><!-- End Contact Section -->

            </main><!-- End #main -->

            <!-- ======= Footer ======= -->


            <div class="container">
                <div class="copyright">
                    &copy; Copyright <strong><span>Restaurantly</span></strong>. All Rights Reserved
                </div>
                <div class="credits">
                    <!-- All the links in the footer should remain intact. -->
                    <!-- You can delete the links only if you purchased the pro version. -->
                    <!-- Licensing information: https://bootstrapmade.com/license/ -->
                    <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/restaurantly-restaurant-template/ -->
                    Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
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
        
        <% 
            double idPedido = Math.random()*(100000-1)+1;
            int idPedido2 = (int) idPedido;
            
            session.setAttribute("idPedido", idPedido2);
            
            Pedido objPedido = new Pedido();
            objPedido.setIdPedido(idPedido2);
            objPedido.setPrecioPedido(0);
            objPedido.setFechaPedido("1999-01-01");
            objPedido.setHoraPedido("00:00");
            objPedido.setEstadoPedido("Pendiente");
            objPedido.setSatisfaccionPedido("Pendiente");
            
            objPedido.insertarPedido();
        %>
    </body>

</html>
</body>
</html>
