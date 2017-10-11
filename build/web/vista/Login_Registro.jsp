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
                                <li><a href="Facturacion.jsp">Facturación</a></li>
                                <li><a href="Volar.jsp">Volar</a></li>
                                <li><a href="misReservas.jsp">Mis reservas</a></li>
                                <li  class="active"><a href="#">Acceso</a></li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row ">
                    <br/><br/><br/>
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-md-5">
                                <button type="button" class="btn btn-info btn-lg pull-right" id="login" onclick="mostrarTabla(this.id)">Identifícate</button>

                            </div>
                            <div class="col-md-1">
                                <h2 class="text-center">Ó</h2>
                            </div>
                            <div class="col-md-5">
                                <button type="button" class="btn btn-info btn-lg pull-left" id="registro" onclick="mostrarTabla(this.id)">Regístrate</button>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">

                                <br/><br/>
                                <form  role="form" id="loginT" action="/NavisLines/ServletLogin2" style="display:none">
                                    <div class="row well">
                                        <div class="row">
                                            <div class="col-md-3"></div>
                                            <div class="col-md-6">
                                                <br/>
                                                <input type="email" class="form-control " placeholder="mail" id="usuario" name="usuario" required>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3"></div>
                                            <div class="col-md-6">
                                                <br/>
                                                <input type="password" class="form-control " placeholder="contraseña" id="password" name="password" required >
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-4"></div>
                                            <div class="col-md-4">
                                                <br/>
                                                <button type="submit" class="btn btn-info center-block form-control botonUser" id="botonSiguiente" >Registro</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>


                        <br/>
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6 ">


                                <br/><br/>
                                <form  role="form" id="registroT" action="/NavisLines/RegistrarUsuario" style="display:none" class="well">
                                    <fieldset><legend><h4>Datos personales</h4></legend>
                                        <div class="row">

                                            <div class="col-md-5">
                                                <input type="text" class="form-control " placeholder="Nombre" id="nombre" name="nombre" required>
                                            </div>
                                            <div class="col-md-7">
                                                <input type="text" class="form-control " placeholder="Apellidos" id="apellidos" name="apellidos" required>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-8"></div>
                                            <div class="col-md-4"><small>Fecha de Nacimiento</small></div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-5">
                                                <input type="text" class="form-control " placeholder="Nif" tittle="9 caracteres y una letra mayúscula" id="nif" name="nif" required pattern="(([X-Z]{1})(\d{7})([A-Z]{1}))|((\d{8})([A-Z]{1}))" maxlength="9"> 
                                            </div>
                                            <div class="col-md-1"></div>
                                            <div class="form-group" id="fecha">
                                            <div class="col-md-2">
                                                <input type="text" class="form-control " placeholder="Día" id="dia" name="dia" required maxlength="2" > 
                                            </div>
                                            <div class="col-md-2">
                                                <input type="text" class="form-control " placeholder="Mes" id="mes" name="mes" required maxlength="2"> 
                                            </div>
                                            <div class="col-md-2">
                                                <input type="text" class="form-control " placeholder="Año" id="year" name="year" required maxlength="4" onfocusout="ComprobarYear(this.id)">
                                            </div>
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="row">
                                            <div class="col-md-8">
                                                <input type="email" class="form-control " placeholder="Correo electrónico" id="mail" name="mail" required>
                                            </div>
                                            <div class="col-md-4">
                                                <input type="tel" class="form-control " placeholder="teléfono" id="telefono" name="telefono" required maxlength="9" >
                                            </div>
                                        </div>
                                    </fieldset>
                                    <hr>
                                    <fieldset>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <input type="password" class="form-control " placeholder="Contraseña" id="password2" name="password2"  required>

                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">  
                                                    <input type="password" class="form-control" placeholder="Repetir contraseña" id="password3" name="password3" onfocusout="ComprobarPassword()"  required >
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                    <hr>
                                    <fieldset><legend><h4>Datos de facturación</h4></legend>
<!--                                        <div class="row">
                                            <div class="col-md-2"><small>Nº Tarjeta</small></div>
                                            <div class="col-md-2"><input type="number" class="form-control" id="nT1" name="nT1" min="0" max="9999"></div>
                                            <div class="col-md-2"><input type="number" class="form-control" id="nT2" name="nT2" min="0" max="9999"></div>
                                            <div class="col-md-2"><input type="number" class="form-control" id="nT3" name="nT3" min="0" max="9999"></div>
                                            <div class="col-md-2"><input type="number" class="form-control" id="nT4" name="nT4" min="0" max="9999"></div>
                                            <div class="col-md-2"><input type="number" class="form-control" placeholder="CVV" id="CVV" name="CVV" min="0" max="999"></div>

                                        </div>-->
                                        <!--<br/>-->
<!--                                        <div class="row">
                                            <div class="col-md-3"></div>
                                            <div class="col-md-4"></div>
                                            <div class="col-md-4"><small>tipo tarjeta</small></div>
                                        </div>-->
<!--                                        <div class="row">
                                            <div class="col-md-10">
                                                <div class="col-md-2"><small>caducidad tarjeta</small></div>
                                                <div class="col-md-2"><input type="number" class="form-control" id="nT1" name="nT1" min="1" max="12" placeholder="Mes"></div>

                                                <div class="col-md-2"><input type="number" class="form-control" id="nT2" name="nT2" min="1" max="99" placeholder="Año"></div>
                                                <div class="center-block">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2"><label class="radio-inline">
                                                            <input type="radio"  id="tipoTarjeta1" name="tipoTarjeta" value="Visa" required/> <img src="../images/visa.png" class="img img-responsive" width="50px">
                                                        </label></div>
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2"><label class="radio-inline">
                                                            <input type="radio"  id="tipoTarjeta2" name="tipoTarjeta" value="MasterCard" required/> <img src="../images/mastercard.png" class="img img-responsive" width="50px">
                                                        </label></div>
                                                </div>
                                            </div>
                                        </div>-->
                                        <br/>
                                        <div class="row">
                                            <div class="col-md-2">
                                                <input type="text" class="form-control " placeholder="Tipo vía" id="tvia" name="tvia" required>
                                            </div>
                                            <div class="col-md-10">
                                                <input type="text" class="form-control " placeholder="Nombre vía" id="nvia" name="nvia" required>
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="row">
                                            <div class="col-md-2">
                                                <input type="text" class="form-control " placeholder="Número" id="nuvia" name="nuvia" required>
                                            </div>
                                            <div class="col-md-7">
                                                <input type="text" class="form-control " placeholder="Población" id="poblacion" name="poblacion" required>
                                            </div>
                                            <div class="col-md-3">
                                                <input type="text" class="form-control " placeholder="CP" id="cp" name="cp" required>
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="row">
                                            <div class="col-md-5">
                                                <input type="text" class="form-control " placeholder="Provincia" id="provincia" name="provincia" required>
                                            </div>
                                            <div class="col-md-2"></div>

                                            <div class="col-md-5">
                                                <input type="text" class="form-control " placeholder="País" id="pais" name="pais" required>
                                            </div>
                                        </div>
                                    </fieldset>
                                    <hr>
                                    

                                    <hr>

                                    <button type="submit" class="btn btn-info center-block form-control botonUser" id="botonSiguiente" >Registro</button>
                                </form>
                                <br/>
                            </div>
                        </div>
                        <!--                        <div class="col-md-2"></div>
                                                <div class="col-md-4">
                                                    <form  role="form" id="formularioPasajeros" action="/NavisLines/ServletLogin">
                                                        <input type="text" class="form-control inputUser" placeholder="usuario" id="usuario" name="usuario">
                                                        <input type="text" class="form-control inputUser" placeholder="contraseña" id="password" name="password">
                                                        <button type="submit" class="btn btn-info center-block form-control botonUser" id="botonSiguiente" >Log in</button>
                                                        <input type="button" class="btn btn-info form-control botonUser" value="Log in">
                        
                                                    </form>
                                                </div>-->

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
