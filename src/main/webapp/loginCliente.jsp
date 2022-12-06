<%-- 
    Document   : login1
    Created on : 1/11/2022, 7:24:36 a. m.
    Author     : jd754
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio Sesión-Registro</title>
    <link href="assets/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <script  src="https://code.jquery.com/jquery-3.1.1.min.js"  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="  crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" ></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<div class="body">
		<div class="veen">
			<div class="login-btn splits">
				<p>Ya cuentas con tu Usuario?</p>
				<button class="active">Iniciar Sesión</button>
			</div>
			<div class="rgstr-btn splits">
				<p>No cuentas con tu Usuario?</p>
				<button>Registrate</button>
			</div>
			<div class="wrapper">
                            
                            <!-- LOGIN -->
                            <form method="POST" action="ControllerInicioClient">
					<h3>Iniciar Sesión</h3>
					<div class="mail">
                                            <input type="text" name="emailCliente" required="">
						<label>Email</label>
					</div>
					<div class="passwd">
                                            <input type="password" name="contrasenaCliente" required="">
						<label>Contraseña</label>
					</div>
					<div class="submit">
                                            <button class="dark" type="submit" name="btnAccion" value="Ingresar">Ingresar</button>
					</div>
				</form>
                            
                            <!-- FORMULARIO REGISTRO -->
                            
                            <form id="register" tabindex="502" method="POST" action="ControllerClient">
					<h3>Registrate</h3>
					<div class="name">
                                            <input type="text" name="nombreCliente" required="">
						<label>Nombre</label>
					</div>
					<div class="mail">
                                            <input type="text" name="emailCliente" required="">
						<label>Email</label>
					</div>
					<div class="uid">
                                            <input type="number" name="telefonoCliente" required="">
						<label>Telefono</label>
					</div>
					<div class="passwd">
						<input type="password" name="contrasenaCliente">
						<label>Contraseña</label>
					</div>
					<div class="submit">
                                            <button class="dark" type="submit" name="btnAccion" value="Insertar">Registrarme</button>
					</div>
				</form>
			</div>
		</div>	
	</div>


	<style type="text/css">
		.site-link{
      padding: 5px 15px;
			position: fixed;
			z-index: 99999;
			background: #fff;
			box-shadow: 0 0 4px rgba(0,0,0,.14), 0 4px 8px rgba(0,0,0,.28);
			right: 30px;
			bottom: 30px;
			border-radius: 10px;
		}
		.site-link img{
			width: 30px;
			height: 30px;
		}
	</style>
        <script src="assets/js/login1.js" type="text/javascript"></script>
</body>
</html>