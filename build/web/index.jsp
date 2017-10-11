<%-- 
    Document   : index
    Created on : 19-ene-2016, 9:40:46
    Author     : Miriam
--%>

<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    Cliente user = (Cliente) session.getAttribute("cliente");

%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="icon" type="image/jpg" href="images/iconoNavi.png" />
        <link rel="stylesheet" href="css/style.css">
        <script src="js/script.js"></script>
        <title>Navi´s Line</title>
    </head>
    <body>
        <div class="container-fluid">
            <br/>
            <header class="row">
                <div class="col-md-3">
                    <a href="index.jsp" ><img src="images/naviLogoHorizontal2-medio.png" alt="navi" class="img-responsive centrar img-rounded"></a>
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
                                <li class="active"><a href="index.jsp">Inicio</a></li>
                                <li><a href="vista/Facturacion.jsp">Facturación</a></li>
                                <li><a href="vista/Volar.jsp">Volar</a></li>
                                <li><a href="vista/misReservas.jsp">Mis reservas</a></li>
                            </ul>
                            <% if (user != null) {%>
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
                    <form role="form" action="/NavisLines/ServletReserva1">
                        <div class="col-md-5 primerFormulario center-block">

                            <div class="form-group-sm well">
                                <div class="row">
                                    <div class="col-md-6 ">
                                        <label for="origen">Origen</label>
                                        <script>cargarOrigen();</script>
                                        <select class="form-control" id="origen" name="origen" onchange="cargarDestino(this.value)" required>
                                        </select>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="destino">Destino</label>
                                        <select class="form-control" id="destino" name="destino" required>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-1"></div>
                                    <div class="checkbox col-md-5">
                                        <label>
                                            <input type="radio" name="idaVuelta" id="ida" value="ida" onclick="desactivarVuelta()"  checked> Sólo ida
                                        </label>
                                    </div>
                                    <div class="col-md-1"></div>
                                    <div class="checkbox col-md-5">
                                        <label>
                                            <input type="radio" name="idaVuelta"  id="vuelta" value="idaYvuelta" onclick="activarVuelta()"> Ida y vuelta
                                        </label>
                                    </div>
                                </div>
                                <div class="row ">
                                    <div class="col-md-6">
                                        <label for="fechaSalida">Fecha ida</label>
                                        <div class="input-group date" data-provide="datepicker">
                                            <input  name="fechaSalida" class="form-control ui-selectmenu-text" data-date-format="yyyy-mm-dd"  id="fechaSalida" >
                                            <div class="input-group-addon">
                                                <span class="glyphicon glyphicon-th"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="destino">Fecha vuelta</label>
                                        <div class="input-group date" data-provide="datepicker">
                                            <input  name="fechaVuelta" class="form-control ui-selectmenu-text" data-date-format="yyyy-mm-dd"  id="fechaVuelta" disabled="disabled">
                                            <div class="input-group-addon">
                                                <span class="glyphicon glyphicon-th"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br/>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="control-label" for="adultos"> Adultos </label>
                                            <input type="number" name="adultos" id="adultos" class="form-control" min="1"  placeholder="1" value="1" onchange="comprobarNinos()" required>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="control-label" for="ninos">Niños</label>
                                            <input type="number" name="ninos" id="ninos" class="form-control" min="0"  placeholder="0" value="0" onchange="comprobarNinos()">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="control-label" for="bebes">Bebés</label>
                                            <input type="number" name="bebes" id="bebes" class="form-control" min="0"  placeholder="0" value="0" onchange="comprobarNinos()">
                                        </div>
                                    </div>
                                </div>
                                <br/>
                                <div class="row">
                                    <div class="col-md-4"></div>
                                    <div class="col-md-4">
                                        <input type="button" class="btn btn-info" value="Buscar vuelos" onclick="cargarVuelos()">
                                    </div>
                                    <div class="col-md-4"></div>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-7">
                            <div class="row" id="tablaVuelos">
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
                                            <img src="images/carouselCiudades/Madrid2.jpg" alt="madrid" class="img-responsive">
                                        </div>
                                        <div class="item">
                                            <img src="images/carouselCiudades/japon2.jpg" alt="japon" class="img-responsive">
                                        </div>
                                        <div class="item">
                                            <img src="images/carouselCiudades/newYork2.jpg" alt="newyYork" class="img-responsive">
                                        </div>
                                        <div class="item">
                                            <img src="images/carouselCiudades/paris2.jpg" alt="paris" class="img-responsive">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- <h1>Navi´s Lines</h1> -->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/jquery-ui.structure.css">
        <link rel="stylesheet" href="css/jquery-ui.theme.css">
        <script src="js/jquery-ui.js"></script>

        <script>


                                            $(function () {
                                                $("#fechaSalida").datepicker({
                                                    dateFormat: "yy-mm-dd",
                                                    autoclose: true,
                                                    onClose: function (selectedDate) {
                                                        $("#fechaVuelta").datepicker("option", "minDate", selectedDate);
                                                    }
                                                });
                                                $("#fechaVuelta").datepicker({
                                                    dateFormat: "yy-mm-dd",
                                                    autoclose: true,
                                                    onClose: function (selectedDate) {
                                                        $("#fechaSalida").datepicker("option", "maxDate", selectedDate);
                                                    }
                                                });
                                            });
        </script>


    </body>
</html>
