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
                                <li><a href="../index.jsp">Inicio</a></li>
                                <li  class="active"> <a href="Facturacion.jsp">Facturación</a></li>
                                <li><a href="Volar.jsp">Volar</a></li>
                                <li><a href="misReservas.jsp">Mis reservas</a></li>
                            </ul>

                        </div>
                    </nav>
                </div>
            </div>
            <div class="container-fluid">
                <br/>
                <br/>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6 well">
                        <form  role="form" name="Pagar" id="Pagar" action="/NavisLines/ServletBookingCode">
                            <div class="row ">
                                <div class="col-md-2"></div>
                                <div class="col-md-2"><small>Booking Code</small></div>
                                <div class="col-md-4"><input type="text" class="form-control" id="bk" name="bk" required></div>
                                <hr>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-5"><input type="email" class="form-control" placeholder="correo electronico" id="mail" name="mail"  required></div>
                                <div class="col-md-5"><input type="password" class="form-control" placeholder="contraseña" id="pass" name="pass"  required></div>

                            </div>
                            <div class="row">

                            </div>


                            <br/>

                            <button type="submit" class="btn btn-info center-block form-control botonUser" id="botonSiguiente" >Facturar</button>
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
