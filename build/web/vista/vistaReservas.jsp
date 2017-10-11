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
    ArrayList<Reserva> reservas = (ArrayList) session.getAttribute("reservas");
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
                            </button> </div>
                        <div class="collapse navbar-collapse navbar-ex1-collapse navbar-static-top">
                            <ul class="nav navbar-nav ">
                                <li ><a href="../index.jsp">Inicio</a></li>
                                <li><a href="Facturacion.jsp">Facturación</a></li>
                                <li><a href="Volar.jsp">Volar</a></li>
                                <li class="active"><a href="misReservas.jsp">Mis reservas</a></li>
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
                <br/>
                <br/>
                <div class="row">
                    <div class="col-md-3"></div>
                    <%if (reservas.isEmpty()) {%>
                    <div class="col-md-6 well text-center">
                        <h2>
                            No hay reservas
                        </h2>
                        <br/>
                        <button type="button" class="btn  center-block" onclick="window.location = '../index.jsp'">Inicio</button>
                    </div>
                    <% } else { %>
                    <div class="col-md-6 ">
                        <div class="row">
                            <div class="col-md-12">
                                <ul class="list-group">
                                    <li class="listaReserva list-group-item row">
                                        <span class="col-md-4 text-center"><strong>Código reserva  </strong></span>
                                        <span class="col-md-1 text-center"><strong>-</strong></span>
                                        <span class="col-md-3 text-center"><strong> Fecha</strong> </span>
                                        <span class="col-md-1 text-center"><strong>-</strong></span>
                                        <span class="col-md-3 text-center"><strong> Precio total</strong></span>
                                    </li>
                                    <% for (int i = 0; i < reservas.size(); i++) { %>
                                    <li class="list-group-item row listaTabla" onclick="mostrarTabla(this.id)" id="reserva<%out.print(i);%>">
                                        <span class="col-md-4 text-center "><%out.print(reservas.get(i).getPago().getBooking_code());%> - </span>
                                        <span class="col-md-1 text-center "><strong>-</strong></span>
                                        <span class="col-md-3 text-center ">  <%out.print(reservas.get(i).getPago().getFecha());%> - </span>
                                        <span class="col-md-1 text-center "><strong>-</strong></span>
                                        <span class="col-md-3 text-center "> <%out.print(reservas.get(i).getPago().getImporteTotal());%>€</span>
                                    </li>
                                    <li id="reserva<%out.print(i);%>T" class="list-group-item" style="display:none">
                                        <table class="table table-condensed table-responsive table-hover">
                                            <tbody>
                                                <tr >
                                                    <th>Ida</th>
                                                    <th><%out.print(reservas.get(i).getIda().getNum_vuelo());%></th>
                                                    <th><%out.print(reservas.get(i).getIda().getViaje().getOrigen().getIATA());%></th>
                                                    <th><%out.print(reservas.get(i).getIda().getViaje().getDestino().getIATA());%></th>
                                                    <th><%out.print(reservas.get(i).getIda().getPrecio());%>€</th>
                                                </tr>
                                                <% ArrayList<Ocupacion> ocupacion = reservas.get(i).getIda().getArrayOcupacion();
                                                    for (int pas = 0; pas < ocupacion.size(); pas++) {%>
                                                <tr onclick="mostrarTabla(this.id)" id="pasajero<%out.print(i);%><%out.print(pas);%>" class="bg-danger">
                                                    <td colspan="2"><%out.print(ocupacion.get(pas).getPasajero().getApellidos());%>, <%out.print(ocupacion.get(pas).getPasajero().getNombre());%></td>
                                                    <td><%out.print(ocupacion.get(pas).getPasajero().getNif());%></td>
                                                    <td><%out.print(ocupacion.get(pas).getAsiento());%></td>
                                                    <td><%out.print((ocupacion.get(pas).getImporte()) - (reservas.get(i).getIda().getPrecio()));%>€</td>
                                                </tr>
                                                <tr id="pasajero<%out.print(i);%><%out.print(pas);%>T" style="display:none">
                                                    <td colspan="5">
                                                        <table class="table table-responsive table-condensed table-striped table-hover" >
                                                            <tbody>
                                                                <% Pasajero pasajero = ocupacion.get(pas).getPasajero();
                                                                    for (int ser = 0; ser < pasajero.getServicios().size(); ser++) {
                                                                        if (pasajero.getServicios().get(ser).getSiglas().equals("B")) {
                                                                            for (int b = 0; b < reservas.get(i).getBebes().size(); b++) {
                                                                                if (reservas.get(i).getBebes().get(b).getTutor().getCodigo() == pasajero.getCodigo()) {
                                                                %>
                                                                <tr>
                                                                    <td colspan="2"><%out.print(pasajero.getServicios().get(ser).getSiglas());%></td>
                                                                    <td><%out.print(reservas.get(i).getBebes().get(b).getApellidos());%>, <%out.print(reservas.get(i).getBebes().get(b).getApellidos());%></td>
                                                                    <td><%out.print(reservas.get(i).getBebes().get(b).getNif());%></td>
                                                                    <td><%out.print(pasajero.getServicios().get(ser).getPrecio());%>€</td>
                                                                </tr>
                                                                <%  }
                                                                    }
                                                                } else { %>
                                                                <tr>
                                                                    <td><%out.print(pasajero.getServicios().get(ser).getSiglas());%></td>
                                                                    <td colspan="3"><%out.print(pasajero.getServicios().get(ser).getDescripcion());%></td>
                                                                    <td><%out.print(pasajero.getServicios().get(ser).getPrecio());%>€</td>
                                                                </tr>
                                                                <% }
                                                                    } %>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                <%}%>
                                                <% if (reservas.get(i).getVuelta().getViaje() != null ) {%>
                                                <tr >
                                                    <th>Vuelta</th>
                                                    <th><%out.print(reservas.get(i).getVuelta().getNum_vuelo());%></th>
                                                    <th><%out.print(reservas.get(i).getVuelta().getViaje().getOrigen().getIATA());%></th>
                                                    <th><%out.print(reservas.get(i).getVuelta().getViaje().getDestino().getIATA());%></th>
                                                    <th><%out.print(reservas.get(i).getVuelta().getPrecio());%>€</th>
                                                </tr>
                                                <% ArrayList<Ocupacion> ocupacionV = reservas.get(i).getVuelta().getArrayOcupacion();
                                                    for (int pas = 0; pas < ocupacionV.size(); pas++) {%>
                                                <tr onclick="mostrarTabla(this.id)" id="pasajero2<%out.print(i);%><%out.print(pas);%>" class="bg-danger">
                                                    <td colspan="2"><%out.print(ocupacionV.get(pas).getPasajero().getApellidos());%>, <%out.print(ocupacionV.get(pas).getPasajero().getNombre());%></td>
                                                    <td><%out.print(ocupacionV.get(pas).getPasajero().getNif());%></td>
                                                    <td><%out.print(ocupacionV.get(pas).getAsiento());%></td>
                                                    <td><%out.print((ocupacionV.get(pas).getImporte()) - (reservas.get(i).getVuelta().getPrecio()));%>€</td>
                                                </tr>
                                                <tr id="pasajero2<%out.print(i);%><%out.print(pas);%>T" style="display:none">
                                                    <td colspan="5">
                                                        <table class="table table-responsive table-condensed table-hover">
                                                            <tbody>
                                                                <% Pasajero pasajero = ocupacionV.get(pas).getPasajero();
                                                                    for (int ser = 0; ser < pasajero.getServicios().size(); ser++) {
                                                                        if (pasajero.getServicios().get(ser).getSiglas().equals("B")) {
                                                                            for (int b = 0; b < reservas.get(i).getBebes().size(); b++) {
                                                                                if (reservas.get(i).getBebes().get(b).getTutor().getCodigo() == pasajero.getCodigo()) {
                                                                %>
                                                                <tr >
                                                                    <td colspan="2"><%out.print(pasajero.getServicios().get(ser).getSiglas());%></td>
                                                                    <td><%out.print(reservas.get(i).getBebes().get(b).getApellidos());%>, <%out.print(reservas.get(i).getBebes().get(b).getApellidos());%></td>
                                                                    <td><%out.print(reservas.get(i).getBebes().get(b).getNif());%></td>
                                                                    <td><%out.print(pasajero.getServicios().get(ser).getPrecio());%>€</td>
                                                                </tr>
                                                                <%  }
                                                                    }
                                                                } else { %>
                                                                <tr>
                                                                    <td><%out.print(pasajero.getServicios().get(ser).getSiglas());%></td>
                                                                    <td colspan="3"><%out.print(pasajero.getServicios().get(ser).getDescripcion());%></td>
                                                                    <td><%out.print(pasajero.getServicios().get(ser).getPrecio());%>€</td>
                                                                </tr>
                                                                <% }
                                                                    } %>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                <%}
                                                    }%>
                                            </tbody>
                                        </table>
                                    </li>
                                    <% }%>
                                </ul>               
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
        <!-- <h1>Navi´s Lines</h1> -->
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../css/jquery-ui.css">
        <link rel="stylesheet" href="../css/jquery-ui.structure.css">
        <link rel="stylesheet" href="../css/jquery-ui.theme.css">
        <script src="../js/jquery-ui.js"></script>
    </body>
</html>
