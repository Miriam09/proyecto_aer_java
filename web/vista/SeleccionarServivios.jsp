<%-- 
    Document   : index
    Created on : 19-ene-2016, 9:40:46
    Author     : Miriam
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Carrito carrito = (Carrito) session.getAttribute("carrito");
    Cliente user = (Cliente) session.getAttribute("cliente");
    int adultos = carrito.getNumAdultos();
    int ninos = carrito.getNumNinos();
    int bebes = carrito.getNumBebe();
    ArrayList<Pasajero> arrayPasajeros = carrito.getReserva().getPasajeros();
    ArrayList<Bebe> arrayBebe = carrito.getReserva().getBebes();
    ArrayList<Servicio> servicios = (ArrayList<Servicio>) session.getAttribute("servicios");
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
            select:required:invalid {
                color: gray;
            }
            option[value=""][disabled] {
                display: none;
            }
            option {
                color: black;
            }
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
                    </div>
                </div>
            </header>
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <nav class="navbar navbar-inverse" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                                <span class="sr-only">Desplegar navegación</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="collapse navbar-collapse navbar-ex1-collapse navbar-static-top">
                            <ul class="nav navbar-nav ">
                                <li><a href="../index.jsp">Inicio</a></li>
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
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-9">
                        <form  role="form" id="formularioPasajeros" action="/NavisLines/ServletRecogerServicios">
                            <h3>Servicios</h3>
                            <% int pas = 0;
                                for (int i = 1; i <= arrayPasajeros.size(); i++, pas++) {
                                    if (i == 1) {
                            %>
                            <div class="row" id="pasajero<%out.print(i);%>" >
                                <% } else { %>
                                <div class="row" id="pasajero<%out.print(i);%>" style="display:none">
                                    <% } %>
                                    <div class="row">
                                        <div class="col-md-1"></div>
                                        <div class="col-md-11">
                                            <h3>
                                                <span class="label label-default"> <%out.print(arrayPasajeros.get(pas).getNombre() + " " + arrayPasajeros.get(pas).getApellidos());%></span>
                                            </h3>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <table class="table table-responsive table-hover">
                                                <tbody>
                                                    <tr>
                                                        <th colspan="3">Servicios de ida</th>
                                                    </tr>
                                                    <tr>
                                                        <td></td>
                                                        <td>Servicio</td>
                                                        <td>Precio</td>
                                                    </tr>
                                                    <% for (int se = 0; se < servicios.size(); se++) { %>
                                                    <tr>
                                                        <td class="info"> 
                                                            <% if (bebes > 0) {
                                                                    for (int t = 0; t < bebes; t++) {
                                                                        if (arrayBebe.get(t).getTutor().getNif() == arrayPasajeros.get(pas).getNif() && servicios.get(se).getCodigo() == 6) {%>
                                                            <input type="checkbox" name="<%out.print("serviciosIda" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>
                                                            <% }
                                                                }
                                                                if (servicios.get(se).getCodigo() == 6) {
                                                                } else if (servicios.get(se).getCodigo() == 2) { %>
                                                            <input type="radio" name="<% out.print("serviciosIdaAsiento" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>
                                                            <% } else if (servicios.get(se).getCodigo() == 3) {%>
                                                            <input type="radio" name="<% out.print("serviciosIdaAsiento" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% } else if (servicios.get(se).getCodigo() == 4) { %>
                                                            <input type="radio" name="<% out.print("serviciosIdaMaleta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>
                                                            <% } else if (servicios.get(se).getCodigo() == 5) { %>
                                                            <input type="radio" name="<% out.print("serviciosIdaMaleta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% } else { %>
                                                            <input type="checkbox" name="<% out.print("serviciosIda" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% }
                                                            } else {
                                                                if (servicios.get(se).getCodigo() == 6) {
                                                                } else if (servicios.get(se).getCodigo() == 2) { %>
                                                            <input type="radio" name="<% out.print("serviciosIdaAsiento" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>
                                                            <% } else if (servicios.get(se).getCodigo() == 3) {%>
                                                            <input type="radio" name="<% out.print("serviciosIdaAsiento" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% } else if (servicios.get(se).getCodigo() == 4) { %>
                                                            <input type="radio" name="<% out.print("serviciosIdaMaleta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>
                                                            <% } else if (servicios.get(se).getCodigo() == 5) { %>
                                                            <input type="radio" name="<% out.print("serviciosIdaMaleta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% } else { %>
                                                            <input type="checkbox" name="<% out.print("serviciosIda" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% }
                                                                }%>
                                                        </td>
                                                        <td>
                                                            <% out.print(servicios.get(se).getDescripcion());%>
                                                        </td>
                                                        <td>
                                                            <% out.print(servicios.get(se).getPrecio());%>
                                                        </td>
                                                    </tr>
                                                    <%  }%>
                                                </tbody>
                                            </table>
                                        </div>
                                        <%if ((carrito.getReserva().getVuelta()) != null) {%>
                                        <div class="col-md-6">
                                            <table class="table table-responsive table-hover">
                                                <tbody>
                                                    <tr>
                                                        <th colspan="3">Servicios de vuelta</th>
                                                    </tr>
                                                    <tr>
                                                        <td></td>
                                                        <td>Servicio</td>
                                                        <td>Precio</td>
                                                    </tr>
                                                    <% for (int se = 0; se < servicios.size(); se++) { %>
                                                    <tr>
                                                        <td class="info "> 
                                                            <% if (bebes > 0) {
                                                                    for (int t = 0; t < bebes; t++) {
                                                                        if (arrayBebe.get(t).getTutor().getNif() == arrayPasajeros.get(pas).getNif() && servicios.get(se).getCodigo() == 6) {%>
                                                            <input type="checkbox" name="<%out.print("serviciosVuelta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>
                                                            <%
                                                                    }
                                                                }
                                                                if (servicios.get(se).getCodigo() == 6) {
                                                                } else if (servicios.get(se).getCodigo() == 2) { %>
                                                            <input type="radio" name="<%out.print("serviciosVueltaAsiento" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>

                                                            <% } else if (servicios.get(se).getCodigo() == 3) {%>
                                                            <input type="radio" name="<%out.print("serviciosVueltaAsiento" + i);%>"value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% } else if (servicios.get(se).getCodigo() == 4) { %>
                                                            <input type="radio" name="<%out.print("serviciosVueltaMaleta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>
                                                            <% } else if (servicios.get(se).getCodigo() == 5) { %>
                                                            <input type="radio" name="<%out.print("serviciosVueltaMaleta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% } else { %>
                                                            <input type="checkbox" name="<% out.print("serviciosVuelta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">

                                                            <% }
                                                            } else {
                                                                if (servicios.get(se).getCodigo() == 6) {
                                                                } else if (servicios.get(se).getCodigo() == 2) { %>
                                                            <input type="radio" name="<%out.print("serviciosVueltaAsiento" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>

                                                            <% } else if (servicios.get(se).getCodigo() == 3) {%>
                                                            <input type="radio" name="<%out.print("serviciosVueltaAsiento" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% } else if (servicios.get(se).getCodigo() == 4) { %>
                                                            <input type="radio" name="<%out.print("serviciosVueltaMaleta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>" checked>
                                                            <% } else if (servicios.get(se).getCodigo() == 5) { %>
                                                            <input type="radio" name="<%out.print("serviciosVueltaMaleta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">
                                                            <% } else { %>
                                                            <input type="checkbox" name="<% out.print("serviciosVuelta" + i);%>" value="<% out.print(servicios.get(se).getCodigo());%>">

                                                            <% }
                                                                }%>
                                                        </td>
                                                        <td>
                                                            <% out.print(servicios.get(se).getDescripcion());%>
                                                        </td>
                                                        <td>
                                                            <% out.print(servicios.get(se).getPrecio());%>
                                                        </td>
                                                    </tr>
                                                    <% } %>
                                                </tbody>
                                            </table>
                                        </div>
                                        <% } %>
                                    </div>
                                </div>
                                <% }%>


                                <% if (arrayPasajeros.size() > 1) { %>
                                <div class="row"><button type="submit" class="btn btn-success center-block" id="botonSiguiente" style="display: none">Siguiente</button>
                                    <% } else {%>
                                    <div class="row"><button type="submit" class="btn btn-success center-block" id="botonSiguiente" >Siguiente</button>

                                        <% } %>
                                    </div>
                                    <div class="row ">
                                        <div class="col-md-3"></div>
                                        <div class="col-md-6 ">
                                            <ul class="pagination pagination-lg center-block">
                                                <li class="disabled">
                                                    <span>&laquo;</span>
                                                </li>
                                                <% for (int p = 1; p <= arrayPasajeros.size(); p++) {
                                                        if (p == 1) {
                                                %>
                                                <li class="active" id="pagina<%out.print(p);%>" onclick="siguientePagina(<% out.print(p);%>, <% out.print(arrayPasajeros.size());%>)"><span><%out.print(p);%></span></li>
                                                        <% } else { %>
                                                <li id="pagina<%out.print(p);%>" onclick="siguientePagina(<% out.print(p);%>, <% out.print(arrayPasajeros.size());%>)"><span><%out.print(p);%></span></li>
                                                        <% }
                                                            } %>
                                                <li class="disabled">
                                                    <span>&raquo;</span>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    </form>

                                </div>
                                <div class="col-md-3">
                                    <div class="well">

                                        <h4  class="text-center">Proceso de reserva</h4>
                                        <div class="row ">
                                            <p><%out.println(carrito.getReserva().getIda().toString());%></p>  
                                        </div>
                                        <div class="row">
                                            <p>Adultos  x <%out.println(adultos);%> -------- <%out.println(adultos+" x "+(carrito.getReserva().getIda().getPrecio())+"€");%><small>Ida</small></p>
                                            <%if((carrito.getReserva().getVuelta())!=null){%>
                                            <p>Adultos  x <%out.println(adultos);%> -------- <%out.println(adultos+" x "+(carrito.getReserva().getVuelta().getPrecio())+"€");%><small>Vuelta</small></p>
                                            <%} if (ninos>0){%>
                                            <p>Niños  x <%out.println(ninos);%> -------- <%out.println(ninos+" x "+(carrito.getReserva().getIda().getPrecio())+"€");%><small>Ida</small></p>
                                            <%if((carrito.getReserva().getVuelta())!=null){%>
                                            <p>Niños  x <%out.println(ninos);%> -------- <%out.println(ninos+" x "+(carrito.getReserva().getVuelta().getPrecio())+"€");%><small>Vuelta</small></p>

                                            <% } }if(bebes>0){ %>
                                            <p>Bebés  x <%out.println(bebes);%>25€ <small>Ida</small></p>
                                            <%if((carrito.getReserva().getVuelta())!=null){%>
                                            <p>Bebés  x <%out.println(bebes);%>25€ <small>Vuelta</small></p>
                                            <%}}%>
                                        </div>
                                        <hr>
                                        <%if((carrito.getReserva().getVuelta())!=null){%>
                                        <span class="lead">TOTAL: </span><span><%out.println(((adultos+ninos)*carrito.getReserva().getIda().getPrecio())+((adultos+ninos)*carrito.getReserva().getVuelta().getPrecio())+(bebes*25)*2+"€");%></span>
                                        <% } else{ %>
                                        <span class="lead">TOTAL: </span><span><%out.println((adultos+ninos)*carrito.getReserva().getIda().getPrecio()+bebes*25+"€");%></span>

                                        <%}%>
                                    </div>
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
