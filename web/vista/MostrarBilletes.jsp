<%-- 
    Document   : index
    Created on : 19-ene-2016, 9:40:46
    Author     : Miriam
--%>
<%@page import="otros.QR"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Ocupacion> ocupaciones = (ArrayList) session.getAttribute("ocupaciones");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="icon" type="image/jpg" href="../images/iconoNavi.png" />
        <link rel="stylesheet" href="../css/style.css">
        <script src="../js/script.js"></script>
  
        <title>Navi´s Line</title>
    </head>
    <body>
        <div class="container-fluid">
            <header class="row hidden-print">
                <div class="col-md-3">
                    <br/>
                    <a href="../index.html" ><img src="../images/naviLogoHorizontal2-medio.png" alt="navi" class="img-responsive centrar img-rounded"></a>
                </div>
                <br/>
                <div class="col-md-2"></div>
                <div class="col-md-6"><h2 class="text-warning">Tarjetas de embarque</h2></div>
            </header>
          
            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-8">
                        <% for (int i = 0; i < ocupaciones.size(); i++) { 
                           
                        %>
                        
                        <div class="row">
                            <table class="table table-responsive table-condensed well">
                                <tbody>
                                    <tr style="background:#D5E1DD;">
                                        <td colspan="2" class="tabla-embarque" >
                                            <br/>

                                            <img src="../images/naviLogoHorizontal2-mini.png" alt="navi" class="img-responsive centrar img-rounded" width="100px">
                                        </td>
                                        <td colspan="4" class="tabla-embarque">
                                            <h3>Tarjeta de embarque</h3>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="tabla-embarque">
                                            <small><strong>Nombre:</strong></small> <br><% out.print(ocupaciones.get(i).getPasajero().getNombre());%> <% out.print(ocupaciones.get(i).getPasajero().getApellidos());%>
                                        </td>
                                        <td class="tabla-embarque">
                                            <small><strong>NIF: </strong></small> <br> <% out.print(ocupaciones.get(i).getPasajero().getNif());%>
                                        </td>
                                        
                                        <td colspan="3" rowspan="3" class="tabla-embarque "><img class="center-block" src="../images/QR/QR<%out.print(i);%>.png"</td>
                                    </tr>
                                    <tr>
                                        <td class="tabla-embarque">
                                            <small><stong>De:</stong></small> <br><% out.print(ocupaciones.get(i).getVuelo().getViaje().getOrigen().getCiudad());%>
                                        </td>
                                        <td class="tabla-embarque">
                                            <small><strong>A:</strong></small> <br><% out.print(ocupaciones.get(i).getVuelo().getViaje().getDestino().getCiudad());%>
                                        </td>
                                        <td class="tabla-embarque">
                                            <small><strong>Vuelo:</strong></small> <br><% out.print(ocupaciones.get(i).getVuelo().getNum_vuelo());%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tabla-embarque">
                                            <small><strong>Asiento: </strong></small> <br><% out.print(ocupaciones.get(i).getAsiento());%>
                                        </td>
                                        <td class="tabla-embarque">
                                            <small><strong>Fecha:</strong></small> <br><% out.print(ocupaciones.get(i).getVuelo().getFecha_salida());%>
                                        </td>
                                        <td class="tabla-embarque">
                                            <small><strong>Hora:</strong></small> <br><% out.print(ocupaciones.get(i).getVuelo().getHora_salida());%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="tabla-embarque">
                                            <p class="h4">Tarjeta de embarque </p>
                                        </td>
                                        <td colspan="2" class="tabla-embarque"></td>
                                        <td colspan="2" class="tabla-embarque">
                                            <span class="well pull-right margin-none">Ref Reserva <strong><% out.print(ocupaciones.get(i).getBookingCode());%></strong></span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>  
                        </div>
                        <% }%>
                        <br/>
                        <div class="panel-footer  hidden-print"><button type="button" class="btn btn-success" onclick="imprimirPagina()">Imprimir</button> <button type="button" class="btn btn-success" onclick="window.location = '../index.jsp'">Inicio</button>

                        </div>
                    </div>
                </div>
            </div>
         
            <script src="../js/jquery.js"></script>
            <script src="../js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="../css/jquery-ui.css">
            <link rel="stylesheet" href="../css/jquery-ui.structure.css">
            <link rel="stylesheet" href="../css/jquery-ui.theme.css">
            <script src="../js/jquery-ui.js"></script>
            <script>

            </script>
    </body>
</html>
