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
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <form  role="form" name="Pagar" id="Pagar" action="/NavisLines/RealizarPago">
                            <div class="well">
                                <div class="row">
                                    <div id="numTarj" >
                                        <div class="col-md-1"></div>
                                        <div class="col-md-2"><small>Nº Tarjeta</small></div>
                                        <div class="col-md-2"><input type="number" class="form-control" id="nT1" name="nT1" min="0" max="9999" required></div>
                                        <div class="col-md-2"><input type="number" class="form-control" id="nT2" name="nT2" min="0" max="9999" required></div>
                                        <div class="col-md-2"><input type="number" class="form-control" id="nT3" name="nT3" min="0" max="9999" required></div>
                                        <div class="col-md-2"><input type="number" class="form-control" id="nT4" name="nT4" min="0" max="9999" required onfocusout="validarTarjeta()"></div>
                                    </div>
                                </div>
                                <br/>
                                <div class="row center-block">
                                    <div class="col-md-1"></div>
                                    <div class="col-md-1"><small>CCV:</small></div>
                                    <div class="col-md-2"><input type="number" class="form-control" placeholder="CVV" id="CVV" name="CVV" min="0" max="999" required></div>
                                    <div class="col-md-3"><small>Caducidad tarjeta: </small></div>
                                    <div class="col-md-5">
                                        <div id="caduTar">
                                            <div class="col-md-4"><input type="number" class="form-control" id="mes" name="mes" min="1" max="12" required></div>
                                            <dv class="col-md-2">/</dv>
                                            <div class="col-md-4 "><input type="number" class="form-control " id="year" name="year" min="1" max="99" required onfocusout="caducidadTarjeta(this.id)"></div>
                                        </div>
                                    </div>
                                </div>
                                <br/>
                                <div class="row center-block">
                                    <div class="col-md-2"></div>
                                    <div class="col-md-2"><small>Tipo tarjeta</small></div>
                                    <div class="col-md-2"><label class="radio-inline">
                                            <input type="radio"  id="tipoTarjeta1" name="tipoTarjeta" value="Visa" required/> <img src="../images/visa.png" class="img img-responsive" width="50px">
                                        </label></div>
                                    <div class="col-md-1"></div>
                                    <div class="col-md-2"><label class="radio-inline">
                                            <input type="radio"  id="tipoTarjeta2" name="tipoTarjeta" value="MasterCard" required/> <img src="../images/mastercard.png" class="img img-responsive" width="50px">
                                        </label></div>
                                </div>
                                <br/>
                                <div class="row" style="display:none" id="alertaTarjeta">
                                    <div class="col-md-12    ">
                                        <div class=" alert alert-danger  alert-dismissable">
                                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                                            <strong>¡Error!</strong> El número de tarjeta no es válido.
                                        </div>

                                    </div>
                                </div>
                                <div class="row" style="display:none" id="alertaCampos">
                                    <div class="col-md-12    ">
                                        <div class=" alert alert-warning  alert-dismissable">
                                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                                            <strong>¡Advertencia!</strong> Todos los campos deben estar rellenos.
                                        </div>

                                    </div>
                                </div>

                            </div>
                            <button type="submit" class="btn btn-info center-block form-control botonUser" id="botonSiguiente" >Confirmar reserva</button>
                            <!--onclick="validarTarjeta(this.form.nT1.value)"-->
                        </form>
                    </div>
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
