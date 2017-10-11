<%-- 
    Document   : index
    Created on : 19-ene-2016, 9:40:46
    Author     : Miriam
--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cliente user = (Cliente) session.getAttribute("cliente");
    ArrayList ocupaciones = (ArrayList) session.getAttribute("ocupaciones");
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
            <header class="row">
                <div class="col-md-3">
                    <a href="../index.jsp" ><img src="../images/naviLogoHorizontal2-medio.png" alt="navi" class="img-responsive centrar img-rounded"></a>
                </div>
                <div class="col-md-9">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                            <li data-target="#myCarousel" data-slide-to="3"></li>
                        </ol>
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <div id="cont_39a6238c3e6e86a90fc698469b7b84dd"><span id="h_39a6238c3e6e86a90fc698469b7b84dd"><a id="a_39a6238c3e6e86a90fc698469b7b84dd" href="http://www.tiempo.com/madrid.htm" target="_blank" rel="nofollow" style="color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;">El Tiempo en Madrid</a></span><script type="text/javascript" async src="https://www.tiempo.com/wid_loader/39a6238c3e6e86a90fc698469b7b84dd"></script></div>
                            </div>
                            <div class="item">
                                <div id="cont_0ff4369480fb1fa4aacdce167d76b3fd">
                                    <span id="h_0ff4369480fb1fa4aacdce167d76b3fd">
                                        <a id="a_0ff4369480fb1fa4aacdce167d76b3fd" href="http://www.tiempo.com/tokio.htm" target="_blank" rel="nofollow" style="color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;">El Tiempo en Tokio</a>
                                    </span>
                                    <script type="text/javascript" async src="https://www.tiempo.com/wid_loader/0ff4369480fb1fa4aacdce167d76b3fd"></script>
                                </div>
                            </div>
                            <div class="item">
                                <div id="cont_cc6126bfb94adfdff4087e8ab9756833"><span id="h_cc6126bfb94adfdff4087e8ab9756833"><a id="a_cc6126bfb94adfdff4087e8ab9756833" href="http://www.tiempo.com/nueva-york-aeropuerto-internacional-kennedy.htm" target="_blank" rel="nofollow" style="color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;">El Tiempo en Aeropuerto Internacional Kennedy Nueva York</a></span><script type="text/javascript" async src="https://www.tiempo.com/wid_loader/cc6126bfb94adfdff4087e8ab9756833"></script></div>
                            </div>
                            <div class="item">
                                <div id="cont_eae8921345c6415363687f4b6f127563"><span id="h_eae8921345c6415363687f4b6f127563"><a id="a_eae8921345c6415363687f4b6f127563" href="http://www.tiempo.com/paris.htm" target="_blank" rel="nofollow" style="color: #00ABEB; font-family: 8; font-size: 13px; text-decoration: none;">El Tiempo en Par&iacute;s</a></span><script type="text/javascript" async src="https://www.tiempo.com/wid_loader/eae8921345c6415363687f4b6f127563"></script></div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <nav class="navbar navbar-inverse" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="navbar-ex1-collapse">
                                <span class="sr-only">Desplegar navegación</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="collapse navbar-collapse navbar-ex1-collapse navbar-static-top">
                            <ul class="nav navbar-nav ">
                                <li ><a href="../index.jsp">Inicio</a></li>
                                <li class="active"><a href="Facturacion.jsp">Facturación</a></li>
                                <li><a href="Volar.jsp">Volar</a></li>
                                <li><a href="misReservas.jsp">Mis reservas</a></li>
                            </ul>
                            <% if (user != null) { %>
                            <form class=" form-inline  formularioUser" role="form" action="/NavisLines/ServletSalir">
                                <span class="text-success"  style="margin-left:23%">Bienvenido</span> <span class="text-warning" style="margin-right: 2%"><strong><%out.print(user.getNombreCompleto());%></strong></span>
                                <input type="submit" class="btn btn-danger btn-md form-control botonUser" value="Salir">
                            </form>
                            <% }%>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <form  role="form" name="Pagar" id="Pagar" action="/NavisLines/DistpacherFacturar">
                            <table class="table table-responsive table-striped table-hover">
                                <tbody>
                                    <tr style="color:buttonshadow">
                                        <th>Vuelo</th>
                                        <th>Origen</th>
                                        <th>Destino</th>
                                        <th>Estado</th>
                                    </tr>
                                    <% for (int i = 0; i < ocupaciones.size(); i++) {
                                            ArrayList<Ocupacion> ocp = (ArrayList) ocupaciones.get(i);
                                    %>
                                    <tr>
                                        <td>
                                            <%out.print(ocp.get(0).getVuelo().getNum_vuelo());%>
                                        </td>
                                        <td>
                                            <%out.print(ocp.get(0).getVuelo().getViaje().getOrigen().getIATA());%>
                                        </td>
                                        <td>
                                            <%out.print(ocp.get(0).getVuelo().getViaje().getDestino().getIATA());%>
                                        </td>
                                        <%if (ocp.get(0).getFacturado() == 0) { %>
                                        <td>
                                            <button type="submit" class="btn btn-success center-block form-control botonUser" id="botonSiguiente" name="facturar" value="<%out.print(ocp.get(0).getVuelo().getCodigo());%>">Facturar</button>
                                        </td>
                                        <% } else { %>
                                        <td style="color:red">
                                            FACTURADO
                                        </td>
                                        <% } %>
                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>
                        </form>
                        <div class="panel-footer"> <button type="button" class="btn btn-success" onclick="window.location = '../index.jsp'">Inicio</button>
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
    </body>
</html>
