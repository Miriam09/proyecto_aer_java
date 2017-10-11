<%-- 
    Document   : index
    Created on : 19-ene-2016, 9:40:46
    Author     : Miriam
--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Carrito carrito = (Carrito) session.getAttribute("carrito");
    Cliente user = (Cliente) session.getAttribute("cliente");
    double totalIda = (Double) session.getAttribute("totalIda");

    ArrayList<Bebe> arrayBebes = carrito.getReserva().getBebes();
    double totalVuelta = 0;
    double totalVueltaServicios = 0;
    double TotalFinal = carrito.getReserva().getPago().getImporteTotal();
//    double TotalFinal = totalIdaServicios;
    Vuelo vueloIda = carrito.getReserva().getIda();
    Vuelo vueloVuelta = null;
    int adultos = carrito.getNumAdultos();
    int ninos = carrito.getNumNinos();
    int bebes = carrito.getNumBebe();

    DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("d MMMM, yyyy");
    ArrayList<Pasajero> arrayPasajeros = carrito.getReserva().getPasajeros();
    ArrayList<Ocupacion> arrayOcupacionIda = carrito.getReserva().getIda().getArrayOcupacion();
    ArrayList<Ocupacion> arrayOcupacionVuelta = null;
    if (carrito.getReserva().getVuelta() != null) {

        vueloVuelta = carrito.getReserva().getVuelta();
        totalVuelta = (Double) session.getAttribute("totalVuelta");
//        totalVueltaServicios = (Double) session.getAttribute("totalVueltaServicios");
//
//        TotalFinal += totalVueltaServicios;
        arrayOcupacionVuelta = vueloVuelta.getArrayOcupacion();

    }

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
        <style>

        </style>



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
                        <!-- Left and right controls -->
                        <!-- <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                          <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                          <span class="sr-only">Next</span>
                        </a> -->
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
                            <!-- <span class="letra-logo">Navi´s</span> <span class="letra-logo">Lines</span>-->
                            <!-- <a href="index.html" class="navbar-brand"><img src="images/naviLogoHorizontal2-mini.png" alt="navi" class="img-responsive logo"></a> -->
                        </div>
                        <div class="collapse navbar-collapse navbar-ex1-collapse navbar-static-top">
                            <ul class="nav navbar-nav ">
                                <li ><a href="../index.jsp">Inicio</a></li>
                                <li><a href="Facturacion.jsp">Facturación</a></li>
                                <li><a href="Volar.jsp">Volar</a></li>
                                <li><a href="misReservas.jsp">Mis reservas</a></li>
                                <li class="active"><a href="#">Reserva de vuelo</a></li>
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
            <div class="container">
                <div class="row">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Resumen de la Reserva</h3>
                        </div>
                        <div class="panel-body">
                            <div class="well">
                                <span class="row">
                                    <div class="col-md-3">
                                        <p ><strong>Ida - <%out.print(vueloIda.getFecha_salida().format(fechaFormato));%></strong></p>
                                    </div>
                                
                                
                                    <div class="col-md-4">
                                        <span class="pull-left">Hora salida: <% out.print(vueloIda.getHora_salida());%><br/><small><%out.print(vueloIda.getViaje().getOrigen().getNombre());%>, <%out.print(vueloIda.getViaje().getOrigen().getCiudad());%>, (<%out.print(vueloIda.getViaje().getOrigen().getIATA());%>)</small></span>
                                    </div>
                                     <span class="col-md-1"></span>
                                    <div class="col-md-4">
                                        <span class="pull-right">Hora llegada: <% out.print((vueloIda.getDuracion()));%><br/><small><%out.print(vueloIda.getViaje().getDestino().getNombre());%>, <%out.print(vueloIda.getViaje().getDestino().getCiudad());%>, (<%out.print(vueloIda.getViaje().getDestino().getIATA());%>)</small></span>
                                    </div>
                               </span>

                                <% if (vueloVuelta != null) {%>
                                <hr>
                                <span class="row">
                                    <span class="col-md-3">
                                        <p><strong>Vuelta - <%out.print(vueloVuelta.getFecha_salida().format(fechaFormato));%></strong></p>

                                    </span>
                                
                                
                                    <span class="col-md-4">
                                        <span class="pull-left">Hora salida: <% out.print(vueloVuelta.getHora_salida());%><br/><small><%out.print(vueloVuelta.getViaje().getOrigen().getNombre());%>, <%out.print(vueloVuelta.getViaje().getOrigen().getCiudad());%>, (<%out.print(vueloVuelta.getViaje().getOrigen().getIATA());%>)</small></span>
                                    </span>
                                    <span class="col-md-1"></span>
                                    <span class="col-md-4">
                                        <span class="pull-rigth">Hora llegada: <% out.print((vueloVuelta.getDuracion()));%><br/><small> <%out.print(vueloVuelta.getViaje().getDestino().getNombre());%>,<%out.print(vueloVuelta.getViaje().getDestino().getCiudad());%>, (<%out.print(vueloVuelta.getViaje().getDestino().getIATA());%>)</small></span>

                                    </span>
                                </span>

                                <% } %>
                            </div>
                            <h5>Pasajeros: <%out.print(adultos + ninos);%></h5>
                            <% if (bebes > 0) {%>
                            <h5>Bebes: <%out.print(bebes);%></h5>
                            <% }%>

                            <p>Precio total:  <span class="h3"><% out.print(TotalFinal);%>€</span></p>
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h4 class="panel-title">Descripcion</h4>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-4">Precio Ida</div>
                                        <div class="col-md-4"><small><%out.print(adultos + ninos);%> Viajero x <%out.print(vueloIda.getPrecio());%>€</small></div>
                                        <div class="col-md-4"><%out.print(totalIda);%>€</div>
                                    </div>

                                    <%for (int p = 0; p < arrayOcupacionIda.size(); p++) {
                                            if (arrayOcupacionIda.get(p).getPasajero() != null) {%>
                                    <div class="row">
                                        <div class="col-md-1"></div>
                                        <div class="col-md-11">
                                            <div class="row">
                                                <p>Pasajero <% out.print(arrayOcupacionIda.get(p).getPasajero().getNif());%>, <% out.print(arrayOcupacionIda.get(p).getPasajero().getNombre());%> <% out.print(arrayOcupacionIda.get(p).getPasajero().getApellidos());%></p>
                                            </div>
                                            <% for (int se = 0; se < arrayOcupacionIda.get(p).getPasajero().getServicios().size(); se++) {
                                                    if (arrayOcupacionIda.get(p).getPasajero().getServicios().get(se).getCodigo() == 6) { %>
                                            <div class="row">
                                                <div class="col-md-1"></div>
                                                <div class="col-md-7">
                                                    <% for (int b = 0; b < arrayBebes.size(); b++) {
                                                            if (arrayBebes.get(b).getTutor().getNif().equals(arrayOcupacionIda.get(p).getPasajero().getNif())) { %>
                                                    <p><% out.print(arrayOcupacionIda.get(p).getPasajero().getServicios().get(se).getSiglas());%> - <% out.print(arrayBebes.get(b).getNif()); %> </p>
                                                    <p><% out.print(arrayBebes.get(b).getNombre()); %> <% out.print(arrayBebes.get(b).getApellidos()); %></p>
                                                    <% }
                                                        }%>
                                                </div>
                                                <div class="col-md-3">
                                                    <p><% out.print(arrayOcupacionIda.get(p).getPasajero().getServicios().get(se).getPrecio());%></p>
                                                </div>
                                            </div>
                                            <% } else { %>
                                            <div class="row">
                                                <div class="col-md-1"></div>
                                                <div class="col-md-5">
                                                    <p><% out.print(arrayOcupacionIda.get(p).getPasajero().getServicios().get(se).getDescripcion());%></p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p><% out.print(arrayOcupacionIda.get(p).getPasajero().getServicios().get(se).getPrecio());%></p>
                                                </div>
                                            </div>
                                            <% }
                                                } %>
                                        </div>
                                    </div>

                                    <% }
                                        } %>
                                    <% if (carrito.getReserva().getVuelta() != null) { %>
                                    <div class="row">
                                        <div class="col-md-4">Precio Vuelta</div>
                                        <div class="col-md-4"><small><%out.print(adultos + ninos);%> Viajero x <%out.print(vueloVuelta.getPrecio());%>€</small></div>
                                        <div class="col-md-4"><%out.print(totalVuelta);%>€</div>
                                    </div>

                                    <%for (int p = 0; p < arrayOcupacionVuelta.size(); p++) {
                                            if (arrayOcupacionVuelta.get(p).getPasajero() != null) {%>
                                    <div class="row">
                                        <div class="col-md-1"></div>
                                        <div class="col-md-11">
                                            <div class="row">
                                                <p>Pasajero <% out.print(arrayOcupacionVuelta.get(p).getPasajero().getNif());%></p>
                                            </div>
                                            <% for (int se = 0; se < arrayOcupacionVuelta.get(p).getPasajero().getServicios().size(); se++) {
                                                    if (arrayOcupacionVuelta.get(p).getPasajero().getServicios().get(se).getCodigo() == 6) { %>
                                            <div class="row">
                                                <div class="col-md-1"></div>
                                                <div class="col-md-7">
                                                    <% for (int b = 0; b < arrayBebes.size(); b++) {
                                                            if (arrayBebes.get(b).getTutor().getNif().equals(arrayOcupacionVuelta.get(p).getPasajero().getNif())) { %>
                                                    <p><% out.print(arrayOcupacionVuelta.get(p).getPasajero().getServicios().get(se).getSiglas());%> - <% out.print(arrayBebes.get(b).getNif()); %> </p>
                                                    <p><% out.print(arrayBebes.get(b).getNombre()); %> <% out.print(arrayBebes.get(b).getApellidos()); %></p>
                                                    <% }
                                                        }%>
                                                </div>
                                                <div class="col-md-3">
                                                    <p><% out.print(arrayOcupacionVuelta.get(p).getPasajero().getServicios().get(se).getPrecio());%></p>
                                                </div>
                                            </div>
                                            <% } else { %>
                                            <div class="row">
                                                <div class="col-md-1"></div>
                                                <div class="col-md-5">
                                                    <p><% out.print(arrayOcupacionVuelta.get(p).getPasajero().getServicios().get(se).getDescripcion());%></p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p><% out.print(arrayOcupacionVuelta.get(p).getPasajero().getServicios().get(se).getPrecio());%></p>
                                                </div>
                                            </div>
                                            <% }
                                                } %>
                                        </div>
                                    </div>

                                    <% }
                                        }%>
                                    <% }%>
                                </div>

                            </div>
                            <div class="panel-footer"> </div>
                        </div>
                    </div>
                    <form action="/NavisLines/vista/Login_Registro.jsp">
                        <button type="submit" class="btn btn-info center-block form-control botonUser" id="botonSiguiente" >Confirmar reserva</button>
                        <button id="atras" class="btn btn-warning form-control center-block botonUser" onclick="window.location = '../index.html'">Cancelar</button>

                    </form>
                    <br/>


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
        <script>

        </script>
    </body>
</html>
