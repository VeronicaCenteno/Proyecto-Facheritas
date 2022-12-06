<%-- 
    Document   : factura
    Created on : 10/11/2022, 12:28:01 p. m.
    Author     : jd754
--%>

<%@page import="controller.ControllerConsultaPedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ConsultaPedido"%>

<!DOCTYPE html>
<html lang="en">
  <head>
      <link href="https://cdn-icons-png.flaticon.com/512/3884/3884774.png" rel="icon">
    <meta charset="utf-8">
    <title>Factura</title>
    <link href="assets/css/factura.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/boton.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
      <% 
            ArrayList<ConsultaPedido> listaConsultaPedidos = new ArrayList<>();
            ControllerConsultaPedido ctrConsultaPedido = new ControllerConsultaPedido();
            long idPedidoFk = Long.parseLong(request.getSession().getAttribute("idPedido").toString());
            listaConsultaPedidos = ctrConsultaPedido.consultaPedido(idPedidoFk);
            System.out.println(listaConsultaPedidos.get(0).getNombreCliente());
           
      %>
    <header class="clearfix">
      <div id="logo">
          <img src="assets/img/logo2.jpeg" alt=""/>
      </div>
      <div id="company">
        <h2 class="name">Facheritas</h2>
        <div>Carrera 91 bis #129-13</div>
        <div>+57 3176378583</div>
        <div><a href="">facheritasrincon@gmail.com</a></div>
      </div>
      </div>
    </header>
    <main>
      <div id="details" class="clearfix">
        <div id="client">
          <input type="hidden" name="idClienteFk" value="">
          <div class="">Datos del Cliente</div>
          <h2 class=""><%=listaConsultaPedidos.get(0).getNombreCliente()%></h2>
          <div class=""><%=listaConsultaPedidos.get(0).getTelefonoCliente()%></div>
          <div class=""><%=listaConsultaPedidos.get(0).getEmailCliente()%></div>
        </div>
        <div id="invoice">
            <h1></h1>
            <div class=""><%=listaConsultaPedidos.get(0).getIdPedidoFk()%></div>
            <div class=""><%=listaConsultaPedidos.get(0).getFechaPedido()%></div>
            <div class=""><%=listaConsultaPedidos.get(0).getHoraPedido()%></div>
        </div>
      </div>
        <center>
      <table border="0" cellspacing="0" cellpadding="0">
        <thead>
          <tr>
            <th class="desc">Producto</th>
            <th class="qty">Cantidad</th>
            <th class="total">Total</th>
          </tr>
        </thead>
        <tbody>
            <%for(int i=0; i<listaConsultaPedidos.size();i++){ %> 
          <tr>
              <td class=""><%=listaConsultaPedidos.get(i).getNombreProducto()%> <br>
                  <%=listaConsultaPedidos.get(i).getCategoriaProducto()%><br>
                  <%=listaConsultaPedidos.get(i).getDescripcionProducto()%>
              </td>
              <%
                    int cantidad = 0;  
                    cantidad = (int) listaConsultaPedidos.get(i).getCantidad();
                    
                    int precio = 0;
                    precio = Integer.parseInt(listaConsultaPedidos.get(i).getPrecioProducto());
                    
                    int resultado = 0;
                    resultado = cantidad*precio;
            %>
            <td class="">
                <%=cantidad+""%>
            <td class="">
               <%=resultado+""%>
            </td>
          </tr>
          <% } %>        
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2"></td>
            <td colspan="2">Total</td>
            <td><%=listaConsultaPedidos.get(0).getPrecioPedido()%></td>
            </tr>
            </tfoot>
        </table>
      </center>
    </main>
  </body>
</html>